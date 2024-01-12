package com.gdsc.addi.ui.feature.record

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gdsc.addi.R
import com.gdsc.addi.ui.component.AddiButton
import com.gdsc.addi.ui.component.RecordButton
import com.gdsc.addi.ui.theme.AddiDesignSystem
import com.gdsc.addi.ui.theme.AddiTheme

@Composable
fun RecordScreen(
    onRecord: (Boolean) -> Unit,
    viewModel: RecordViewModel = hiltViewModel()
) {
    viewModel.getQuestions()
    val questions = viewModel.questions.collectAsState()
    val currentQuestionIndex = remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RecordTitle(title = questions.value.getOrNull(currentQuestionIndex.value) ?: "")
        RecordButton(onRecord = onRecord)
        Column {
            RecordNextButton(
                onClickNext = {
                    val nextIndex = currentQuestionIndex.value + 1
                    if (nextIndex < questions.value.size) {
                        currentQuestionIndex.value = nextIndex
                    } else {
                        // 마지막 질문까지 표시되었을 때
//                        RecordDone()
                        Log.d("asdf", "끝")
                    }
                },
                content = stringResource(id = R.string.user_record_submit)
            )
            Spacer(modifier = Modifier.size(40.dp))
        }
    }
}

@Composable
fun RecordTitle(
    title: String
) {
    Column {
        Spacer(Modifier.size(100.dp))
        Text(
            text = title,
            style = AddiDesignSystem.typography.title,
            color = AddiDesignSystem.colors.black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun RecordButton(
    onRecord: (Boolean) -> Unit
) {
    val isRecording = remember { mutableStateOf(false) }

    RecordButton(
        onClick = {
            isRecording.value = !isRecording.value
            onRecord(isRecording.value)
        },
        modifier = Modifier.padding(horizontal = 52.dp)
    ) {
        val buttonText = if (isRecording.value) {
            stringResource(id = R.string.user_record_stop)
        } else {
            stringResource(id = R.string.user_record_press)
        }
        Text(
            text = buttonText,
            style = AddiDesignSystem.typography.title,
            color = AddiDesignSystem.colors.black,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun RecordNextButton(
    onClickNext: () -> Unit,
    content: String
) {
    Box(modifier = Modifier.padding(horizontal = 16.dp)) {
        AddiButton(
            onClick = onClickNext,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(text = content)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecordScreenPreview() {
    AddiTheme {
        RecordScreen(
            {}
        )
    }
}