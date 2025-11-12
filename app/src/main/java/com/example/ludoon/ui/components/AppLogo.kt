package com.example.ludoon.ui.components


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.ludoon.R
import com.example.ludoon.ui.theme.fontXXLarge

@Composable
fun AppLogo(){
    Text(
        text = stringResource(R.string.app_name),
        style = TextStyle(
            fontSize = fontXXLarge,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.billabong))
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun AppLogoPreview(){
    AppLogo()
}