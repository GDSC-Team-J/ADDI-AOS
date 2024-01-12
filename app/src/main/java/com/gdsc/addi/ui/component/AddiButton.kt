package com.gdsc.addi.ui.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun AddiButton(
    modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = AddiDesignSystem.colors.buttonGreen,
        contentColor = AddiDesignSystem.colors.white
    ),
    shape: Shape = RoundedCornerShape(8.dp),
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) = Button(
    modifier = Modifier.fillMaxWidth(),
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
fun AddiButtonPreview() {
    AddiButton(
        onClick = {}
    ) {
        Text(text = "hello")
    }
}
