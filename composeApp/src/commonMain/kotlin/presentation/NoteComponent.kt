package presentation

import com.arkivanov.decompose.ComponentContext

interface NoteComponent

class DefaultNoteComponent(
    componentContext: ComponentContext
) : NoteComponent, ComponentContext by componentContext