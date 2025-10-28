package CintiaAngelo.com.github.cripto_monitor_compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Cores para modo escuro
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),       // Roxo vibrante
    secondary = Color(0xFF03DAC6),     // Ciano
    tertiary = Color(0xFFCF6679),      // Rosa
    background = Color(0xFF121212),    // Preto quase puro
    surface = Color(0xFF1E1E1E),       // Superfície escura
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
    primaryContainer = Color(0xFF3700B3),
    secondaryContainer = Color(0xFF03DAC6)
)

// Cores para modo claro
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),       // Roxo principal
    secondary = Color(0xFF03DAC6),     // Ciano
    tertiary = Color(0xFFCF6679),      // Rosa
    background = Color.White,          // Branco puro
    surface = Color(0xFFFFFBFE),       // Superfície clara
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    primaryContainer = Color(0xFFEADDFF),
    secondaryContainer = Color(0xFFE0F2F1)
)

@Composable
fun CryptoMonitorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}