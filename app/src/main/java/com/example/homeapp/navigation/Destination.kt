package com.example.homeapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(
    val path: String,
    val title: String,
    val icon: ImageVector? = null
) {
    object Home: Destination("home", "Home")
    object Feed: Destination("feed", "Feed", Icons.Default.List)
    object Contacts: Destination("contacts", "Contacts", Icons.Default.Person)
    object Calendar: Destination("calendar", "Calendar", Icons.Default.DateRange)

    companion object {
        fun fromString(route: String) = when(route) {
            Feed.path -> Feed
            Contacts.path -> Contacts
            Calendar.path -> Calendar
            else -> Home
        }
    }
}