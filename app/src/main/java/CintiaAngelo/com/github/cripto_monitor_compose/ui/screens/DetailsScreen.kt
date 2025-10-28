package CintiaAngelo.com.github.cripto_monitor_compose.ui.screens

import CintiaAngelo.com.github.cripto_monitor_compose.data.model.Crypto
import CintiaAngelo.com.github.cripto_monitor_compose.ui.viewmodel.CryptoViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(cryptoId: String, viewModel: CryptoViewModel, navController: NavController) {
    val crypto = remember { mutableStateOf(viewModel.getCryptoById(cryptoId)) }

    // Atualizar dados quando a tela abrir
    LaunchedEffect(cryptoId) {
        if (crypto.value == null) {
            viewModel.refreshData()
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        crypto.value?.name ?: "Detalhes",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, "Voltar")
                    }
                }
            )
        }
    ) { padding ->
        crypto.value?.let { cryptoDetails ->
            DetailsContent(cryptoDetails, Modifier.padding(padding))
        } ?: run {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("Criptomoeda não encontrada")
            }
        }
    }
}

@Composable
fun DetailsContent(crypto: Crypto, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(
            text = crypto.name,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = crypto.symbol.uppercase(),
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Preço atual
        Text(
            text = "Preço Atual",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = "$ ${"%.2f".format(crypto.currentPrice)}",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )

        // Variação percentual
        Text(
            text = "${"%.2f".format(crypto.priceChangePercentage24h)}%",
            fontSize = 18.sp,
            color = if (crypto.priceChangePercentage24h >= 0) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.error
            },
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Card com estatísticas detalhadas
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Estatísticas",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                InfoRow("Variação 24h", "${"%.2f".format(crypto.priceChangePercentage24h)}%")
                InfoRow("Market Cap", "$ ${formatLargeNumber(crypto.marketCap)}")
                InfoRow("Volume 24h", "$ ${formatLargeNumber(crypto.totalVolume)}")
                InfoRow("Alta 24h", "$ ${"%.2f".format(crypto.high24h)}")
                InfoRow("Baixa 24h", "$ ${"%.2f".format(crypto.low24h)}")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Card adicional para informações
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Identificação",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                InfoRow("ID", crypto.id)
                InfoRow("Símbolo", crypto.symbol.uppercase())
            }
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = value,
            fontWeight = FontWeight.SemiBold
        )
    }
}

// Função auxiliar para formatar números grandes
private fun formatLargeNumber(number: Long): String {
    return when {
        number >= 1_000_000_000 -> "%.2fB".format(number / 1_000_000_000.0)
        number >= 1_000_000 -> "%.2fM".format(number / 1_000_000.0)
        number >= 1_000 -> "%.2fK".format(number / 1_000.0)
        else -> number.toString()
    }
}