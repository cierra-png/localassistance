package com.example.localassistance.ui.theme.Screens.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.localassistance.navigations.ROUTE_LOGIN
import com.example.localassistance.navigations.ROUTE_SERVICEPROVIDER



@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        var context= LocalContext.current
        Text(text = "Welcome to our Homepage",
            color = Color.Yellow,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(120.dp))

        Button(onClick = {
            navController.navigate(ROUTE_SERVICEPROVIDER)
        },
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Services" )
        }
        Spacer(modifier = Modifier.height(80.dp))

    }
}

@Preview
@Composable
private fun HomeScreenprev() {
    HomeScreen(rememberNavController())

}