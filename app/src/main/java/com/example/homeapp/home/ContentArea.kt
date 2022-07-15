package com.example.homeapp.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homeapp.navigation.Destination

@Composable
fun ContentArea(
    modifier: Modifier = Modifier,
    destination: Destination
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        destination.icon?.let {
            Icon(
                modifier = Modifier.size(80.dp),
                imageVector = it,
                contentDescription = destination.path
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        Text(
            text = destination.title,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
fun PreviewContentArea() {
    ContentArea(destination = Destination.Contacts)
}