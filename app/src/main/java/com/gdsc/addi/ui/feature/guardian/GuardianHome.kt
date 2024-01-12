package com.gdsc.addi.ui.feature.guardian

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdsc.addi.R
import com.gdsc.addi.ui.component.AddiButton
import com.gdsc.addi.ui.theme.AddiDesignSystem
import com.gdsc.addi.ui.theme.AddiTheme

@Composable
fun GuardianHome(

) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Spacer(Modifier.size(100.dp))
            GuardianHomeTitle()
            Spacer(Modifier.size(58.dp))
            GuardianHomeGraph()
        }
        GuardianHomeButton(
            onClickRecord = {}
        )
    }
}

@Composable
fun GuardianHomeTitle() {
    Text(
        text = stringResource(id = R.string.guardian_home_title),
        style = AddiDesignSystem.typography.title,
        color = AddiDesignSystem.colors.black,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun GuardianHomeGraph() {
    /** TODO graph */
}


@Composable
fun GuardianHomeButton(
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
            Text(text = stringResource(id = R.string.guardian_home_voice_record))
        }
        Spacer(Modifier.size(40.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GuardianHomePreview() {
    AddiTheme {
        GuardianHome()
    }
}