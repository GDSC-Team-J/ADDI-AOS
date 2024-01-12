package com.gdsc.addi.ui.feature.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.gdsc.addi.R
import com.gdsc.addi.ui.theme.AddiDesignSystem
import com.gdsc.addi.ui.theme.AddiTheme

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onEvent: (LoginState) -> Unit,
) {
    viewModel.checkUserState()

    val alpha: Float by animateFloatAsState(
        targetValue = if (LocalLifecycleOwner.current.lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000,
            easing = LinearEasing
        ),
        label = ""
    )

    LaunchedEffect(alpha) {
        if (alpha >= 1f) {
            viewModel.loginState.collect { state ->
                onEvent(state)
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            modifier = Modifier.alpha(alpha)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = stringResource(id = R.string.enter_title),
            style = AddiDesignSystem.typography.button,
            color = AddiDesignSystem.colors.black,
            modifier = Modifier.alpha(alpha)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    AddiTheme {
        //SplashScreen({})
    }
}
