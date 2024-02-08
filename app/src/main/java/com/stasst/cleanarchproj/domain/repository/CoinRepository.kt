package com.stasst.cleanarchproj.domain.repository

import com.stasst.cleanarchproj.data.remote.dto.CoinDetailDto
import com.stasst.cleanarchproj.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}