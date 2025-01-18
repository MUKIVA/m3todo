package ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import presentation.DetailsComponent
import presentation.RootComponent

@Composable
fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier
) = Children(
    stack = component.stack,
    modifier = modifier,
    animation = stackAnimation(fade())
) {
    when (val child = it.instance) {
        is RootComponent.Child.DetailsChild -> DetailsContent(component = child.component)
        is RootComponent.Child.ListChild -> ListContent(component = child.component)
    }
}
