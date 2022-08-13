package com.example.myownnoteapp.feature_note.presentation.add_edit_note

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myownnoteapp.feature_note.domain.model.Note
import com.example.myownnoteapp.feature_note.presentation.add_edit_note.component.TransparentHintTextField
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AddEditNoteScreen(
    navController: NavController
) {

    val viewModel: AddEditNoteViewModel = hiltViewModel()

    val titleState: NoteTextFieldState = viewModel.noteTitle.value

    val contentState: NoteTextFieldState = viewModel.noteContent.value

    val colorState: Int = viewModel.noteColor.value

    val scaffoldState = rememberScaffoldState()
    
    LaunchedEffect(key1 = true){
        viewModel.eventFlow.collectLatest { event ->
            when(event){
                is AddEditNoteViewModel.UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is AddEditNoteViewModel.UiEvent.SaveNote -> {
                    navController.navigateUp()
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color(colorState),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          viewModel.onEvent(AddEditNoteEvent.SaveNote)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = null,
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Circles(
                viewModel = viewModel,
            )
            Spacer(modifier = Modifier.height(16.dp))
            TransparentHintTextField(
                text = titleState.text,
                hint = titleState.hint,
                onValueChange = {
                    viewModel.onEvent(AddEditNoteEvent.EnteredTitle(it))
                },
                onFocusChange = {
                    viewModel.onEvent(AddEditNoteEvent.ChangeTitleFocus(it))
                },
                textStyle = MaterialTheme.typography.h6,
                isHintVisible = titleState.isHintVisible,
                singleLine = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            TransparentHintTextField(
                text = contentState.text,
                hint = contentState.hint,
                onValueChange = {
                    viewModel.onEvent(AddEditNoteEvent.EnteredContent(it))
                },
                onFocusChange = {
                    viewModel.onEvent(AddEditNoteEvent.ChangeContentFocus(it))
                },
                textStyle = MaterialTheme.typography.body1,
                singleLine = false,
                isHintVisible = contentState.isHintVisible,
                modifier = Modifier.fillMaxHeight(),
            )
        }
    }

}

@Composable
fun Circles(
    modifier: Modifier = Modifier,
    viewModel: AddEditNoteViewModel,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Note.noteColors.forEach { color ->
            val colorInt = color.toArgb()
            Box(
                modifier = modifier
                    .size(50.dp)
                    .shadow(
                        elevation = 15.dp,
                        shape = CircleShape
                    )
                    .clip(
                        shape = CircleShape
                    )
                    .background(
                        color = color
                    )
                    .border(
                        width = 5.dp,
                        color = if (viewModel.noteColor.value == colorInt) {
                            Color.Black
                        } else {
                            Color.Transparent
                        },
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(AddEditNoteEvent.ChangeColor(colorInt))
                    }
            )
        }
    }
}
