package com.example.learningjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.learningjetpackcompose.screens.HomeScreen
import com.example.learningjetpackcompose.screens.ProfileScreen
import com.example.learningjetpackcompose.screens.SettingScreen

@Composable
fun AppNavGraph(modifier: Modifier,navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path
    ) {
        addHomeScreen(navController,this)
        addProfileScreen(navController,this)
        addSettingScreen(navController,this)
    }
}



fun addHomeScreen(navController: NavHostController,navGraphBuilder: NavGraphBuilder){
    navGraphBuilder.composable(
        route = NavRoute.Home.path
    ){
        HomeScreen(
            navigateToProfile = {
                id, showDetails ->
                navController.navigate(
                  "${NavRoute.Profile.path}/$id/$showDetails"
                )

            },
            navigateToSetting = {
                navController.navigate(
                    NavRoute.Settings.path
                )
            }

        )
    }

}


fun addProfileScreen(navController: NavHostController,navGraphBuilder: NavGraphBuilder){
    navGraphBuilder.composable(
        route = "${NavRoute.Profile.path}/{id}/{showDetails}",
        arguments = listOf(
            navArgument(NavRoute.Profile.id){
                type = NavType.StringType
            },
            navArgument(NavRoute.Profile.showDetails){
                type = NavType.StringType
            }
        )

    ){
        navBackStackEntry ->
        val args = navBackStackEntry.arguments
        ProfileScreen(
            id = args?.getString(NavRoute.Profile.id)!!,
            showDetails = args?.getString(NavRoute.Profile.showDetails).toString(),
            navigateToSettings = {
                navController.navigate(
                    NavRoute.Settings.path
                )
            }
        )
    }
}

fun addSettingScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder){
    navGraphBuilder.composable(
        route = NavRoute.Settings.path
    ){
        SettingScreen(
            navigateToHome = {
                navController.navigate(
                    NavRoute.Home.path
                )
            }
        )
    }
}