package com.gdsc.addi.ui.feature.record

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdsc.addi.R
import com.gdsc.addi.ui.component.AddiButton
import com.gdsc.addi.ui.component.RecordButton
import com.gdsc.addi.ui.theme.AddiDesignSystem
import com.gdsc.addi.ui.theme.AddiTheme

@Composable
fun Record(
    type: RecordType
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RecordTitle(type)
        RecordButton()
        Column {
            /** TODO state 분리하기 */
            RecordNextButton(
                onClickNext = {}
            )
            Spacer(modifier = Modifier.size(40.dp))
        }
    }
}

@Composable
fun RecordTitle(type: RecordType) {
    Column {
        Spacer(Modifier.size(100.dp))
        Text(
            text = type.title,
            style = AddiDesignSystem.typography.title,
            color = AddiDesignSystem.colors.black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun RecordButton() {
    RecordButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(horizontal = 52.dp)
    ) {
        Text(
            text = stringResource(id = R.string.user_record_press),
            style = AddiDesignSystem.typography.title,
            color = AddiDesignSystem.colors.black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RecordNextButton(
    onClickNext: () -> Unit
) {
    Box(modifier = Modifier.padding(horizontal = 16.dp)) {
        AddiButton(
            onClick = onClickNext,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.guardian_code_enter))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecordScreenPreview() {
    AddiTheme {
        Record(RecordType.GUARDIAN)
    }
}