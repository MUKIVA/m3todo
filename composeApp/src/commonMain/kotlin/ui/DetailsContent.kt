package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import presentation.DetailsComponent
import ui.theme.AppTheme

@Composable
fun DetailsContent(
    component: DetailsComponent,
    modifier: Modifier = Modifier
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = modifier.fillMaxSize()
) {

    val state by component.state.collectAsState()

    Text(
        text = "You click on ${state.item}",
        style = MaterialTheme.typography.displaySmall
    )

    Button(onClick = component::finish) {
        Text("Close")
    }

}