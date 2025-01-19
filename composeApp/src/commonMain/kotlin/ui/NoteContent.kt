package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import presentation.NoteComponent

@Composable
fun NoteContent(
    component: NoteComponent
) = Box(
    contentAlignment = Alignment.Center
) {
    Text("Note", style = MaterialTheme.typography.displaySmall)
}