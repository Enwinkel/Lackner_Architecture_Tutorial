package com.stasst.cleanarchproj.presentation.coin_detail

import com.stasst.cleanarchproj.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
