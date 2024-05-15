package com.example.localassistance.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.hildafirebase.data.AuthViewmodel
import com.example.localassistance.model.Service
import com.example.localassistance.navigations.ROUTE_SERVICEPROVIDER
import com.google.firebase.database.FirebaseDatabase


class ServiceviewModel (var navController: NavHostController,var context:Context){
    var authRepository:AuthViewmodel
    var progress:ProgressDialog

    init {
        authRepository=AuthViewmodel(navController,context)
        if (!authRepository.isloggedin()){
            navController.navigate(ROUTE_SERVICEPROVIDER)
        }
        progress= ProgressDialog(context)
        progress.setTitle("loading")
        progress.setMessage("Please wait")
    }
    fun BookService(name:String,descripton:String,id:String){
        var id= System.currentTimeMillis().toString()
        var servicedata=Service(name,descripton,id)
        var serviceRef=FirebaseDatabase.getInstance().getReference()
            .child("Services/$id")
        progress.show()
        serviceRef.setValue(servicedata).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context,"Booking is successful",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context,"Not available",Toast.LENGTH_LONG).show()
            }
        }

    }
}