package CintiaAngelo.com.github.cripto_monitor_compose.ui.screens

import CintiaAngelo.com.github.cripto_monitor_compose.data.model.PortfolioItem
import CintiaAngelo.com.github.cripto_monitor_compose.ui.theme.LossRed
import CintiaAngelo.com.github.cripto_monitor_compose.ui.theme.ProfitGreen
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.CollectionsBookmark
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import CintiaAngelo.com.github.cripto_monitor_compose.ui.viewmodel.PortfolioViewModel
import CintiaAngelo.com.github.cripto_monitor_compose.ui.components.GradientCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioScreen(
    navController: NavController
) {
    val portfolioViewModel: PortfolioViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Filled.CollectionsBookmark,
                            contentDescription = "Portfolio",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Meu Portfolio")
                    }
                },
                actions = {
                    IconButton(
                        onClick = { portfolioViewModel.loadPortfolio() }
                    ) {
                        Icon(Icons.Filled.Add, "Recarregar")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { portfolioViewModel.addSampleItem() }
            ) {
                Icon(Icons.Filled.Add, "Adicionar item de demo")
            }
        }
    ) { padding ->
        val portfolioItems by portfolioViewModel.portfolioItems.collectAsState()
        val isLoading by portfolioViewModel.isLoading.collectAsState()
        val totalValue by portfolioViewModel.totalPortfolioValue.collectAsState()
        val totalInvested by portfolioViewModel.totalInvested.collectAsState()
        val totalProfitLoss by portfolioViewModel.totalProfitLoss.collectAsState()
        val totalChangePercent by portfolioViewModel.totalChangePercent.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Portfolio Summary
            GradientCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "Valor Total do Portfolio",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Text(
                        text = "R$ ${String.format("%,.2f", totalValue)}",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        PortfolioMetric(
                            title = "Lucro/Prejuízo",
                            value = "R$ ${String.format("%,.2f", totalProfitLoss)}",
                            isPositive = totalProfitLoss >= 0
                        )

                        PortfolioMetric(
                            title = "Variação",
                            value = "${String.format("%.2f", totalChangePercent)}%",
                            isPositive = totalChangePercent >= 0
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        PortfolioMetric(
                            title = "Total Investido",
                            value = "R$ ${String.format("%,.2f", totalInvested)}",
                            isPositive = true
                        )

                        PortfolioMetric(
                            title = "Ativos",
                            value = "${portfolioItems.size}",
                            isPositive = true
                        )
                    }
                }
            }

            // Lista de Itens
            if (isLoading) {
                LoadingPortfolioState()
            } else if (portfolioItems.isEmpty()) {
                EmptyPortfolioState(onAddSample = { portfolioViewModel.addSampleItem() })
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(
                        items = portfolioItems,
                        key = { it.id }
                    ) { item ->
                        PortfolioItemCard(
                            item = item,
                            onItemClick = {
                                navController.navigate("details/${item.cryptoId}")
                            },
                            onDeleteClick = {
                                portfolioViewModel.removeItem(item.id)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PortfolioMetric(
    title: String,
    value: String,
    isPositive: Boolean
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
        )
        Text(
            text = value,
            color = if (isPositive) ProfitGreen else LossRed,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun PortfolioItemCard(
    item: PortfolioItem,
    onItemClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    val isProfit = item.profitLoss >= 0

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ícone
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = if (isProfit) ProfitGreen.copy(alpha = 0.1f)
                        else LossRed.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Filled.AttachMoney,
                    contentDescription = item.cryptoName,
                    tint = if (isProfit) ProfitGreen else LossRed,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Informações
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onItemClick() }
            ) {
                Text(
                    text = item.cryptoName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${String.format("%.4f", item.quantity)} ${item.symbol.uppercase()}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Compra: R$ ${String.format("%.2f", item.purchasePrice)}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                )
            }

            // Valores
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "R$ ${String.format("%,.2f", item.currentValue)}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        if (isProfit) Icons.Filled.TrendingUp else Icons.Filled.ArrowDropDown,
                        contentDescription = if (isProfit) "Lucro" else "Prejuízo",
                        modifier = Modifier.size(14.dp),
                        tint = if (isProfit) ProfitGreen else LossRed
                    )
                    Text(
                        text = "R$ ${String.format("%,.2f", item.profitLoss)}",
                        color = if (isProfit) ProfitGreen else LossRed,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "${String.format("%.2f", item.profitLossPercent)}%",
                    color = if (isProfit) ProfitGreen else LossRed,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // Botão de deletar
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                onClick = onDeleteClick,
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Remover",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Composable
fun EmptyPortfolioState(onAddSample: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                Icons.Filled.CollectionsBookmark,
                contentDescription = "Portfolio vazio",
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Seu portfolio está vazio",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Adicione criptomoedas para acompanhar seus investimentos",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            FloatingActionButton(
                onClick = onAddSample,
                modifier = Modifier.size(56.dp)
            ) {
                Icon(Icons.Filled.Add, "Adicionar item de demonstração")
            }
        }
    }
}

@Composable
fun LoadingPortfolioState() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Carregando portfolio...")
    }
}