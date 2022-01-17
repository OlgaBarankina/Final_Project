package com.example.final_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.swLanguage
import kotlinx.android.synthetic.main.activity_main_countries.*

class MainActivityCountries : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_countries)


        swLangCountry.setOnClickListener {
            if (swLangCountry.isChecked) {

                tvFrance.setText("Франція")
                tvDominicana.setText("Домінікана")
                tvAndora.setText("Андора")
                tvTailand.setText("Таїланд")
                tvEmirates.setText("ОАЕ")
                swLangCountry.setText("АНГЛ")
                tvLangCountry.setText("УКР")

            } else {

                tvFrance.setText("France")
                tvDominicana.setText("Dominicana")
                tvAndora.setText("Andora")
                tvTailand.setText("Tailand")
                tvEmirates.setText("Emirates")
                swLangCountry.setText("ENG")
                tvLangCountry.setText("UKR")

            }
        }









    }
}

