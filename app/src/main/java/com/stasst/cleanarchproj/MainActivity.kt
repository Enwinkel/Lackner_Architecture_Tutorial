package com.stasst.cleanarchproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stasst.cleanarchproj.common.Constants.PARAM_COIN_ID
import com.stasst.cleanarchproj.presentation.NavRoute
import com.stasst.cleanarchproj.presentation.coin_detail.CoinDetailScreen
import com.stasst.cleanarchproj.presentation.coni_list.components.CoinListScreen
import com.stasst.cleanarchproj.presentation.ui.theme.CleanArchProjTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchProjTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavRoute.CoinListScreen.route
                    ){
                        composable(
                            route = NavRoute.CoinListScreen.route
                        ){
                            CoinListScreen(navController)
                        }

                        composable(
                            route = NavRoute.CoinDetails.route + "/{$PARAM_COIN_ID}"
                        ){
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}