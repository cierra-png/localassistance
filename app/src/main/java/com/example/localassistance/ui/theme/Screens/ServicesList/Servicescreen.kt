package com.example.localassistance.ui.theme.Screens.ServicesList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.localassistance.R


data class ServicesModel(val name:String,val description:String, val image : Int)

@Composable
fun Servicescreen(model: ServicesModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .padding(8.dp)

        )
        Text(
            text = model.name,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
        Text(text =model.description,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace,
            color = Color.Black
            )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Book")
        }
    }
}
private val ServicesviewModel = mutableListOf<ServicesModel>().apply {

    add(ServicesModel("plumbing","fixing leaking pipes and installing pipes",R.drawable.plumbing))
    add(ServicesModel("electrician","installing electric gadgets and fixing open wires ",R.drawable.electrician))
    add(ServicesModel("cleaning","Doing laundry work and House keeping",R.drawable.cleaning))
}

@Composable
fun MyServiceList(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(ServicesviewModel) { model ->
            Servicescreen(model = model)
        }
    }



}

@Preview
@Composable
private fun Servicescreenprev() {
    MyServiceList(rememberNavController())
}