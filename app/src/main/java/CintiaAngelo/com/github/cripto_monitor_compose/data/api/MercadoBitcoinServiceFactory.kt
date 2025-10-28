package CintiaAngelo.com.github.cripto_monitor_compose.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MercadoBitcoinServiceFactory {

    private const val BASE_URL = "https://www.mercadobitcoin.net/"

    fun create(): MercadoBitcoinService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(MercadoBitcoinService::class.java)
    }
}