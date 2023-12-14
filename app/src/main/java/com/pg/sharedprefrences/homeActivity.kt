package com.pg.sharedprefrences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class homeActivity : AppCompatActivity() {
   lateinit var tv_userName:TextView
    lateinit var tv_given_userName:TextView
    lateinit var tv_password:TextView
    lateinit var tv_given_password:TextView
    lateinit var tv_mobile_no:TextView
    lateinit var tv_given_mobile_no:TextView
    lateinit var tv_gender:TextView
    lateinit var tv_selected_gender:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var mySharedPref = this.getSharedPreferences("My_app_pref", Context.MODE_PRIVATE)

        tv_userName = findViewById(R.id.tv_userName)
        tv_password = findViewById(R.id.tv_password)
        tv_mobile_no = findViewById(R.id.tv_mobile_no)
        tv_gender = findViewById(R.id.tv_gender)
        tv_given_password = findViewById(R.id.tv_given_password)
        tv_given_mobile_no = findViewById(R.id.tv_given_mobile_no)
        tv_given_userName = findViewById(R.id.tv_given_userName)
        tv_selected_gender = findViewById(R.id.tv_selected_gender)

        val userName = mySharedPref.getString(getString(R.string.user_name), "")
        val password = mySharedPref.getString(getString(R.string.user_pass), "")
        val mobileNo = mySharedPref.getString(getString(R.string.user_mobile), "")
        val strGender = mySharedPref.getString(getString(R.string.gender), "")

        tv_given_userName.text = userName
        tv_given_password.text = password
        tv_given_mobile_no.text = mobileNo
        tv_selected_gender.text = strGender

    }
}