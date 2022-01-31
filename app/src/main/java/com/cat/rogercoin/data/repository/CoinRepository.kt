package com.cat.rogercoin.data.repository

import com.cat.rogercoin.data.model.ExchangeResponseValue
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    suspend fun getExchangeValue(coins: String): Flow<ExchangeResponseValue>
    suspend fun save (exchange: ExchangeResponseValue)
    fun list(): Flow<List<ExchangeResponseValue>>
}