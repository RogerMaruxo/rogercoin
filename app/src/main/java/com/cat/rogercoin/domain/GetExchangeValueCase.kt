package com.cat.rogercoin.domain

import com.cat.rogercoin.core.UseCase
import com.cat.rogercoin.data.model.ExchangeResponseValue
import com.cat.rogercoin.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class GetExchangeValueUseCase(
    private val repository: CoinRepository
) : UseCase<String, ExchangeResponseValue>() {

    override suspend fun execute(param: String): Flow<ExchangeResponseValue> {
        return repository.getExchangeValue(param)
    }
}