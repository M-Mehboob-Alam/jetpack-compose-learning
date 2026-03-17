package com.example.learningjetpackcompose.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(modifier: Modifier,navController: NavController){

//    navItems
    val navItems = listOf(
        NavItem.Home,
        NavItem.Profile,
        NavItem.Settings
    )
//get  current  back stack entery
    val currentBackStackEntery by navController.currentBackStackEntryAsState()
//    get current  route
    val currentRoute = currentBackStackEntery?.destination?.route
//   create selected item persist  to recomposition
    val selectedItem =  navItems.indexOfFirst {
        currentRoute?.startsWith(it.path) == true
    }
    var selectedNavItem by rememberSaveable {
        mutableStateOf(if (selectedItem >=0 ) selectedItem else 0)
    }

//    navigation bar
    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                        selectedNavItem =  index
                    val route = if(item.path == NavRoute.Profile.path){
                        NavRoute.Profile.path.plus("/{id}/{showDetails}")
                    }else{
                        item.path
                    }
                    navController.navigate(route){
                        navController.graph.startDestinationRoute?.let{
                            route -> popUpTo(route){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon ={ Icon(imageVector = item.icon, contentDescription = item.title) },

                label = {Text(item.title)},

            )
        }
    }

}