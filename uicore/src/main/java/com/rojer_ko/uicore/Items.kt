package com.rojer_ko.uicore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rojer_ko.model.dto.info.StationsInfo

class Items {

    companion object {

        @Composable
        fun StationItem(station: StationsInfo, itemClick: (StationsInfo) -> Unit) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White
                    )
                    .padding(horizontal = 16.dp, vertical = 5.dp)
                    .clickable {
                        itemClick(station)
                    }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_bike),
                        contentDescription = null,
                        Modifier
                            .size(40.dp)
                    )
                    if (station.is_charging_station) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_charging),
                            contentDescription = null,
                            Modifier
                                .size(20.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = station.name,
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.W600
                        )
                    )
                    Text(
                        text = station.physical_configuration,
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 13.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.W600
                        )
                    )
                }
            }
        }
    }
}