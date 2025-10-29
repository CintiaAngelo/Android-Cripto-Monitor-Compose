# 📱💰 Crypto Monitor

Um aplicativo moderno para **monitoramento de criptomoedas** desenvolvido em **Jetpack Compose**, que consome dados em tempo real de múltiplas APIs.

---
## 👩‍💻 Desenvolvedores

- **Cíntia Cristina Braga Angelo** — RM552253  
- **Henrique Mosseri** — RM552240  

---

## 📸 Capturas de Tela

### 🏠 Tela Principal - Home  
![Home](https://private-user-images.githubusercontent.com/174644870/506835320-dad859c8-2ec7-49ae-a5d7-af2e490f5874.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NjE2OTU3NjIsIm5iZiI6MTc2MTY5NTQ2MiwicGF0aCI6Ii8xNzQ2NDQ4NzAvNTA2ODM1MzIwLWRhZDg1OWM4LTJlYzctNDlhZS1hNWQ3LWFmMmU0OTBmNTg3NC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUxMDI4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MTAyOFQyMzUxMDJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT01Y2Q3NzM1NmM3ZDQ2ODgwOTQyZTdjYzEzZmU4NmNhMDM4MWNlMmJkYTU2ODFlZTE3Y2FlZDEyOTgzOGI2Y2YxJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.cIrOjcDsS3AEhceeFG4u6qCeq1X3yNCAHO1qBxTNIoA)  
Navegação por abas entre **Criptomoedas**, **Favoritos** e **Portfolio**.

### 📈 Lista de Criptomoedas  
![Lista](https://private-user-images.githubusercontent.com/174644870/506837025-08b69378-bbbe-4b42-8780-269f815d9ec2.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NjE2OTYyMzgsIm5iZiI6MTc2MTY5NTkzOCwicGF0aCI6Ii8xNzQ2NDQ4NzAvNTA2ODM3MDI1LTA4YjY5Mzc4LWJiYmUtNGI0Mi04NzgwLTI2OWY4MTVkOWVjMi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUxMDI4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MTAyOFQyMzU4NThaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1kMGFmYWZiYjk4ODRhNTAzMDc5ZmM2YmYzYjMyYTA0NzIyMmI0MjQyNGY2Mjk4YWQ5NGE0MDRkODZhYmJlYWE0JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.LOEdQ9vzlQjojOqO1VP5bvXBhse74lwe1kg4T3bs2_c)  
Lista em tempo real com preços em Dólar, variações e funcionalidade de favoritos.

### 💬 Tela de Detalhamento  
![Detalhes](https://private-user-images.githubusercontent.com/174644870/506837225-4316d432-c0be-4845-ae7f-b8f3fb641611.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NjE2OTYyNzYsIm5iZiI6MTc2MTY5NTk3NiwicGF0aCI6Ii8xNzQ2NDQ4NzAvNTA2ODM3MjI1LTQzMTZkNDMyLWMwYmUtNDg0NS1hZTdmLWI4ZjNmYjY0MTYxMS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUxMDI4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MTAyOFQyMzU5MzZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT03M2E4ZmExZjZkMzEwMGM4NTEzNjhkMjUzZDFhNjBmNDZkNmZkZjc3NzlkZjVjMWNmNmJkYTM2OGYyZjIzNmY0JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.XCJfF6QbYiiNuJX7BIr-qAKUHq-IV74E6KpkNjuUhd4)  
Informações detalhadas de cada criptomoeda.

### 🇧🇷 Mercado Bitcoin  
![Mercado Bitcoin](https://private-user-images.githubusercontent.com/174644870/506837546-770b13f1-c0e5-4640-8cfd-67ff2cddeb6b.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NjE2OTYzNjYsIm5iZiI6MTc2MTY5NjA2NiwicGF0aCI6Ii8xNzQ2NDQ4NzAvNTA2ODM3NTQ2LTc3MGIxM2YxLWMwZTUtNDY0MC04Y2ZkLTY3ZmYyY2RkZWI2Yi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUxMDI5JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MTAyOVQwMDAxMDZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1hNWMzYjg0MjVjZTI3ZDBmMjdkZDFlNDYxZTZlM2I2OTViZTA4NmRlODM3MzEzYTI1ODM4M2RkYWIzOWY1NjUyJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.xc82Cpx8PfjR269L7E4_VqqnM4UvZCSzfur9zOoAruA)  
Dados específicos do Mercado Bitcoin com preços em BRL. Mesma tela do antigo projeto de Criptomoedas

### ❤️ Favoritos  
![Favoritos](https://private-user-images.githubusercontent.com/174644870/506837738-6a0ff4df-0eb6-46c9-b5e7-aa01c550e53e.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NjE2OTY0NDMsIm5iZiI6MTc2MTY5NjE0MywicGF0aCI6Ii8xNzQ2NDQ4NzAvNTA2ODM3NzM4LTZhMGZmNGRmLTBlYjYtNDZjOS1iNWU3LWFhMDFjNTUwZTUzZS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUxMDI5JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MTAyOVQwMDAyMjNaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT01NzVkZGEzMjc3NTczZWJiOGFlZDgxYzVjMTY4ODcwOTc1NWQ5YjNlMDhiNTNhM2ViMmExYjA0MmEzZjNiNjBjJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.ZeeNiKIsf0pfkmT8mLUnoF9o3tV-MRXWp2ht6svAUsE)  
Criptomoedas favoritadas pelo usuário.

### 💼 Portfolio  
![Portfolio](https://private-user-images.githubusercontent.com/174644870/506837846-e6686d72-4ca7-4be8-8110-c0ce977bce0d.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NjE2OTY0ODAsIm5iZiI6MTc2MTY5NjE4MCwicGF0aCI6Ii8xNzQ2NDQ4NzAvNTA2ODM3ODQ2LWU2Njg2ZDcyLTRjYTctNGJlOC04MTEwLWMwY2U5NzdiY2UwZC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUxMDI5JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MTAyOVQwMDAzMDBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT03YzlhYjI5MzkxODJhYjdiNzMyNTJkOTBiZDg4YTBjZTM2MDE1Zjk5NzQ4MjNjNTUyYzg0NDE4NzIxMmEyN2QxJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.L6IvdB837KS6DheNaxx6OSDmAP9RFPavTkVeyNb2Jq8)  
Acompanhamento de investimentos com cálculos de lucro/prejuízo.


### 🔍 Busca  
![Busca](https://private-user-images.githubusercontent.com/174644870/506837933-b950fc5e-d41e-432a-be44-375e595f2f5f.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NjE2OTY1MDYsIm5iZiI6MTc2MTY5NjIwNiwicGF0aCI6Ii8xNzQ2NDQ4NzAvNTA2ODM3OTMzLWI5NTBmYzVlLWQ0MWUtNDMyYS1iZTQ0LTM3NWU1OTVmMmY1Zi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUxMDI5JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MTAyOVQwMDAzMjZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT03NmM5N2VhNDBkZDI3MTg4YTQxODNmMjIwNWFiNGM4YWMzZGZkMWM5MDlhZDhkZjQ4ZTIxYzI5MzQ4MGZmZDY0JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.6SbbgYTmdex36QbrbDMLCLRbj2Uh_Hqp-LlI9jasvAY)  
Busca em tempo real por criptomoedas.

---

## 🚀 Funcionalidades

### 📊 Monitoramento em Tempo Real
- Preços atualizados de **50+ criptomoedas**
- Variação percentual em 24h  
- Market cap e volume de negociação  
- Atualização automática a cada 30 segundos  

### ⭐ Sistema de Favoritos
- Adicione/remova criptomoedas dos favoritos  
- Lista dedicada para acompanhamento rápido  
- Persistência durante a sessão  

### 💼 Gestão de Portfolio
- Adicione criptomoedas ao seu portfolio  
- Acompanhe preço de compra vs preço atual  
- Cálculo automático de lucro/prejuízo  
- Valor total do investimento  

### 🔍 Busca Avançada
- Busca em tempo real por **nome ou símbolo**  
- Interface de pesquisa moderna do **Material3**  
- Navegação direta para detalhes  

### 🌐 Multi-Fonte de Dados
- **CoinGecko API**: Dados globais em USD  
- **Mercado Bitcoin API**: Dados específicos em BRL  
- Alternância fácil entre fontes  

---

## 🛠️ Tecnologias Utilizadas

### 🧱 Arquitetura
- **MVVM (Model-View-ViewModel)**  
- **Repository Pattern**  
- **State Management** com Flow/StateFlow  

### 💯 Android Moderno
- **Jetpack Compose** – UI totalmente declarativa  
- **Material Design 3** – Design system moderno  
- **Navigation Compose** – Navegação type-safe  
- **ViewModel** – Gerenciamento de estado da UI  

### 🌐 Networking
- **Retrofit + GSON** – Cliente HTTP e parsing JSON  
- **Coroutines** – Programação assíncrona  
- **Coil** – Carregamento de imagens  

### 🔌 APIs Consumidas
- `https://api.coingecko.com` – Dados globais de criptomoedas  
- `https://www.mercadobitcoin.net` – Dados do mercado brasileiro  

---

## 🏗️ Estrutura do Projeto
```bash

app/
├── data/
│   ├── api/              # Interfaces Retrofit
│   ├── model/            # Data classes
│   └── repository/       # Camada de acesso a dados
├── ui/
│   ├── screens/          # Telas do aplicativo
│   ├── components/       # Componentes reutilizáveis
│   ├── viewmodel/        # ViewModels
│   └── navigation/       # Configuração de navegação
└── theme/               # Cores e temas

```


---

## 📱 Telas Disponíveis

### 1️⃣ HomeScreen
- Aba **Criptomoedas**: Lista principal com auto-atualização  
- Aba **Favoritos**: Lista personalizada do usuário  
- Aba **Portfolio**: Visão geral dos investimentos  
- Botão **Mercado Bitcoin**: Acesso rápido aos dados em BRL  

### 2️⃣ CryptoScreen
- Lista paginada de criptomoedas  
- Indicador de loading com **shimmer effect**  
- Tratamento de erros de rede  
- Pull-to-refresh manual  

### 3️⃣ DetailsScreen
- Informações detalhadas da criptomoeda selecionada  
- Preço atual e histórico de 24h  
- Market cap, volume e rankings  
- Gráficos de variação *(se disponível)*  

### 4️⃣ BitcoinPriceScreen
- Dados específicos do Mercado Bitcoin  
- Preços de compra e venda em tempo real  
- Maior e menor preço do dia  
- Volume negociado em BTC  

### 5️⃣ PortfolioScreen
- Visão consolidada dos investimentos  
- Cálculos automáticos de performance  
- Adição/remoção de ativos  
- Demonstrativo de lucro/prejuízo  

### 6️⃣ SearchScreen
- Busca em tempo real  
- Interface de pesquisa do Material3  
- Filtragem instantânea  

---

## ⚙️ Configuração e Build

### 🧩 Pré-requisitos
- Android Studio **Hedgehog** ou superior  
- SDK Android **34+**  
- Kotlin **1.9.21+**

### 🏗️ Build
```bash
./gradlew assembleDebug
