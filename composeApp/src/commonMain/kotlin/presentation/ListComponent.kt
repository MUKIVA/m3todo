package presentation

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface ListComponent {
    val model: StateFlow<Model>

    fun onItemClicked(item: String)

    data class Model(
        val items: List<String>,
    )
}

class DefaultListComponent(
    componentContext: ComponentContext,
    private val onItemSelected: (item: String) -> Unit,
) : ListComponent {
    override val model: StateFlow<ListComponent.Model>
        get() = mModel.asStateFlow()

    private val mModel =
        MutableStateFlow(ListComponent.Model(items = List(100) { "Item $it" }))

    override fun onItemClicked(item: String) {
        onItemSelected(item)
    }
}