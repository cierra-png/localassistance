package com.example.hildafirebase.data

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.localassistance.navigations.ROUTE_HOME
import com.example.localassistance.navigations.ROUTE_LOGIN
import com.example.localassistance.navigations.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class AuthViewmodel (var navController: NavHostController,var context: android.content.Context){

    var mAuth:FirebaseAuth
    val progress:ProgressDialog

    init {
        mAuth=FirebaseAuth.getInstance()
        progress= ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please Wait.....")
    }
    @SuppressLint("RestrictedApi")
    fun register(email:String, pass:String, confpass:String){
        progress.show()

        if (email.isBlank() || pass.isBlank() || confpass.isBlank()){
            progress.dismiss()
            Toast.makeText(context,"email and password cannot be blank",Toast.LENGTH_LONG).show()
            return
        }
        else if (pass!=confpass){
            Toast.makeText(context,"password does not match",Toast.LENGTH_LONG).show()
            return
        }
        else{
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
            if (it.isSuccessful){
                val userdata=
                    com.example.localassistance.model.User(email, pass, mAuth.currentUser!!.uid)
                val regRef=FirebaseDatabase.getInstance().getReference()
                    .child("Users/"+mAuth.currentUser!!.uid)
                regRef.setValue(userdata).addOnCompleteListener{

                    if (it.isSuccessful){
                        Toast.makeText(context,"Registered Successfully",Toast.LENGTH_LONG).show()
                        navController.navigate(ROUTE_LOGIN)
                    }
                    else{
                        Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                        navController.navigate(ROUTE_LOGIN)
                    }

                }
            }else{
                navController.navigate(ROUTE_REGISTER)
                }

            }
        }
    }

    fun login(email: String,pass: String){
        progress.show()

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context,"Login successfully",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_HOME)
//                NavController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIFFERENT PAGE
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
        }
    }

    fun isloggedin(): Boolean {
        return mAuth.currentUser!=null

    }


}


