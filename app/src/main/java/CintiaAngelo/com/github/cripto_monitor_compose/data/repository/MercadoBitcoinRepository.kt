package CintiaAngelo.com.github.cripto_monitor_compose.data.repository

import CintiaAngelo.com.github.cripto_monitor_compose.data.api.MercadoBitcoinServiceFactory
import CintiaAngelo.com.github.cripto_monitor_compose.data.api.TickerResponse

class MercadoBitcoinRepository {

    private val service = MercadoBitcoinServiceFactory.create()

    suspend fun getBitcoinTicker(): TickerResponse? {
        return try {
            val response = service.getTicker("BTC")
            if (response.isSuccessful) response.body() else null
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getEthereumTicker(): TickerResponse? {
        return try {
            val response = service.getTicker("ETH")
            if (response.isSuccessful) response.body() else null
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getTicker(crypto: String): TickerResponse? {
        return try {
            val response = service.getTicker(crypto.uppercase())
            if (response.isSuccessful) response.body() else null
        } catch (e: Exception) {
            null
        }
    }
}