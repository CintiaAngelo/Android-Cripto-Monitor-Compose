package CintiaAngelo.com.github.cripto_monitor_compose.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MercadoBitcoinService {

    @GET("api/{crypto}/ticker/")
    suspend fun getTicker(@Path("crypto") crypto: String): Response<TickerResponse>
}

data class TickerResponse(
    val ticker: Ticker
)

data class Ticker(
    val high: String,
    val low: String,
    val vol: String,
    val last: String,
    val buy: String,
    val sell: String,
    val date: Long
)