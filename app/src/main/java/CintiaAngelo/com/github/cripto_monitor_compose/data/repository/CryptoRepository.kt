package CintiaAngelo.com.github.cripto_monitor_compose.data.repository

import CintiaAngelo.com.github.cripto_monitor_compose.data.api.ApiClient
import CintiaAngelo.com.github.cripto_monitor_compose.data.model.Crypto
import CintiaAngelo.com.github.cripto_monitor_compose.data.model.CryptoDetails

class CryptoRepository {
    private val api = ApiClient.cryptoApi

    suspend fun getCryptoList(): List<Crypto> {
        val response = api.getCryptoList()
        return if (response.isSuccessful) response.body() ?: emptyList() else emptyList()
    }

    suspend fun getCryptoDetails(id: String): CryptoDetails? {
        val response = api.getCryptoDetails(id)
        return if (response.isSuccessful) response.body() else null
    }
}