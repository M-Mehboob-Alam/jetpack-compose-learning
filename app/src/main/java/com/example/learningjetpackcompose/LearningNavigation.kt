package com.example.learningjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun learningNavigation( modifier: Modifier = Modifier){
//    navController
    val navController = rememberNavController()
//    nav  host
//    define nav graph, with start destination &  composable
    NavHost(
        navController = navController,
        startDestination = "first"
    ) {
        composable("first") { firstScreen(navController) }
        composable("second") { secondScreen(navController) }
        composable("third") { thirdScreen(navController) }
    }
}


@Composable
fun firstScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "this is 1st screen")
        Button(onClick = {
            navController.navigate("second")
        }) {
            Text(text = "go to 2nd screen")
        }
    }
}

@Composable
fun secondScreen(navController: NavHostController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "this is 2nd screen")
        Button(onClick = {
            navController.navigate("third")
        }) {
            Text(text = "go to 3nd screen")
        }
    }
}

@Composable
fun thirdScreen(navController: NavHostController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "this is 3rd screen")
        Button(onClick = {
            navController.navigate("first")
        }) {
            Text(text = "go to 1st screen")
        }
    }
}