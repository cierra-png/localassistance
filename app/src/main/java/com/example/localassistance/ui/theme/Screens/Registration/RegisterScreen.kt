package com.example.localassistance.ui.theme.Screens.Registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hildafirebase.data.AuthViewmodel
import com.example.localassistance.R
import com.example.localassistance.navigations.ROUTE_LOGIN

@Composable
fun RegisterScreen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confpass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    Box (
        modifier = Modifier
               .fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.registerimage) ,
            contentDescription ="Register" )

    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "Register Here",
            color= Color.Blue,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value =email ,
            onValueChange ={email=it},
            label = { Text(text = "Enter Email")},

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

            )
        OutlinedTextField(
            value =pass ,
            onValueChange ={pass=it},
            label = { Text(text = "Enter password")},

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

            )
        OutlinedTextField(
            value =confpass ,
            onValueChange ={confpass=it},
            label = { Text(text = "Confirm password")},

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        )
        Button(onClick = {
            val myregister=AuthViewmodel(navController,context)
            myregister.register(email.text.trim(),pass.text.trim(),confpass.text.trim())
        },
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        },
            modifier = Modifier.fillMaxWidth()
            ) {
            Text(text = "Have an account?Click to Login")
        }
    }
    
}

@Preview
@Composable
private fun Registerprev() {
    RegisterScreen(rememberNavController())
}