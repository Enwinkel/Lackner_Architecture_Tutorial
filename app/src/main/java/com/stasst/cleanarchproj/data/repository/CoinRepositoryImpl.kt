package com.stasst.cleanarchproj.data.repository

import com.stasst.cleanarchproj.data.remote.CoinPaprikaApi
import com.stasst.cleanarchproj.data.remote.dto.CoinDetailDto
import com.stasst.cleanarchproj.data.remote.dto.CoinDto
import com.stasst.cleanarchproj.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}