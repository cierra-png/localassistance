package com.example.localassistance.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.localassistance.ui.theme.Screens.Home.HomeScreen
import com.example.localassistance.ui.theme.Screens.Login.LoginScreen
import com.example.localassistance.ui.theme.Screens.Registration.RegisterScreen
import com.example.localassistance.ui.theme.Screens.ServicesList.MyServiceList
import com.example.localassistance.ui.theme.Screens.ServicesList.Servicescreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_LOGIN) {

    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }
        composable(ROUTE_SERVICEPROVIDER) {
            MyServiceList(navController)
        }
    }
}





