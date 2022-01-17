package com.example.final_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_drum.*

class MainActivityDrum : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_drum)


        ivWinDiscount.visibility = View.GONE
        tvWinDiscount.visibility = View.GONE



        btDrum.setOnClickListener {
            ivDrum.setImageResource(R.drawable.pole)

            val timer = object: CountDownTimer(7000, 1000) {
                override fun onTick(millisUntilFinished: Long) {

                }

                override fun onFinish() {
                    two()
                }
            }
            timer.start()
        }


        swLangDrum.setOnClickListener {
            if (swLangDrum.isChecked) {

                tvComment.setText("*відправ фото знижки на нашу імейл адресу")
                swLangDrum.setText("АНГЛ")
                tvLangDrum.setText("УКР")
                tvStartDrum.setText("Старт")

            } else {
                tvComment.setText("* send photo of discount to our email address")
                swLangDrum.setText("ENG")
                tvLangDrum.setText("UKR")
                tvStartDrum.setText("Start")

            }

        }


       }



    @SuppressLint("SetTextI18n")
    fun two() {
        btDrum.visibility = View.GONE
        tvStartDrum.visibility = View.GONE
        ivDrum.visibility = View.GONE

        ivWinDiscount.visibility = View.VISIBLE
        tvWinDiscount.visibility = View.VISIBLE

        var discount = (3..15).random()
        tvWinDiscount.text = discount.toString() + " %"
    }



}




