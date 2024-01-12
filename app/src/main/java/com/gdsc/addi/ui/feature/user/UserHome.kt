package com.gdsc.addi.ui.feature.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdsc.addi.R
import com.gdsc.addi.ui.component.AddiButton
import com.gdsc.addi.ui.theme.AddiDesignSystem
import com.gdsc.addi.ui.theme.AddiTheme

@Composable
fun UserHome(

) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.size(100.dp))
            UserHomeTitle()
            Spacer(Modifier.size(58.dp))
            UserHomeLogo()
        }
        UserHomeButton(
            {}
        )
    }
}

@Composable
fun UserHomeTitle() {
    Text(
        text = stringResource(id = R.string.user_home_title),
        style = AddiDesignSystem.typography.title,
        color = AddiDesignSystem.colors.black,
    )
}

@Composable
fun UserHomeLogo() {
    Icon(
        painter = painterResource(id = R.drawable.ic_logo),
        contentDescription = null,
        tint = AddiDesignSystem.colors.black,
    )
}


@Composable
fun UserHomeButton(
    onClickRecord: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        AddiButton(
            onClick = { /*TODO*/ },
        ) {
            Text(text = stringResource(id = R.string.user_home_button))
        }
        Spacer(Modifier.size(40.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun UserHomePreview() {
    AddiTheme {
        UserHome()
    }
}