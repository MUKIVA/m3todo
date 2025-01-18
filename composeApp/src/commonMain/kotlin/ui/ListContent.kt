package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.ListComponent

@Composable
fun ListContent(
    component: ListComponent,
    modifier: Modifier = Modifier
) {
    val model by component.model.collectAsState()

    LazyColumn(modifier = modifier) {
        items(items = model.items) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { component.onItemClicked(item = item) }
                    .padding(horizontal = 16.dp, vertical = 8.dp),
            )
            HorizontalDivider()
        }
    }
}