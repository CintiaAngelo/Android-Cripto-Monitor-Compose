package CintiaAngelo.com.github.cripto_monitor_compose.ui.viewmodel

import CintiaAngelo.com.github.cripto_monitor_compose.data.api.TickerResponse
import CintiaAngelo.com.github.cripto_monitor_compose.data.repository.MercadoBitcoinRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MercadoBitcoinViewModel : ViewModel() {

    private val repository = MercadoBitcoinRepository()

    private val _bitcoinTicker = MutableStateFlow<TickerResponse?>(null)
    val bitcoinTicker: StateFlow<TickerResponse?> = _bitcoinTicker.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun loadBitcoinTicker() {
        _isLoading.value = true
        _error.value = null

        viewModelScope.launch {
            try {
                val ticker = repository.getBitcoinTicker()
                _bitcoinTicker.value = ticker
                if (ticker == null) {
                    _error.value = "Não foi possível carregar dados do Bitcoin"
                }
            } catch (e: Exception) {
                _error.value = "Erro: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadTicker(crypto: String) {
        _isLoading.value = true
        _error.value = null

        viewModelScope.launch {
            try {
                val ticker = repository.getTicker(crypto)
                _bitcoinTicker.value = ticker
                if (ticker == null) {
                    _error.value = "Não foi possível carregar dados de $crypto"
                }
            } catch (e: Exception) {
                _error.value = "Erro: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}