package com.luanlima.gridapp

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luanlima.gridapp.ui.theme.GridAppTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GridAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Card(
                        topic = DataSource.topics[0],
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Card(topic: Topic, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .height(68.dp)
            .width(180.dp)
            .clip(RoundedCornerShape(10.dp)),
        color = Color.Gray,
    ) {
        Row {
            Image(
                painter = painterResource(topic.image),
                contentDescription = null,
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp)
            )
            Column(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 16.dp,
                ),
            ) {
                Text(
                    stringResource(topic.name),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        bottom = 8.dp
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Star,
                        contentDescription = null,
                    )
                    Text(
                        topic.number.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier =  Modifier.padding(
                            start = 8.dp
                        ),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GridAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Card(
                topic = DataSource.topics[0],
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}