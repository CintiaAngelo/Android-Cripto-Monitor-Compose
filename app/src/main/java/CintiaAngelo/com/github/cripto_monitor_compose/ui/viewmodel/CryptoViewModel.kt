package CintiaAngelo.com.github.cripto_monitor_compose.ui.viewmodel

import CintiaAngelo.com.github.cripto_monitor_compose.data.model.Crypto
import CintiaAngelo.com.github.cripto_monitor_compose.data.repository.CryptoRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CryptoViewModel : ViewModel() {
    private val repository = CryptoRepository()

    private val _cryptoList = MutableStateFlow<List<Crypto>>(emptyList())
    val cryptoList: StateFlow<List<Crypto>> = _cryptoList.asStateFlow()

    private val _favorites = MutableStateFlow<List<Crypto>>(emptyList())
    val favorites: StateFlow<List<Crypto>> = _favorites.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private var updateJob: Job? = null

    init {
        startAutoUpdate()
    }

    override fun onCleared() {
        super.onCleared()
        stopAutoUpdate()
    }

    fun startAutoUpdate() {
        stopAutoUpdate()

        updateJob = viewModelScope.launch {
            while (true) {
                fetchCryptoData()
                delay(30000)
            }
        }
    }

    fun stopAutoUpdate() {
        updateJob?.cancel()
        updateJob = null
    }

    fun fetchCryptoData() {
        _isLoading.value = true
        _error.value = null

        viewModelScope.launch {
            try {
                val cryptoData = repository.getCryptoList()

                val currentFavorites = _favorites.value
                val updatedList = cryptoData.map { newCrypto ->
                    val existingFavorite = currentFavorites.find { it.id == newCrypto.id }
                    newCrypto.copy(isFavorite = existingFavorite?.isFavorite ?: false)
                }

                _cryptoList.value = updatedList
                _favorites.value = updatedList.filter { it.isFavorite }

            } catch (e: Exception) {
                _error.value = "Erro ao carregar dados: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun toggleFavorite(crypto: Crypto) {
        val updatedList = _cryptoList.value.toMutableList()
        val index = updatedList.indexOfFirst { it.id == crypto.id }

        if (index != -1) {
            val updatedCrypto = crypto.copy(isFavorite = !crypto.isFavorite)
            updatedList[index] = updatedCrypto
            _cryptoList.value = updatedList
            _favorites.value = updatedList.filter { it.isFavorite }
        }
    }

    fun getCryptoById(id: String): Crypto? {
        return _cryptoList.value.find { it.id == id }
    }

    fun retry() {
        fetchCryptoData()
    }

    fun refreshData() {
        viewModelScope.launch {
            fetchCryptoData()
        }
    }
}