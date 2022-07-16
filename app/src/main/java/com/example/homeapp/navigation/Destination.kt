package com.example.homeapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
    object Settings: Destination("settings", "Settings", Icons.Default.Settings)
    object Upgrade: Destination("upgrade", "Upgrade", Icons.Default.Star)

    companion object {
        fun fromString(route: String) = when(route) {
            Feed.path -> Feed
            Contacts.path -> Contacts
            Calendar.path -> Calendar
            Settings.path -> Settings
            Upgrade.path -> Upgrade
            else -> Home
        }
    }
}