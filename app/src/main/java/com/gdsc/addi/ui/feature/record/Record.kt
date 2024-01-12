package com.gdsc.addi.ui.feature.record

import androidx.compose.foundation.layout.Arrangement
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
import com.gdsc.addi.ui.RecordType
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
        Column {
            Spacer(Modifier.size(100.dp))
            Text(
                text = type.title,
                style = AddiDesignSystem.typography.title,
                color = AddiDesignSystem.colors.black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.size(100.dp))
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
    }
}

@Preview(showBackground = true)
@Composable
fun RecordScreenPreview() {
    AddiTheme {
        Record(RecordType.GUARDIAN)
    }
}