package com.example.myownnoteapp.feature_note.domain.use_cases

data class NoteUseCases(
    val addNote: AddNote,
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
)