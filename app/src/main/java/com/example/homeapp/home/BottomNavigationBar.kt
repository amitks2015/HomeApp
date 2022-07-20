package com.example.homeapp.home

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.homeapp.navigation.Destination
import com.example.homeapp.navigation.buildNavigationBarItems

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onNavigate: (Destination) -> Unit
) {
    BottomNavigation(modifier = modifier) {
        buildNavigationBarItems(
            currentDestination,
            onNavigate
        ).forEach {
            BottomNavigationItem(
                selected = it.selected,
                onClick = it.onNavigate,
                icon = {
                    it.icon()
                },
                label = {
                    it.label()
                }
            )
        }
    }
}