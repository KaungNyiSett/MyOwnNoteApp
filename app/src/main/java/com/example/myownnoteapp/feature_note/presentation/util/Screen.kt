package com.example.myownnoteapp.feature_note.presentation.util

sealed class Screen(val route: String){
    object AEN_Screen: Screen("add_edit_note")
    object Notes_Screen: Screen("notes")
}
