package com.gdsc.addi.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdsc.addi.ui.theme.AddiDesignSystem

@Composable
fun RecordButton(
    modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = AddiDesignSystem.colors.recordGreen,
        contentColor = AddiDesignSystem.colors.black
    ),
    shape: Shape = CircleShape,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) = Button(
    modifier = modifier.aspectRatio(1f),
    border = BorderStroke(3.dp, AddiDesignSystem.colors.grayStroke),
    colors = buttonColors,
    shape = shape,
    onClick = onClick
) {
    ProvideTextStyle(value = AddiDesignSystem.typography.button) {
        content()
    }
}

@Preview
@Composable
fun RecordButtonPreview() {
    RecordButton(
        onClick = {}
    ) {
        Text(text = "hello")
    }
}
