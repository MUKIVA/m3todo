package presentation

import androidx.compose.runtime.Immutable
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface DetailsComponent {
    val state: StateFlow<State>

    fun finish()

    @Immutable
    data class State(
        val item: String
    )
}

class DefaultDetailsComponent(
    componentContext: ComponentContext,
    item: String,
    private val onFinished: () -> Unit
): DetailsComponent, ComponentContext by componentContext {
    override val state: StateFlow<DetailsComponent.State>
        get() = mState.asStateFlow()

    private val mState =
        MutableStateFlow(DetailsComponent.State(item))

    override fun finish() = onFinished()
}