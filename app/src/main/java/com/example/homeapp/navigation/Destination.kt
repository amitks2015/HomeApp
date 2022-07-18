package com.example.homeapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(
    val path: String,
    val title: String,
    val icon: ImageVector? = null,
    val isRootDestination: Boolean = true
) {
    object Home: Destination("home", "Home")
    object Feed: Destination("feed", "Feed", Icons.Default.List)
    object Contacts: Destination("contacts", "Contacts", Icons.Default.Person)
    object Calendar: Destination("calendar", "Calendar", Icons.Default.DateRange)
    object Settings: Destination("settings", "Settings", Icons.Default.Settings, false)
    object Upgrade: Destination("upgrade", "Upgrade", Icons.Default.Star, false)
    object Creation: Destination("creation", "Creation", isRootDestination = false)
    object Add: Destination("add", "Add", Icons.Default.Add, isRootDestination = false)

    companion object {
        fun fromString(route: String) = when(route) {
            Feed.path -> Feed
            Contacts.path -> Contacts
            Calendar.path -> Calendar
            Settings.path -> Settings
            Upgrade.path -> Upgrade
            Creation.path -> Creation
            Add.path -> Add
            else -> Home
        }
    }
}