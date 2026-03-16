package com.example.learningjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun learningNavigation(modifier: Modifier = Modifier) {
//    navController
    val navController = rememberNavController()
//    nav  host
//    define nav graph, with start destination &  composable
    NavHost(
        navController = navController,
        startDestination = "first"
    ) {
        composable("first") { firstScreen(navController) }
        composable(
            route = "second/{username}/{age}",
            arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                },
                navArgument("age"){
                    type = NavType.StringType
                }
            )

        ) {

                backStackEntery ->
            secondScreen(
                navController,
                backStackEntery.arguments?.getString("username").toString(),
                backStackEntery.arguments?.getString("age").toString()
            )
        }

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
        var username by remember {
            mutableStateOf("")
        }

        Spacer(modifier = Modifier.height(8.dp))
        var age by remember {
            mutableStateOf("")
        }
        TextField(
            value = username,
            onValueChange = {
                username = it
            },
            label = {
                Text(text = "Enter Your Full Name")
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = age,
            onValueChange = {
                age = it
            },
            label = {
                Text(text = "Enter Your Age")
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            navController.navigate("second/$username/$age")
        }) {
            Text(text = "go to 2nd screen")
        }
    }
}

@Composable
fun secondScreen(navController: NavHostController, username: String, age: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Welcome $username")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Are you really $age years old?")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate("third")
        }) {
            Text(text = "go to 3nd screen")
        }
    }
}

@Composable
fun thirdScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "this is 3rd screen")
        Button(onClick = {
            navController.navigate("first")
        }) {
            Text(text = "go to 1st screen")
        }
    }
}