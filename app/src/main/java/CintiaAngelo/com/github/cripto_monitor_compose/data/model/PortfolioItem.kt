package CintiaAngelo.com.github.cripto_monitor_compose.data.model

data class PortfolioItem(
    val id: String,
    val cryptoId: String,
    val cryptoName: String,
    val symbol: String,
    val quantity: Double,
    val purchasePrice: Double,
    val currentPrice: Double,
    val purchaseDate: Long = System.currentTimeMillis()
) {
    // Valor total investido neste ativo
    val totalCost: Double
        get() = quantity * purchasePrice

    // Valor atual do investimento
    val currentValue: Double
        get() = quantity * currentPrice

    // Lucro/Prejuízo absoluto
    val profitLoss: Double
        get() = currentValue - totalCost

    // Lucro/Prejuízo percentual
    val profitLossPercent: Double
        get() = if (totalCost > 0) (profitLoss / totalCost) * 100 else 0.0

    // Dias desde a compra
    val daysHeld: Long
        get() = (System.currentTimeMillis() - purchaseDate) / (1000 * 60 * 60 * 24)
}