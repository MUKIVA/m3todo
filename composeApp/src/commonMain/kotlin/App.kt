import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.RootContent
import ui.theme.AppTheme

@Composable
@Preview
fun App(
    modifier: Modifier = Modifier
) = AppTheme {
    Surface(modifier.fillMaxSize()) {
        RootContent()
    }
}
