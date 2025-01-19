package ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import org.koin.compose.koinInject
import presentation.RootComponent

@Composable
fun RootContent(
    component: RootComponent = koinInject(),
    modifier: Modifier = Modifier
) = Children(
    stack = component.stack,
    modifier = modifier,
    animation = stackAnimation(fade())
) {
    when (val child = it.instance) {
        is RootComponent.Child.Note -> NoteContent(child.component)
        is RootComponent.Child.NoteList -> NoteListContent(child.component)
    }
}
