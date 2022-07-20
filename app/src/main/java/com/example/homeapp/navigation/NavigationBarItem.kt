package com.example.homeapp.navigation

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class NavigationBarItem(
    val selected: Boolean,
    val onNavigate: () -> Unit,
    val icon: @Composable () -> Unit,
    val label: @Composable () -> Unit
)

fun buildNavigationBarItems(
    currentDestination: Destination,
    onNavigate: (Destination) -> Unit
): List<NavigationBarItem> =
    listOf(
        Destination.Feed,
        Destination.Contacts,
        Destination.Calendar
    ).map {
        NavigationBarItem(
            selected = it.path == currentDestination.path,
            onNavigate = { onNavigate(it) },
            icon = {
                it.icon?.let { icon ->
                    Icon(
                        imageVector = icon,
                        contentDescription = it.path
                    )
                }
            },
            label = {
                Text(
                    text = it.title
                )
            }
        )
    }