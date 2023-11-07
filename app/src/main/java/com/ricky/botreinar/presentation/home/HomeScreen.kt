package com.ricky.botreinar.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ricky.botreinar.navigation.BottomNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val navHostController = rememberNavController()
    Scaffold { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            BottomNavigation(navHostControler = navHostController, navControler = navController)
        }
    }
}