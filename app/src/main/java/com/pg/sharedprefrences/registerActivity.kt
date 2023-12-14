package com.pg.sharedprefrences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class registerActivity : AppCompatActivity() {
    lateinit var et_userName: EditText
    lateinit var et_password: EditText
    lateinit var et_mobile_no: EditText

    lateinit var tv_select_gender: TextView
    lateinit var rb_male: RadioButton
    lateinit var rb_female: RadioButton
    lateinit var rb_other: RadioButton
    lateinit var rg_select_gender: RadioGroup
    lateinit var btn_register: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        et_userName = findViewById(R.id.et_userName)
        et_password = findViewById(R.id.et_password)
        et_mobile_no = findViewById(R.id.et_mobile_no)
        rb_female = findViewById(R.id.rb_female)
        rb_male = findViewById(R.id.rb_male)
        rb_other = findViewById(R.id.rb_other)
        btn_register = findViewById(R.id.btn_register)
        rg_select_gender = findViewById(R.id.rg_select_gender)


        var mySharedPref = this.getSharedPreferences("My_app_pref", Context.MODE_PRIVATE)


        btn_register.setOnClickListener {
            //   if (et_userName.text.toString().isNotEmpty() && et_password.text.toString()
            //          .isNotEmpty() && et_mobile_no.text.toString().isNotEmpty() && et_mobile_no.text.toString().length==10
            //  )
            {

                with(mySharedPref.edit()) {
                    putString(getString(R.string.user_name), et_userName.text.toString())
                    putString(getString(R.string.user_pass), et_password.text.toString())
                    putString(getString(R.string.user_mobile), et_mobile_no.text.toString())
                    apply()
                    finish()
                }

            }
            // else {
            //Toast.makeText(baseContext,"username password shouldnt empty", Toast.LENGTH_SHORT).show()

            if (et_userName.text.toString().isNotEmpty())
                if (et_password.text.toString()
                        .isNotEmpty() && et_password.text.toString().length >= 4 && et_password.text.toString().length <= 10
                )
                    if (et_mobile_no.text.toString()
                            .isNotEmpty() && et_mobile_no.text.toString().length == 10
                    )
                        if (rg_select_gender.checkedRadioButtonId != -1) {

                            with(mySharedPref.edit()) {
                                putString(
                                    getString(R.string.user_name),
                                    et_userName.text.toString()
                                )
                                putString(
                                    getString(R.string.user_pass),
                                    et_password.text.toString()
                                )
                                putString(
                                    getString(R.string.user_mobile),
                                    et_mobile_no.text.toString()
                                )
                                var selectedGenderRB = findViewById<RadioButton>(rg_select_gender.checkedRadioButtonId)
                                putString(getString(R.string.gender),selectedGenderRB.text.toString() )

                                apply()

                            }
                            finish()
                        }

                    else{
                        Toast.makeText(baseContext, "select gender", Toast.LENGTH_SHORT).show()
                        }
                    else {
                        Toast.makeText(baseContext, "enter correct Mo no.", Toast.LENGTH_SHORT)
                            .show()
                    }
                else {
                    Toast.makeText(
                        baseContext,
                        "password lenght should be 4 to 10 number ",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            else {
                Toast.makeText(baseContext, "Enter correct username", Toast.LENGTH_SHORT).show()
            }

        }

    }

}
