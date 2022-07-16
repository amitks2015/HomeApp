package com.example.homeapp.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homeapp.R
import com.example.homeapp.navigation.Destination

@Composable
fun ColumnScope.DrawerContent(
    modifier: Modifier = Modifier,
    onDrawerItemSelected: (Destination) -> Unit,
    onLogout: () -> Unit
) {
    Text(
        modifier = Modifier.padding(16.dp),
        text = stringResource(id = R.string.label_name),
        fontSize = 20.sp
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        modifier = Modifier.padding(16.dp),
        text = stringResource(id = R.string.label_email),
        fontSize = 16.sp
    )
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
    )
    DrawerItem(
        modifier = Modifier.fillMaxWidth(),
        label = Destination.Upgrade.title
    ) {
        onDrawerItemSelected(Destination.Upgrade)
    }
    Spacer(modifier = Modifier.height(8.dp))
    DrawerItem(
        modifier = Modifier.fillMaxWidth(),
        label = Destination.Settings.title
    ) {
        onDrawerItemSelected(Destination.Settings)
    }
    Spacer(modifier = Modifier.weight(1f))
    DrawerItem(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(id = R.string.log_out)
    ) {
        onLogout()
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun DrawerItem(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit
) {
    Text(
        modifier = modifier
            .clickable {
                onClick()
            }
            .padding(16.dp),
        text = label
    )
}