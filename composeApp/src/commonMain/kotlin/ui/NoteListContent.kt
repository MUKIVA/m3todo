package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import presentation.NoteListComponent

@Composable
fun NoteListContent(
    component: NoteListComponent
) = Box(
    contentAlignment = Alignment.Center
) {
    Text("Note List", style = MaterialTheme.typography.displaySmall)
}