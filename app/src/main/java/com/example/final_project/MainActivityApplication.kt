package com.example.final_project

import Firebase.DBMainActivity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_application.*
import kotlinx.android.synthetic.main.activity_main_application.tvName
import kotlinx.android.synthetic.main.activity_main_application.tvPhone


class MainActivityApplication : AppCompatActivity() {

    private lateinit var alertDialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_application)


        btStart.setOnClickListener {

            if ( (TextUtils.isEmpty(edEnterName.text.toString())) || (TextUtils.isEmpty(edEnterCountry.text.toString())) || (TextUtils.isEmpty(edDays.text.toString())) || (TextUtils.isEmpty(edPhone.text.toString()))) {
                createDialogError()

            } else {
                createDialogOK()

            }
        }



        changeLangforApp()
        goToDBApp()

    }


    fun createDialogOK() {

        val alertDialogBuilder = AlertDialog.Builder(this)

        if (swLangApp.isChecked) {
            alertDialogBuilder.setTitle("Заявка була відправлена! Ми Вам скоро зателефонуємо!")
        }
        else {
            alertDialogBuilder.setTitle("Application was sent! We will call you back soon!")
        }
        alertDialogBuilder.setPositiveButton("OK") { _: DialogInterface, _: Int ->
            //finish()
        }

        alertDialog = alertDialogBuilder.create()
        alertDialog.show()

    }


    fun createDialogError() {

        val alertDialogBuilder = AlertDialog.Builder(this)

        if (swLangApp.isChecked) {
            alertDialogBuilder.setTitle("Будь-ласка, заповніть форму!")
        }
        else {
            alertDialogBuilder.setTitle("Please, fill the form!")
        }

        alertDialogBuilder.setPositiveButton("OK") { _: DialogInterface, _: Int ->
            //finish()
        }

        //alertDialogBuilder.setNegativeButton("Cancel", { dialogInterface: DialogInterface, i: Int -> })

        alertDialog = alertDialogBuilder.create()
        alertDialog.show()

    }

    fun changeLangforApp() {
        swLangApp.setOnClickListener {
            if (swLangApp.isChecked) {

                tvName.setText("Ім'я та Прізвище")
                tvCountryVisit.setText("Країна відпочинку")
                tvDays.setText("Кількість днів")
                tvPhone.setText("Телефон")
                tvStartapp.setText("Надіслати")
                tvbuttonDB.setText("Для Розробників")
                swLangApp.setText("АНГЛ")
                tvLangApp.setText("УКР")


            } else {

                tvName.setText("Name and Surname")
                tvCountryVisit.setText("Country for visit")
                tvDays.setText("Days for stay")
                tvPhone.setText("Phone")
                tvStartapp.setText("Send")
                tvbuttonDB.setText("For Developers")
                swLangApp.setText("ENG")
                tvLangApp.setText("UKR")

            }
        }
    }

    fun goToDBApp() {

        buttonDB.setOnClickListener {
            val intent = Intent(this, DBMainActivity::class.java)
            intent.putExtra("Application", edEnterName.text.toString().trim() + "/" + edEnterCountry.text.toString().trim() + "/" + edDays.text.toString().trim() + "/" + edPhone.text.toString().trim())
            startActivity(intent)


        }
    }


}




