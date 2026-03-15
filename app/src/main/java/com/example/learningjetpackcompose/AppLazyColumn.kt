package com.example.learningjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun AppLazyColumn(modifier: Modifier = Modifier){
    val itemsList = listOf<String>(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 10",

    )
    Column {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
//            contentPadding =  PaddingValues(
//                start = 16.dp,
//                end = 16.dp,
//                top = 16.dp,
//                bottom = 80.dp   // important
//            )
        ) {
            items(itemsList){
                    item ->
                ListItemDesign(item)
            }
        }
    }

}


@Composable
fun ListItemDesign(title : String){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(Color.Gray).padding(20.dp).fillMaxWidth()

    ) {
        Text(title,
            color = Color.Red,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
            )
    }
}