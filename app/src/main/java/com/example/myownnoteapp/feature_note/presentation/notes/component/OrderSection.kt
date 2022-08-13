package com.example.myownnoteapp.feature_note.presentation.notes.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OrderSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DefaultRadioButton(
                text = "Title",
                selected = false,
                onSelected = {

                }
            )
            DefaultRadioButton(
                text = "Date",
                selected = false,
                onSelected = {

                }
            )
            DefaultRadioButton(
                text = "Color",
                selected = false,
                onSelected = {

                }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            DefaultRadioButton(
                text = "Ascending",
                selected = false,
                onSelected = {

                }
            )
            DefaultRadioButton(
                text = "Descending",
                selected = false,
                onSelected = {

                }
            )
        }
    }
}