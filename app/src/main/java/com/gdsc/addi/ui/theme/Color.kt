package com.gdsc.addi.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)
val GreenButton = Color(0xFF52AC41)
val GreenBackground = Color(0xFF99E9AF)
val GreenRecord = Color(0xFFBEF5B3)
val GrayBorder = Color(0xFF323232)

@Stable
class AddiColorScheme(
    black: Color,
    white: Color,
    buttonGreen: Color,
    backgroundGreen: Color,
    recordGreen: Color,
    grayBorder: Color
) {
    var black by mutableStateOf(black, structuralEqualityPolicy())
        internal set
    var white by mutableStateOf(white, structuralEqualityPolicy())
        internal set
    var buttonGreen by mutableStateOf(buttonGreen, structuralEqualityPolicy())
        internal set
    var backgroundGreen by mutableStateOf(backgroundGreen, structuralEqualityPolicy())
        internal set
    var recordGreen by mutableStateOf(recordGreen, structuralEqualityPolicy())
        internal set

    var grayBorder by mutableStateOf(grayBorder, structuralEqualityPolicy())
        internal set

    fun copy(
        black: Color,
        white: Color,
        buttonGreen: Color,
        backgroundGreen: Color,
        recordGreen: Color,
        grayBorder: Color
    ) = AddiColorScheme(
        black = black,
        white = white,
        buttonGreen = buttonGreen,
        backgroundGreen = backgroundGreen,
        recordGreen = recordGreen,
        grayBorder = grayBorder
    )

}

fun addiDefaultColorScheme() = AddiColorScheme(
    black = Black,
    white = White,
    buttonGreen = GreenButton,
    backgroundGreen = GreenBackground,
    recordGreen = GreenRecord,
    grayBorder = GrayBorder
)
