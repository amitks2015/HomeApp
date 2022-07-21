package com.example.homeapp.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.homeapp.R
import com.example.homeapp.navigation.Destination
import com.example.homeapp.navigation.buildNavigationBarItems

@Composable
fun RailNavigationBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onNavigate: (Destination) -> Unit,
    onCreate: () -> Unit
) {
    NavigationRail(
        modifier = modifier,
        header = {
            FloatingActionButton(onClick = onCreate) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.cd_create_item)
                )
            }
        }
    ) {
        buildNavigationBarItems(
            currentDestination,
            onNavigate
        ).forEach {
            NavigationRailItem(
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