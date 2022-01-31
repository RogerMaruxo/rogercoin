package com.cat.rogercoin.domain

import com.cat.rogercoin.core.UseCase
import com.cat.rogercoin.data.model.ExchangeResponseValue
import com.cat.rogercoin.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class ListExchangeUseCase(
    private val repository: CoinRepository
) : UseCase.NoParam<List<ExchangeResponseValue>>() {

    override suspend fun execute(): Flow<List<ExchangeResponseValue>>{
        return repository.list()
    }
}