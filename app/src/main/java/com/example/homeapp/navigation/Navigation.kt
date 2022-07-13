package com.example.homeapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.homeapp.home.ContentArea

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Destination.Feed.path
    ) {
        composable(Destination.Feed.path) {
            ContentArea(
                modifier = Modifier.fillMaxSize(),
                destination = Destination.Feed
            )
        }
        composable(Destination.Contacts.path) {
            ContentArea(
                modifier = Modifier.fillMaxSize(),
                destination = Destination.Contacts
            )
        }
        composable(Destination.Calendar.path) {
            ContentArea(
                modifier = Modifier.fillMaxSize(),
                destination = Destination.Calendar
            )
        }
    }
}