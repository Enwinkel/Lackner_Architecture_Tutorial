package com.stasst.cleanarchproj.domain.use_case.get_coins

import com.stasst.cleanarchproj.common.Resource
import com.stasst.cleanarchproj.data.remote.dto.toCoin
import com.stasst.cleanarchproj.domain.model.Coin
import com.stasst.cleanarchproj.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try{
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins()
            emit(Resource.Success<List<Coin>>(coins.map { it.toCoin() }))
        } catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Unexpected error"))
        } catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach the server. Check your internet connection"))
        }
    }
}