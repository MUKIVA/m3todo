package presentation

import com.arkivanov.decompose.ComponentContext

interface NoteListComponent

class DefaultNoteListComponent(
    componentContext: ComponentContext
) : NoteListComponent, ComponentContext by componentContext
