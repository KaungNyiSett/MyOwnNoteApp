package com.example.myownnoteapp.feature_note.presentation.notes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myownnoteapp.feature_note.presentation.notes.component.NoteItems
import com.example.myownnoteapp.feature_note.presentation.notes.component.OrderSection
import com.example.myownnoteapp.feature_note.presentation.util.Screen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myownnoteapp.feature_note.domain.model.Note
import com.example.myownnoteapp.ui.theme.BabyBlue

@Composable
fun NotesScreen(
    navController: NavController,
    viewModel: NotesViewModel = hiltViewModel()
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    val state: NotesState = viewModel.state.value

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AEN_Screen.route)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Your note",
                    style = MaterialTheme.typography.h4
                )
                IconButton(
                    onClick = {
                        viewModel.onEvent(NotesEvent.ToggleNotesOrder)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Sort,
                        contentDescription = null
                    )
                }
            }
            AnimatedVisibility(
                visible = state.isOrderSectionVisible
            ) {
                OrderSection()
            }
            Spacer(
                modifier = Modifier.height(16.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(state.notes) { note ->
                    NoteItems(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                            },
                        note = note,
                        onDeleteClick = {
                            viewModel.onEvent(NotesEvent.DeleteNote(note))
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )
                }
            }

            /*

              NoteItems(
                  note = Note(
                      title = "Papaya",
                      content = "Hello",
                      color = BabyBlue.toArgb(),
                      timestamp = System.currentTimeMillis()
                  ),
                  modifier = Modifier,
                  onDeleteClick = {}
              )


          */
        }
    }
}