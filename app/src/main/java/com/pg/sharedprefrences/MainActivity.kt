package com.pg.sharedprefrences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var et_userName: EditText
    lateinit var et_password: EditText
    lateinit var btn_login: Button
    lateinit var btn_register: Button
    lateinit var tv_userName: TextView
    lateinit var tv_password: TextView
    lateinit var iv_banklogo:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        et_password = findViewById(R.id.et_password)
        et_userName = findViewById(R.id.et_userName)
        btn_login = findViewById(R.id.btn_login)
        btn_register = findViewById(R.id.btn_register)
        tv_userName = findViewById(R.id.tv_userName)
        tv_password = findViewById(R.id.tv_password)
        iv_banklogo=findViewById(R.id.iv_bank_logo)
        var mySharedPref = this.getSharedPreferences("My_app_pref", Context.MODE_PRIVATE)


        btn_register.setOnClickListener {

            var myIntent = Intent(this, registerActivity::class.java)
            startActivity(myIntent)


        }
        btn_login.setOnClickListener {
            val userName = mySharedPref.getString(getString(R.string.user_name), "")
            val password = mySharedPref.getString(getString(R.string.user_pass), "")
//            if (userName == et_userName.text.toString()){
//                if  (password == et_password.text.toString()){
//                    var myIntent2: Intent = Intent(this, homeActivity::class.java)
//                    startActivity(myIntent2)
//                }
//                else{
//                    Toast.makeText(this, "enter valid password", Toast.LENGTH_SHORT).show()
//                }
//            }
//            else{
//                Toast.makeText(this, "enter valid name", Toast.LENGTH_SHORT).show()
//            }

            if (userName == et_userName.text.toString() && password == et_password.text.toString()){
                var myIntent2: Intent = Intent(this, homeActivity::class.java)
                startActivity(myIntent2)
            }else{
                Toast.makeText(this, "Username or Password is wrong", Toast.LENGTH_SHORT).show()
            }

//            if (userName != et_userName.text.toString()){
//                Toast.makeText(this, "Username or Password is wrong", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//            if (password != et_password.text.toString()){
//                Toast.makeText(this, "Username or Password is wrong", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            var myIntent2: Intent = Intent(this, homeActivity::class.java)
//            startActivity(myIntent2)

        }

        }

    }

//    // Create SharedPreference Object
//    var mySharedPref = this.getSharedPreferences("My_app_pref", Context.MODE_PRIVATE)
//
//    // Save values in SharedPreference using key-value pair
//    with(mySharedPref.edit()) {
//        putString(getString(R.string.user_name), et_userName.text.toString())
//        putString(getString(R.string.user_pass), et_password.text.toString())
//        apply()
//    }
//
//    // Reading values from SharedPreference
//    val userName = mySharedPref.getString(getString(R.string.user_name), "")





