package com.example.learningjetpackcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    navigateToProfile : (String, String) -> Unit,
    navigateToSetting : () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Home Screen")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            navigateToProfile("#123dafa", "We are working as a web developer")
        }) {
            Text(text = "Profile")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = navigateToSetting) {
            Text(text = "Settings")
        }
    }
}