package com.gdsc.addi.ui.feature.enter

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
fun EnterScreen(
    onClickGuardianEnter: () -> Unit,
    onClickUserEnter: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EnterLogo()
        EnterButtons(
            onClickGuardianEnter = onClickGuardianEnter,
            onClickUserEnter = onClickUserEnter
        )
    }
}

@Composable
fun EnterLogo() {
    Column {
        Spacer(modifier = Modifier.size(120.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            tint = AddiDesignSystem.colors.black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = stringResource(id = R.string.enter_title),
            style = AddiDesignSystem.typography.button,
            color = AddiDesignSystem.colors.black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun EnterButtons(
    onClickGuardianEnter: () -> Unit,
    onClickUserEnter: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        AddiButton(
            onClick = onClickGuardianEnter
        ) {
            Text(text = stringResource(id = R.string.enter_guardian))
        }

        Spacer(modifier = Modifier.size(16.dp))

        AddiButton(
            onClick = onClickUserEnter
        ) {
            Text(text = stringResource(id = R.string.enter_user))
        }
        Spacer(modifier = Modifier.size(40.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun EnterScreenPreview() {
    AddiTheme {
        EnterScreen({}, {})
    }
}