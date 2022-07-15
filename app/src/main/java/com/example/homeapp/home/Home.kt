package com.example.homeapp.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.homeapp.R
import com.example.homeapp.navigation.Destination
import com.example.homeapp.navigation.Navigation

@Composable
fun Home(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry.value?.destination?.route?.let {
                Destination.fromString(it)
            } ?: run {
                Destination.Home
            }
        }
    }
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.title_home))
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                currentDestination = currentDestination,
                onNavigate = {
                    navController.navigate(it.path) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.cd_create_item)
                )
            }
        },
    ) {
        Navigation(navHostController = navController)
    }
}

@Preview
@Composable
fun PreviewHome() {
    Home()
}