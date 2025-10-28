package CintiaAngelo.com.github.cripto_monitor_compose.ui.navigation

import CintiaAngelo.com.github.cripto_monitor_compose.ui.screens.BitcoinPriceScreen
import CintiaAngelo.com.github.cripto_monitor_compose.ui.screens.DetailsScreen
import CintiaAngelo.com.github.cripto_monitor_compose.ui.screens.HomeScreen
import CintiaAngelo.com.github.cripto_monitor_compose.ui.screens.PortfolioScreen
import CintiaAngelo.com.github.cripto_monitor_compose.ui.screens.SearchScreen
import CintiaAngelo.com.github.cripto_monitor_compose.ui.viewmodel.CryptoViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: CryptoViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable("search") {
            SearchScreen(navController = navController, viewModel = viewModel)
        }
        composable("portfolio") {
            PortfolioScreen(navController = navController)
        }
        composable("bitcoin") {
            BitcoinPriceScreen(navController = navController) // ✅ PASSAR NavController
        }
        composable("details/{cryptoId}") { backStackEntry ->
            val cryptoId = backStackEntry.arguments?.getString("cryptoId")
            cryptoId?.let {
                DetailsScreen(
                    cryptoId = it,
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }
    }
}