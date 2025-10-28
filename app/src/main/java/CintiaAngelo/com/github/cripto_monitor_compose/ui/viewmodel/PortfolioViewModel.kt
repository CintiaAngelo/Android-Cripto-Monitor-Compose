package CintiaAngelo.com.github.cripto_monitor_compose.ui.viewmodel

import CintiaAngelo.com.github.cripto_monitor_compose.data.model.PortfolioItem
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PortfolioViewModel : ViewModel() {

    private val _portfolioItems = MutableStateFlow<List<PortfolioItem>>(emptyList())
    val portfolioItems: StateFlow<List<PortfolioItem>> = _portfolioItems.asStateFlow()

    private val _totalPortfolioValue = MutableStateFlow(0.0)
    val totalPortfolioValue: StateFlow<Double> = _totalPortfolioValue.asStateFlow()

    private val _totalInvested = MutableStateFlow(0.0)
    val totalInvested: StateFlow<Double> = _totalInvested.asStateFlow()

    private val _totalProfitLoss = MutableStateFlow(0.0)
    val totalProfitLoss: StateFlow<Double> = _totalProfitLoss.asStateFlow()

    private val _totalChangePercent = MutableStateFlow(0.0)
    val totalChangePercent: StateFlow<Double> = _totalChangePercent.asStateFlow()

    private val _isLoading = MutableStateFlow(false) // Iniciar como false para não mostrar loading inicial
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        // Carregar dados de exemplo imediatamente
        loadSamplePortfolio()
    }

    fun loadPortfolio() {
        _isLoading.value = true
        _error.value = null

        viewModelScope.launch {
            try {
                delay(1000) // Simular carregamento mais rápido
                loadSamplePortfolio()
            } catch (e: Exception) {
                _error.value = "Erro ao carregar portfolio: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun loadSamplePortfolio() {
        val sampleItems = listOf(
            PortfolioItem(
                id = "1",
                cryptoId = "bitcoin",
                cryptoName = "Bitcoin",
                symbol = "BTC",
                quantity = 0.25,
                purchasePrice = 45000.0,
                currentPrice = 62000.0, // Preço atualizado
                purchaseDate = System.currentTimeMillis() - 30L * 24 * 60 * 60 * 1000
            ),
            PortfolioItem(
                id = "2",
                cryptoId = "ethereum",
                cryptoName = "Ethereum",
                symbol = "ETH",
                quantity = 3.5,
                purchasePrice = 2800.0,
                currentPrice = 3500.0,
                purchaseDate = System.currentTimeMillis() - 15L * 24 * 60 * 60 * 1000
            ),
            PortfolioItem(
                id = "3",
                cryptoId = "cardano",
                cryptoName = "Cardano",
                symbol = "ADA",
                quantity = 1000.0,
                purchasePrice = 1.2,
                currentPrice = 0.85,
                purchaseDate = System.currentTimeMillis() - 7L * 24 * 60 * 60 * 1000
            ),
            PortfolioItem(
                id = "4",
                cryptoId = "solana",
                cryptoName = "Solana",
                symbol = "SOL",
                quantity = 15.0,
                purchasePrice = 120.0,
                currentPrice = 180.0,
                purchaseDate = System.currentTimeMillis() - 45L * 24 * 60 * 60 * 1000
            )
        )

        _portfolioItems.value = sampleItems
        calculatePortfolioSummary(sampleItems)
        _isLoading.value = false
    }

    private fun calculatePortfolioSummary(items: List<PortfolioItem>) {
        var totalValue = 0.0
        var totalCost = 0.0

        items.forEach { item ->
            totalValue += item.currentValue
            totalCost += item.totalCost
        }

        _totalPortfolioValue.value = totalValue
        _totalInvested.value = totalCost
        _totalProfitLoss.value = totalValue - totalCost

        _totalChangePercent.value = if (totalCost > 0) {
            ((totalValue - totalCost) / totalCost) * 100
        } else 0.0
    }

    // Função simplificada para adicionar item (para demo)
    fun addSampleItem() {
        val newItem = PortfolioItem(
            id = System.currentTimeMillis().toString(),
            cryptoId = "binancecoin",
            cryptoName = "Binance Coin",
            symbol = "BNB",
            quantity = 2.0,
            purchasePrice = 300.0,
            currentPrice = 350.0
        )

        val updatedList = _portfolioItems.value.toMutableList().apply {
            add(newItem)
        }

        _portfolioItems.value = updatedList
        calculatePortfolioSummary(updatedList)
    }

    fun removeItem(itemId: String) {
        val updatedList = _portfolioItems.value.filter { it.id != itemId }
        _portfolioItems.value = updatedList
        calculatePortfolioSummary(updatedList)
    }

    fun retryLoadPortfolio() {
        loadPortfolio()
    }

    fun clearError() {
        _error.value = null
    }
}