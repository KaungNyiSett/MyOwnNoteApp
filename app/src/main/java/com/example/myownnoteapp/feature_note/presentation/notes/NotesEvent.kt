package com.example.myownnoteapp.feature_note.presentation.notes

import com.example.myownnoteapp.feature_note.domain.model.Note

sealed class NotesEvent {
    data class DeleteNote(val note: Note): NotesEvent()
    object ToggleNotesOrder: NotesEvent()
}