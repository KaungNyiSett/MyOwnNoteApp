package com.example.myownnoteapp.feature_note.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myownnoteapp.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.example.myownnoteapp.feature_note.presentation.notes.NotesScreen

@Composable
fun OurNavigation(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Notes_Screen.route
    ){
        composable(
            route = Screen.Notes_Screen.route
        ){
            NotesScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.AEN_Screen.route
        ){
            AddEditNoteScreen(
                navController = navController
            )
        }
    }
}