package com.example.final_project

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_discounts.*

class MainActivityDiscounts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_discounts)


        rvDiscountsList.layoutManager = LinearLayoutManager(this)
        rvDiscountsList.adapter = DiscountsAdapter(getTour(), this)


        swLangDiscount.setOnClickListener {
            if (swLangDiscount.isChecked) {
                rvDiscountsList.adapter = DiscountsAdapter(getTourUkr(), this)
                swLangDiscount.setText("АНГЛ")
                tvLangDiscount.setText("УКР")

            }
            else {
                rvDiscountsList.adapter = DiscountsAdapter(getTour(), this)
                swLangDiscount.setText("ENG")
                tvLangDiscount.setText("UKR")
            }
        }



    }

    private fun getTour(): ArrayList<Discounts> {
        val listOfTours = ArrayList<Discounts>()
        listOfTours.add(Discounts(
            "Ibiza & Beyond | 20% Off",
            "$ 1620",
            "9 Days Tour: Can't decide where to visit in Spain? Visit the all the top destinations as you make your way from Barcelona to Ibiza and ending up in Madrid",
            BitmapFactory.decodeResource(resources, R.drawable.ibiza)

        ))
        listOfTours.add(Discounts(
            "Bali: Hike, Bike and Raft | 15% Off",
            "$ 1850",
            "12 Days Tour: This tour is perfect for active travelers with a mix of adventurous activities from snorkeling and hiking to whitewater rafting",
            BitmapFactory.decodeResource(resources, R.drawable.bali)

        ))
        listOfTours.add(Discounts(
            "Iceland | 30% Off",
            "$ 980",
            "4 Days Tour: Bathe in the Blue Lagoon, explore Reykjavik and search out the Northern Lights during this 4 days adventure in Iceland",
            BitmapFactory.decodeResource(resources, R.drawable.iceland)

        ))
        listOfTours.add(Discounts(
            "Norwegian Fjords | 10% Off",
            "$ 2200",
            "13 Days Tour: Go deeper into the otherworldly fjords of Norway. Discover wonderous UNESCO World Heritage Sites like the Standing Stones of Stennes and the mystical Ring of Brodgar",
            BitmapFactory.decodeResource(resources, R.drawable.norway)

        ))
        listOfTours.add(Discounts(
            "Sailing Croatia (Dubrovnik) | 25% Off",
            "$ 1169",
            "8 Days Tour: Whether you're looking for relaxed afternoons lazing on the deck of a yacht, this Croatian cruise aims to please. Embark in lovely Dubrovnik and discover charming villages",
            BitmapFactory.decodeResource(resources, R.drawable.croatia)

        ))
        listOfTours.add(Discounts(
            "Ukrainian mountains views | 10% Off",
            "$ 260",
            "2 Days Tour: Trip to the mountain Roketa (1106 m) through Yaremche to the montain Makovytsya including visiting of Hutsulian mountain valley",
            BitmapFactory.decodeResource(resources, R.drawable.ukraine)

        ))
        listOfTours.add(Discounts(
            "Explore snow Lapland | 18% Off",
            "$ 3500",
            "7 Days Tour: Lapland, home of the Indigenous Sami people, is a magical place of pristine Arctic landscapes and snow-dusted woodlands",
            BitmapFactory.decodeResource(resources, R.drawable.finland)

        ))

        return listOfTours
    }

    private fun getTourUkr(): ArrayList<Discounts> {

        val listOfToursUkr = ArrayList<Discounts>()
        listOfToursUkr.add(Discounts(
            "Ібіца і Не Тільки | - 20% ",
            "$ 1620",
            "9-денний тур: не можете вирішити, де побувати в Іспанії? Відвідайте всі найпопулярніші напрямки, від Барселони і до Ібіци. Кінцева зупинка - Мадрид",
            BitmapFactory.decodeResource(resources, R.drawable.ibiza)

        ))
        listOfToursUkr.add(Discounts(
            "Балі: велотур і рафтинг | - 15% ",
            "$ 1850",
            "12-денний тур: цей тур ідеально підходить для активних мандрівників. Мікс пригод: від підводного плавання та піших прогулянок до рафтингу",
            BitmapFactory.decodeResource(resources, R.drawable.bali)

        ))
        listOfToursUkr.add(Discounts(
            "Ісландія | - 30% ",
            "$ 980",
            "4-денний тур: ванни в Блакитній лагуні, дослідження Рейк'явіку та північного сяйва",
            BitmapFactory.decodeResource(resources, R.drawable.iceland)

        ))
        listOfToursUkr.add(Discounts(
            "Норвезькі фіорди | - 10% ",
            "$ 2200",
            "13-денний тур: відкрийте для себе чудові об’єкти всесвітньої спадщини ЮНЕСКО - Камені Стеннеса, містичне кільце Бродгара та ін",
            BitmapFactory.decodeResource(resources, R.drawable.norway)

        ))
        listOfToursUkr.add(Discounts(
            "Круїз до Хорватії | - 25% ",
            "$ 1169",
            "8-денний тур: хорватський круїз - саме задоволення. Вирушайте в чудовий Дубровник і відкрийте для себе чарівну Хорватію",
            BitmapFactory.decodeResource(resources, R.drawable.croatia)

        ))
        listOfToursUkr.add(Discounts(
            "Українські гірські краєвиди | - 10% ",
            "$ 260",
            "2-денний тур: поїздка на гору Рокета (1106 м) через Яремче на гору Маковиця з відвідуванням Гуцульської долини",
            BitmapFactory.decodeResource(resources, R.drawable.ukraine)

        ))
        listOfToursUkr.add(Discounts(
            "Cнігова Лапландія | - 18% ",
            "$ 3500",
            "7-денний тур: Лапландія, батьківщина корінного народу саамі, є чарівним місцем незайманих арктичних ландшафтів і засніжених лісів",
            BitmapFactory.decodeResource(resources, R.drawable.finland)

        ))

        return listOfToursUkr
    }




}