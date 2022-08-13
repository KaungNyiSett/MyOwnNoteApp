package com.example.myownnoteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myownnoteapp.ui.theme.*

@Entity
data class Note(
    val title: String,
    val content: String,
    val color: Int,
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val timestamp: Long
) {
    companion object {
        val noteColors = listOf(
            RedOrange, RedPink, BabyBlue, Violet, LightGreen
        )
    }
}

class InvalidNoteException(message: String): Exception(message)