package CintiaAngelo.com.github.cripto_monitor_compose.ui.screens

import CintiaAngelo.com.github.cripto_monitor_compose.ui.viewmodel.CryptoViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: CryptoViewModel
) {
    val tabTitles = listOf("Criptomoedas", "Favoritos", "Portfolio")
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        // Top App Bar com Search e Mercado Bitcoin
        TopAppBar(
            title = { Text("Crypto Monitor") },
            actions = {
                // Botão Mercado Bitcoin (projeto antigo)
                IconButton(onClick = { navController.navigate("bitcoin") }) {
                    Icon(Icons.Filled.AttachMoney, "Mercado Bitcoin")
                }
                // Botão Pesquisar
                IconButton(onClick = { navController.navigate("search") }) {
                    Icon(Icons.Filled.Search, "Pesquisar")
                }
            }
        )

        TabRow(selectedTabIndex = selectedTabIndex) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(text = title) }
                )
            }
        }

        when (selectedTabIndex) {
            0 -> CryptoScreen(navController = navController, viewModel = viewModel)
            1 -> FavoritesScreen(navController = navController, viewModel = viewModel)
            2 -> PortfolioScreen(navController = navController)
        }
    }
}