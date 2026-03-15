package com.example.learningjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ColumnVerticalScroll(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.verticalScroll(
            rememberScrollState()
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.pic1),
            contentDescription = "image",
            contentScale = ContentScale.FillBounds

        )
        Image(
            painter = painterResource(id = R.drawable.pic2),
            contentDescription = "image",
            contentScale = ContentScale.FillBounds

        )
        Image(
            painter = painterResource(id = R.drawable.pic3),
            contentDescription = "image",
            contentScale = ContentScale.FillBounds

        )
        Image(
            painter = painterResource(id = R.drawable.pic3),
            contentDescription = "image",
            contentScale = ContentScale.FillBounds

        )
        Image(
            painter = painterResource(id = R.drawable.pic3),
            contentDescription = "image",
            contentScale = ContentScale.FillBounds

        )
    }
}



@Preview(showBackground = true)
@Composable
fun ColumnVerticalScrollPreview() {
    ColumnVerticalScroll()
}