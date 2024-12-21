package app.codechallenge.testapplication.presentation.screens.mainpage

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.codechallenge.testapplication.app.navigation.Destination
import app.codechallenge.testapplication.app.navigation.NavHost
import app.codechallenge.testapplication.app.navigation.NavigationIntent
import app.codechallenge.testapplication.app.navigation.composable
import app.codechallenge.testapplication.presentation.screens.listpage.DiscoverListPage
import app.codechallenge.testapplication.ui.theme.TestApplicationTheme
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun MainPage() {
    val navController = rememberNavController()
//    NavigationEffects(
//        navigationChannel = mainViewModel.navigationChannel,
//        navHostController = navController
//    )
    TestApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.onBackground
        ) {
            NavHost(
                navController = navController,
                startDestination = Destination.DiscoverScreen
            ) {
                composable(destination = Destination.DiscoverScreen) {
                    DiscoverListPage()
                }
            }
        }
    }
}

@Composable
fun NavigationEffects(
    navigationChannel: Channel<NavigationIntent>,
    navHostController: NavHostController
) {
    val activity = (LocalContext.current as? Activity)
    LaunchedEffect(activity, navHostController, navigationChannel) {
        navigationChannel.receiveAsFlow().collect { intent ->
            if (activity?.isFinishing == true) {
                return@collect
            }
            when (intent) {
                is NavigationIntent.toBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }
                is NavigationIntent.toNamed -> {
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}