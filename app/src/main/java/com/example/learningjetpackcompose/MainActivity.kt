package com.example.learningjetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.learningjetpackcompose.navigation.AppNavGraph
import com.example.learningjetpackcompose.navigation.BottomNavigationBar
import com.example.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningJetpackComposeTheme {
                val  navController  = rememberNavController()
                Scaffold(

//                    topBar = {
//                       AppTopBar()
//                    },
                    bottomBar = {
                       BottomNavigationBar(modifier = Modifier, navController = navController)
                    },
//                    floatingActionButton = {
//                        FloatingActionButton(onClick = {}) { }
//                    },

                    modifier = Modifier.fillMaxSize(),


                ) { innerPadding ->
//                     var text by remember {
//                        mutableStateOf("")
//                    }

                    AppNavGraph(modifier = Modifier.padding(innerPadding), navController)
//                    BottomNavigationBar(modifier = Modifier.padding(innerPadding), navController)
//                        learningNavigation(modifier = Modifier.padding(innerPadding))
//                        BoxLayout(modifier = Modifier.padding(innerPadding,))

//                    Greeting(
//                        name = "Android",$
//                        modifier = Modifier.padding(innerPadding,),
//                        onClick = { Log.v("TAG",    "Filled Button Cliked")},
//                        onClickTonal = { Log.v("TAG",    "Tonal Button Cliked")},
//                        onClickElevated = { Log.v("TAG",    "Elevated Button Cliked")},
//                        onClickOutlinedButton = { Log.v("TAG",    "Outlined Button Cliked")},
//                        onClickTextButton = { Log.v("TAG",    "Text Button Cliked")},
//
//                    )
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,
             onClick: () -> Unit,
             onClickTonal: () -> Unit,
             onClickElevated: () -> Unit,
             onClickOutlinedButton: () -> Unit,
             onClickTextButton: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(all = 16.dp)
            .border(5.dp, Color.Red)
            .padding(all = 10.dp)
            .border(1.dp, Color.Blue)
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

        //  learning state
        var count  = remember {
            mutableStateOf(0);
        }

        Text(text = "Counter ${count.value}")
        Button(onClick = {
            count.value ++
            Log.v("TAG", "count ${count.value}")
        }) {
            Text(text = "Increase Counter ")
        }
//        stateless textfield
//        @Composable
//        fun stateLessTextField(
//            text:  String,
//            onTextChanged : (String) -> Unit
//        ){
//            TextField(
//                value = text,
//                onValueChange = onTextChanged,
//                label = {
//                    Text(text = "Enter your name")
//                }
//            )
//            Text(text =  "Welcome $text")
//        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(){
    val context = LocalContext.current
    TopAppBar(
       title = {
           Text("CallToExperts")
       },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,

        ),
        navigationIcon = {
            IconButton(onClick = {
                Log.v("TAG", "Menu icon button clicked")

                Toast.makeText(context, "Menu icon button clicked", Toast.LENGTH_SHORT).show()
            }) {
                Image(painter = painterResource(R.drawable.menu),
                    contentDescription = "Menu icon button",
                    colorFilter = ColorFilter.tint(color = Color.White)
                    )
            }
        },
        actions = {
            IconButton(onClick = {
                Log.v("TAG", "Setting icon button clicked")

                Toast.makeText(context, "Setting icon button  clicked", Toast.LENGTH_SHORT).show()
            }) {
                Image(painter = painterResource(R.drawable.setting),
                    contentDescription = "Menu icon button",
                    colorFilter = ColorFilter.tint(color = Color.White)
                )
            }
        }

    )
}

@Composable
fun AppBottomBar(){
    val context = LocalContext.current
    BottomAppBar(
        containerColor = Color.Black,
        contentColor = Color.White,
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            IconButton(onClick = {
                Log.v("TAG", "Home icon button clicked")

                Toast.makeText(context, "Home icon button clicked", Toast.LENGTH_SHORT).show()

            }){
                Image(
                    painter = painterResource(R.drawable.outline_add_home_24),
                    contentDescription = "Home icon button",
                    colorFilter = ColorFilter.tint(color = Color.White)
                )
            }
            IconButton(onClick = {
                Log.v("TAG", "collection icon button clicked")

                Toast.makeText(context, "collection icon button clicked", Toast.LENGTH_SHORT).show()

            }){
                Image(
                    painter = painterResource(R.drawable.outline_browse_gallery_24),
                    contentDescription = "Collection icon button",
                    colorFilter = ColorFilter.tint(color = Color.White)
                )
            }
            IconButton(onClick = {
                Log.v("TAG", "persons icon button clicked")

                Toast.makeText(context, "persons icon button clicked", Toast.LENGTH_SHORT).show()

            }){
                Image(
                    painter = painterResource(R.drawable.outline_border_color_24),
                    contentDescription = "persons icon button",
                    colorFilter = ColorFilter.tint(color = Color.White)
                )
            }
        }
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