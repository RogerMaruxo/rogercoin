package com.cat.rogercoin.domain

import com.cat.rogercoin.core.UseCase
import com.cat.rogercoin.data.model.ExchangeResponseValue
import com.cat.rogercoin.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SaveExchangeUseCase(
    private val repository: CoinRepository
) : UseCase.NoSource<ExchangeResponseValue>() {
    override suspend fun execute(param: ExchangeResponseValue): Flow<Unit> {
        return flow {
            repository.save(param)
            emit(Unit)
        }
    }
}