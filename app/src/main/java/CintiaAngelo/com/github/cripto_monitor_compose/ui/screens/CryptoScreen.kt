package CintiaAngelo.com.github.cripto_monitor_compose.ui.screens

import CintiaAngelo.com.github.cripto_monitor_compose.ui.components.CryptoItem
import CintiaAngelo.com.github.cripto_monitor_compose.ui.components.ErrorMessage
import CintiaAngelo.com.github.cripto_monitor_compose.ui.components.ShimmerLoadingGrid
import CintiaAngelo.com.github.cripto_monitor_compose.ui.viewmodel.CryptoViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoScreen(
    navController: NavController,
    viewModel: CryptoViewModel
) {
    val cryptoList by viewModel.cryptoList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    // Iniciar auto-update quando a tela for exibida
    LaunchedEffect(Unit) {
        viewModel.startAutoUpdate()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Criptomoedas") },
                actions = {
                    IconButton(
                        onClick = { viewModel.refreshData() }
                    ) {
                        Icon(Icons.Filled.Refresh, "Atualizar")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when {
                isLoading && cryptoList.isEmpty() -> {
                    ShimmerLoadingGrid(count = 10)
                }
                error != null -> {
                    ErrorMessage(
                        message = error ?: "Erro desconhecido",
                        onRetry = { viewModel.retry() }
                    )
                }
                cryptoList.isEmpty() -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
                    ) {
                        Text("Nenhuma criptomoeda encontrada")
                        Button(
                            onClick = { viewModel.retry() },
                            modifier = Modifier.padding(top = 16.dp)
                        ) {
                            Text("Tentar Novamente")
                        }
                    }
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(
                            items = cryptoList,
                            key = { it.id }
                        ) { crypto ->
                            CryptoItem(
                                crypto = crypto,
                                onItemClick = { cryptoId ->
                                    navController.navigate("details/$cryptoId")
                                },
                                onFavoriteClick = { crypto ->
                                    viewModel.toggleFavorite(crypto)
                                },
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}