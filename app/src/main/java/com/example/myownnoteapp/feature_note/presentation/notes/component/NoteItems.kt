package com.example.myownnoteapp.feature_note.presentation.notes.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.myownnoteapp.feature_note.domain.model.Note
import com.example.myownnoteapp.ui.theme.BabyBlue

@Composable
fun NoteItems(
    modifier: Modifier = Modifier.padding(bottom = 16.dp),
    onDeleteClick:() -> Unit = {},
    note: Note
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
            color = Color(note.color)
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(
                    end = 32.dp
                )
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colors.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = note.content,
                style = MaterialTheme.typography.body1,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colors.onSurface
            )
        }
        IconButton(
            modifier = Modifier.align(alignment = Alignment.BottomEnd),
            onClick = {
                onDeleteClick()
            }
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface
            )
        }
    }
}