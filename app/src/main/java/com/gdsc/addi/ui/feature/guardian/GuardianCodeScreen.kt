package com.gdsc.addi.ui.feature.guardian

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gdsc.addi.R
import com.gdsc.addi.ui.component.AddiButton
import com.gdsc.addi.ui.theme.AddiDesignSystem
import com.gdsc.addi.ui.theme.AddiTheme
import com.gdsc.addi.ui.utils.UiEvent

/** Todo ime 설정하기 */
@Composable
fun GuardianCodeScreen(
    viewModel: GuardianCodeViewModel = hiltViewModel(),
    onEvent: (UiEvent) -> Unit
) {
    LaunchedEffect(true) {
        viewModel.uiEvent.collect { uiEvent ->
            onEvent(uiEvent)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

        Column {
            Spacer(modifier = Modifier.size(120.dp))
            GuardianCodeTitle()

            GuardianCodeTextField(
                textFieldValue = textFieldValue,
                onValueChange = { newValue -> textFieldValue = newValue },
            )
        }
        Column {
            GuardianCodeButton(
                onClickEnter = { viewModel.postGuardianSignup(textFieldValue.text) }
            )
            Spacer(modifier = Modifier.size(40.dp))
        }
    }
}

@Composable
fun GuardianCodeTitle() {
    Text(
        text = stringResource(id = R.string.guardian_code_title),
        style = AddiDesignSystem.typography.button,
        color = AddiDesignSystem.colors.black,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuardianCodeTextField(
    textFieldValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
) {
    TextField(
        value = textFieldValue,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = AddiDesignSystem.colors.recordGreen,
            cursorColor = AddiDesignSystem.colors.black,
            focusedIndicatorColor = AddiDesignSystem.colors.buttonGreen,
            unfocusedIndicatorColor = AddiDesignSystem.colors.buttonGreen
        ),
        shape = RoundedCornerShape(8.dp)
    )
}

@Composable
fun GuardianCodeButton(
    onClickEnter: () -> Unit
) {
    Box(modifier = Modifier.padding(horizontal = 16.dp)) {
        AddiButton(
            onClick = onClickEnter,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.guardian_code_enter))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GuardianCodeScreenPreview() {
    AddiTheme {
        //GuardianCode({})
    }
}
