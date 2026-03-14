package com.example.learningjetpackcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BoxLayout(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()){
        Text("the first text")
        Text("the second text",
            
            modifier = Modifier.align(Alignment.Center))
        Text("the third text",
            modifier = Modifier.align(Alignment.BottomEnd)
            )
    }
}




@Preview(showBackground = true)
@Composable
fun BoxLayoutPreview() {
    BoxLayout()
}