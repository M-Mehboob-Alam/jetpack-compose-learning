package com.example.learningjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding,),
                            onClick = { Log.v("TAG",    "Filled Button Cliked")}

                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,onClick: () -> Unit) {
    Column(
        modifier = Modifier.padding(all = 16.dp)
            .border(5.dp,Color.Red)
            .padding(all = 10.dp)
            .border(1.dp,Color.Blue)
            .padding(all = 5.dp)
    ){
        Text(
            text = "Hello  Master  Coding App",
            color = Color.Red,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.LineThrough,
                    TextDecoration.Underline
                )
            )

        )
        Text(text = "download it from palystore",
            textDecoration = TextDecoration.Underline,
            color = Color.Blue
        )
        val image = painterResource(id = R.drawable.image)
        Image(painter =  image, contentDescription = "image",

            )

//        Filled Button
        Button(onClick = {onClick()}) {
            Text(text = "Filled Button")
        }
//        FilledTonol Button
        FilledTonalButton(onClick = {onClick()}) {
            Text(text = "FilledTonal Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearningJetpackComposeTheme {
        Greeting("Android",onClick = { Log.v("TAgy",    "Filled Button Cliked")})
    }
}