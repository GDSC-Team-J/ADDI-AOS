package com.gdsc.addi.ui.feature.record

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.gdsc.addi.ui.theme.AddiDesignSystem
import com.gdsc.addi.ui.theme.AddiTheme

@Composable
fun RecordDone(onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RecordDoneTitle(stringResource(id = R.string.user_record_done_title))
        RecordDoneButton(stringResource(id = R.string.user_record_done_button), onClick)
    }
}

@Composable
fun RecordDoneTitle(
    title: String
) {
    Column {
        Spacer(Modifier.size(250.dp))
        Text(
            text = title,
            style = AddiDesignSystem.typography.title,
            color = AddiDesignSystem.colors.black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RecordDoneButton(
    content: String, onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        AddiButton(
            onClick = onClick,
        ) {
            Text(text = content)
        }
        Spacer(Modifier.size(40.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun RecordDonePreview() {
    AddiTheme {
        //RecordDone(RecordType. USER)
    }
}
