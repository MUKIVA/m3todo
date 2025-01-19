package presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked(toIndex: Int)

    sealed class Child {
        class NoteList(val component: NoteListComponent) : Child()
        class Note(val component: NoteComponent) : Child()
    }
}

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.NoteList,
            handleBackButton = true,
            childFactory = ::childFactory
        )

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    private fun childFactory(
        config: Config,
        componentContext: ComponentContext
    ) = when (config) {
        Config.Note -> RootComponent.Child.Note(createNoteComponent(componentContext))
        Config.NoteList -> RootComponent.Child.NoteList(createNoteListComponent(componentContext))
    }

    private fun createNoteListComponent(
        componentContext: ComponentContext
    ) = DefaultNoteListComponent(
        componentContext = componentContext
    )

    private fun createNoteComponent(
        componentContext: ComponentContext
    ) = DefaultNoteComponent(
        componentContext = componentContext
    )

    @Serializable
    private sealed interface Config {

        @Serializable
        data object Note : Config

        @Serializable
        data object NoteList : Config
    }

}