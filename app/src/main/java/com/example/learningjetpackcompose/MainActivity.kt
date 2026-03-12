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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
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
                        onClick = { Log.v("TAG",    "Filled Button Cliked")},
                        onClickTonal = { Log.v("TAG",    "Tonal Button Cliked")},
                        onClickElevated = { Log.v("TAG",    "Elevated Button Cliked")},
                        onClickOutlinedButton = { Log.v("TAG",    "Outlined Button Cliked")},
                        onClickTextButton = { Log.v("TAG",    "Text Button Cliked")},

                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,
             onClick: () -> Unit,
             onClickTonal: () -> Unit,
             onClickElevated: () -> Unit,
             onClickOutlinedButton: () -> Unit,
             onClickTextButton: () -> Unit
) {
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
        FilledTonalButton(onClick = {onClickTonal()}) {
            Text(text = "FilledTonal Button")
        }
//        elevated button
        ElevatedButton(onClick = {onClickElevated()},
            elevation = ButtonDefaults.elevatedButtonElevation(10.dp)
            ) {
            Text(text = "elevated button")
        }
//      Outlined Button
        OutlinedButton(onClick = {onClickOutlinedButton()}) {
            Text(text = "Outlined Button")
        }
//        Text Button
        TextButton(onClick = {onClickTextButton()}) {
            Text(text = "Text Button")
        }

        var text by remember {
            mutableStateOf(TextFieldValue())
        }
        TextField(
            value = text,
            onValueChange = {
                newValue ->
                text = newValue
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearningJetpackComposeTheme {
        Greeting("Android"
            ,onClick = { Log.v("TAgy",    "Filled Button Cliked")}
            ,onClickTonal = { Log.v("TAG",    "Tonal Button Cliked")}
            ,onClickElevated = { Log.v("TAG",    "Elevated Button Cliked")}
            ,onClickOutlinedButton = { Log.v("TAG",    "Outlined Button Cliked")}
            ,onClickTextButton = { Log.v("TAG",    "Text Button Cliked")}

        )
    }
}