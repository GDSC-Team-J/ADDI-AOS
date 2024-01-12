package com.gdsc.addi.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gdsc.addi.R

val NotoSansKrBold = FontFamily(Font(R.font.noto_sans_kr_bold_f, FontWeight.Bold))
val MontserratBold = FontFamily(Font(R.font.montserrat_bold_f))

// Set of Material typography styles to start with
fun addiTypography() = AddiTypography(
    title = TextStyle(
        fontSize = 30.sp,
        fontFamily = NotoSansKrBold,
        fontWeight = FontWeight.Normal
    ),
    button = TextStyle(
        fontSize = 18.sp,
        fontFamily = NotoSansKrBold,
        fontWeight = FontWeight.Normal
    ),
    logo = TextStyle(
        fontSize = 12.sp,
        fontFamily = MontserratBold,
        fontWeight = FontWeight.Normal
    ),
)

@Immutable
data class AddiTypography internal constructor(
    val title: TextStyle,
    val button: TextStyle,
    val logo: TextStyle
)
