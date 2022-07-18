package com.example.homeapp.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.homeapp.R
import com.example.homeapp.navigation.Destination
import com.example.homeapp.navigation.Navigation
import kotlinx.coroutines.launch

@Composable
fun Home(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState)
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
            DestinationTopBar(
                destination = currentDestination,
                openDrawer = {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                },
                showSnackBar = { message ->
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(message)
                    }
                },
                onNavigateUp = {
                    navController.popBackStack()
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
            FloatingActionButton(
                onClick = {
                    navController.navigate(Destination.Creation.path)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.cd_create_item)
                )
            }
        },
        drawerContent = {
            DrawerContent(
                modifier = Modifier.fillMaxWidth(),
                onDrawerItemSelected = {destination ->
                    navController.navigate(destination.path)
                    coroutineScope.launch {
                        drawerState.close()
                    }
                },
                onLogout = {}
            )
        }
    ) {
        Navigation(navHostController = navController)
    }
}

@Composable
private fun DestinationTopBar(
    modifier: Modifier = Modifier,
    destination: Destination,
    openDrawer: () -> Unit,
    showSnackBar: (String) -> Unit,
    onNavigateUp: () -> Unit,
) {
    if(destination.isRootDestination) {
        RootDestinationTopBar(
            modifier = modifier,
            currentDestination = destination,
            openDrawer = openDrawer,
            showSnackBar = { message ->
                showSnackBar(message)
            }
        )
    } else {
        ChildDestinationTopBAr(
            modifier = modifier,
            title = destination.title,
            onNavigateUp = onNavigateUp
        )
    }
}

@Preview
@Composable
fun PreviewHome() {
    Home()
}