package com.gdsc.addi.ui.feature.guardian

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import com.gdsc.addi.R
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
    val pieChartData = PieChartData(
        slices = listOf(
            PieChartData.Slice(
                label = "슬픔",
                value = 65f,
                color = Color(0xFFDF5D5D)
            ),
            PieChartData.Slice(
                label = "낙담",
                value = 35f,
                color = Color(0xFFFFC39A)
            ),
            PieChartData.Slice(
                label = "화남",
                value = 10f,
                color = Color(0xFFFDB6CE)
            ),
            PieChartData.Slice(
                label = "즐거움",
                value = 40f,
                color = Color(0xFFE96D74)
            ),
            PieChartData.Slice(
                label = "실망",
                value = 40f,
                color = Color(0xFFFF9367)
            )
        ),
        plotType = PlotType.Pie
    )
    PieChart(
        modifier = Modifier
            .width(440.dp)
            .height(440.dp),
        pieChartData = pieChartData,
        pieChartConfig = PieChartConfig(
            isAnimationEnable = true,
            showSliceLabels = true,
            isSumVisible = true,
            activeSliceAlpha = 0.5f,
            chartPadding = 5,
            sliceLabelTextColor = Color.Black,
            sliceLabelTextSize = 30.sp,
            animationDuration = 1400,
        )
    )
}


//@Composable
//fun GuardianHomeButton(
//    onClickRecord: () -> Unit
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp)
//    ) {
//        AddiButton(
//            onClick = { /*TODO*/ },
//        ) {
//            Text(text = stringResource(id = R.string.guardian_home_voice_record))
//        }
//        Spacer(Modifier.size(40.dp))
//    }
//}

@Preview(showBackground = true)
@Composable
fun GuardianHomePreview() {
    AddiTheme {
        GuardianHome()
    }
}