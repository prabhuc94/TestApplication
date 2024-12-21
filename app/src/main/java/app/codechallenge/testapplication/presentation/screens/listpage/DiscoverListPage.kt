package app.codechallenge.testapplication.presentation.screens.listpage

import android.content.res.Resources.Theme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun DiscoverListPage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Text(text = "Discover", style = TextStyle(
                fontStyle = FontStyle.Normal,
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold
            ))
            Text(text = "News from all round the world", style = TextStyle(
                fontStyle = FontStyle.Normal,
                fontSize = 13.sp,
                fontWeight = FontWeight.Thin
            ))
        }
    }
}