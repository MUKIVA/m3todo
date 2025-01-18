package presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked(toIndex: Int)

    sealed class Child {
        class ListChild(val component: ListComponent) : Child()
        class DetailsChild(val component: DetailsComponent) : Child()
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
            initialConfiguration = Config.List,
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
        is Config.Details -> RootComponent.Child.DetailsChild(
            createDetailsComponent(componentContext, config)
        )
        Config.List -> RootComponent.Child.ListChild(
            createListComponent(componentContext)
        )
    }

    private fun createListComponent(
        componentContext: ComponentContext
    ) = DefaultListComponent(
        componentContext = componentContext,
        onItemSelected = { item ->
            navigation.pushNew(Config.Details(item))
        }
    )

    private fun createDetailsComponent(
        componentContext: ComponentContext,
        config: Config.Details
    )= DefaultDetailsComponent(
        componentContext = componentContext,
        item = config.item,
        onFinished = navigation::pop
    )

    @Serializable
    private sealed interface Config {

        @Serializable
        data object List : Config

        @Serializable
        data class Details(
            val item: String
        ) : Config
    }

}