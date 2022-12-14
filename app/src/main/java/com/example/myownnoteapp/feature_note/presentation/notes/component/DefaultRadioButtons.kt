package com.example.myownnoteapp.feature_note.presentation.notes.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DefaultRadioButton(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onSelected: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colors.primary,
                unselectedColor = MaterialTheme.colors.onBackground
            ),
            onClick = {
                onSelected()
            }
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body1
        )
    }
}