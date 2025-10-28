package CintiaAngelo.com.github.cripto_monitor_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import CintiaAngelo.com.github.cripto_monitor_compose.ui.navigation.NavGraph
import CintiaAngelo.com.github.cripto_monitor_compose.ui.theme.CryptoMonitorTheme
import CintiaAngelo.com.github.cripto_monitor_compose.ui.viewmodel.CryptoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoMonitorTheme {
                val navController = rememberNavController()
                val cryptoViewModel: CryptoViewModel = viewModel()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph(
                        navController = navController,
                        viewModel = cryptoViewModel
                    )
                }
            }
        }
    }
}