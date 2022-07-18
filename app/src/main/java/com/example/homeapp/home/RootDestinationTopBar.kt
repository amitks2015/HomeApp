package com.example.homeapp.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.homeapp.R
import com.example.homeapp.navigation.Destination

@Composable
fun RootDestinationTopBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    openDrawer: () -> Unit,
    showSnackBar: (String) -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = stringResource(id = R.string.title_home))
        },
        navigationIcon = {
            IconButton(
                onClick = openDrawer
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(id = R.string.cd_open_menu)
                )
            }
        },
        actions = {
            if (currentDestination != Destination.Feed) {
                val snackBarMessage = stringResource(id = R.string.not_available)
                IconButton(onClick = {
                    showSnackBar(snackBarMessage)
                }) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = stringResource(id = R.string.cd_more_info)
                    )
                }
            }
        }
    )
}