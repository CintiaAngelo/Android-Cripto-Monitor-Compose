package CintiaAngelo.com.github.cripto_monitor_compose.ui.screens

import CintiaAngelo.com.github.cripto_monitor_compose.data.api.TickerResponse
import CintiaAngelo.com.github.cripto_monitor_compose.ui.viewmodel.MercadoBitcoinViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BitcoinPriceScreen(navController: NavController) { // ✅ ADICIONAR NavController como parâmetro
    val viewModel: MercadoBitcoinViewModel = viewModel()
    val ticker by viewModel.bitcoinTicker.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadBitcoinTicker()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Bitcoin - Mercado Bitcoin",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = { // ✅ BOTÃO VOLTAR ADICIONADO
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, "Voltar")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.loadBitcoinTicker() }
            ) {
                Icon(Icons.Filled.Refresh, "Atualizar")
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            when {
                isLoading -> {
                    CircularProgressIndicator()
                }
                error != null -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Erro ao carregar dados",
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.error
                        )
                        Text(
                            text = error ?: "Erro desconhecido",
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        Button(
                            onClick = { viewModel.loadBitcoinTicker() },
                            modifier = Modifier.padding(top = 16.dp)
                        ) {
                            Text("Tentar Novamente")
                        }
                    }
                }
                ticker != null -> {
                    BitcoinPriceContent(ticker!!)
                }
                else -> {
                    Text("Nenhum dado disponível")
                }
            }
        }
    }
}

@Composable
fun BitcoinPriceContent(ticker: TickerResponse) {
    val numberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    val lastPrice = ticker.ticker.last.toDoubleOrNull() ?: 0.0

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Preço atual
        Text(
            text = "Preço Atual",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = numberFormat.format(lastPrice),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        // Card com informações detalhadas
        Card(
            modifier = Modifier.fillMaxWidth(0.9f),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Mercado Bitcoin",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                BitcoinInfoRow("Compra", numberFormat.format(ticker.ticker.buy.toDoubleOrNull() ?: 0.0))
                BitcoinInfoRow("Venda", numberFormat.format(ticker.ticker.sell.toDoubleOrNull() ?: 0.0))
                BitcoinInfoRow("Maior Preço", numberFormat.format(ticker.ticker.high.toDoubleOrNull() ?: 0.0))
                BitcoinInfoRow("Menor Preço", numberFormat.format(ticker.ticker.low.toDoubleOrNull() ?: 0.0))
                BitcoinInfoRow("Volume", "${ticker.ticker.vol} BTC")

                // Data da última atualização
                val date = Date(ticker.ticker.date * 1000L)
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
                BitcoinInfoRow("Última atualização", sdf.format(date))
            }
        }
    }
}

// FUNÇÃO AUXILIAR COM NOME DIFERENTE para evitar conflito
@Composable
fun BitcoinInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
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