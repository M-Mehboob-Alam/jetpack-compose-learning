package com.example.learningjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun LazyColumnStickyHeader(modifier: Modifier = Modifier){
    val groupedItems = mapOf(
        "Fruits" to listOf(
            Item("Apple", "A sweet red Fruit",R.drawable.apple),
            Item("Banana", "A long yellow Fruit",R.drawable.bananas),
            Item("Cherry","A small red Fruit",R.drawable.cherry),
            Item("Mango","A delicious Fruit",R.drawable.mango),
            Item("WaterMelon","A big and sweet Fruit", R.drawable.watermelon),
            Item("Grapes", "Tasty fruits", R.drawable.grapes)
        ),

        "Vegetables" to listOf(
            Item("Carrot", "A long orange vegetable",R.drawable.carrot),
            Item("Lettuce","A leafy green vegetable",R.drawable.lettuce),
            Item("Broccoli","A beautiful vegetable",R.drawable.brocoli),
            Item("Onion", "Amazing Vegetable", R.drawable.onion),
            Item("Potato","A yellow vegetable",R.drawable.potato),
            Item("Tomato","A red and sweet vegetable",R.drawable.tomato),
            Item("Pea", "Sweet Vegetable",R.drawable.pea)
        )
    )
    val myFruits = groupedItems["Fruits"]
    LazyColumn(
//        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
    groupedItems.forEach {
        (header, items) ->

            stickyHeader {
                CustomStickyHeader(header)
            }

            items(items){
                item ->
                customLazyColumnItem(item)
            }
        }

    }

}


@Composable
fun CustomStickyHeader(title : String){
    Text(
        title,
        color = Color.White,
        fontSize = 25.sp,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .padding(5.dp)
        )
}


@Composable
fun customLazyColumnItem(item: Item){
    Card {
        Column {
            Image(
                painter = painterResource(item.imageUrl),
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                item.title,
                fontSize = 22.sp,
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                item.desc,
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}