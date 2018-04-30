package com.fakecorp.dinnerdecider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity()
{
    private val foodList = arrayListOf("Chinese", "Hamburger", "Pizza", "McDonalds", "Vapiano")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideBtn.setOnClickListener{ _ ->
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            selectedFoodTxt.text = foodList[randomFood]
        }

        addFoodBtn.setOnClickListener{ _ ->
            val newFood = addFoodTxt.text.toString()
            if(newFood.isNotEmpty())
            {
                foodList.add(newFood)
                addFoodTxt.text.clear()
                println(foodList)
            }
        }
    }
}
