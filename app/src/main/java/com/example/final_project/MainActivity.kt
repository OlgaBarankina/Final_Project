package com.example.final_project

import Location.MainActivityLocation
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_location.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        goToCountries()
        goToDiscounts()
        goToApplication()
        goToPersonalDiscount()
        changeLanguage()
        goToLocationApp()

    }


    fun goToCountries() {

        ivCountiresButtom.setOnClickListener {
            val intent = Intent(this, MainActivityCountries::class.java)
            startActivity(intent)
        }
    }

    fun goToDiscounts() {

        ivDiscountsButtom.setOnClickListener {
            val intent = Intent(this, MainActivityDiscounts::class.java)
            startActivity(intent)
        }
    }


    fun goToApplication() {

            tvApplication.setOnClickListener {
                val intent = Intent(this, MainActivityApplication::class.java)
                startActivity(intent)
            }
        }


    fun goToPersonalDiscount() {

            ivGetDiscount.setOnClickListener {
                val intent = Intent(this, MainActivityDrum::class.java)
                startActivity(intent)
            }
        }


    fun changeLanguage() {
        swLanguage.setOnClickListener {
            if (swLanguage.isChecked) {

                tvName.setText("Туристичне агенство")
                tvLongDescription.setText("Подорожуй з нами за \n найвигіднішими цінами!")
                tvCountries.setText("Туристичні маршрути")
                tvDiscounts.setText("Тури зі знижками")
                tvApplication.setText("Залишити анкету")
                tvGetDiscount.setText("Виграй знижку")
                tvButtonLocation.setText("Наші відділення")
                swLanguage.setText("АНГЛ")
                tvLanguage.setText("УКР")

            } else {

                tvName.setText("Travel Agency")
                tvLongDescription.setText("Travel with us for BEST prices!")
                tvCountries.setText("Countries to visit")
                tvDiscounts.setText("Tours with Sales")
                tvApplication.setText("Leave Application")
                tvGetDiscount.setText("Get Discount")
                tvButtonLocation.setText("Our Branches")
                swLanguage.setText("ENG")
                tvLanguage.setText("UKR")
            }
        }
    }



    fun goToLocationApp() {

        tvButtonLocation.setOnClickListener {
            val intent = Intent(this, MainActivityLocation::class.java)
            startActivity(intent)
        }
    }

}