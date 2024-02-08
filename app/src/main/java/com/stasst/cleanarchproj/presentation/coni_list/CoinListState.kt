package com.stasst.cleanarchproj.presentation.coni_list

import com.stasst.cleanarchproj.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
