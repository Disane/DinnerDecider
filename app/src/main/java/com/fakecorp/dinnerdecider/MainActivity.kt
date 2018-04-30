package com.fakecorp.dinnerdecider

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity()
{
    private val TAG = MainActivity::class.java.name
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

        callAlertDialog()
    }

    private fun callAlertDialog()
    {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setPositiveButton("Ok!", DialogInterface.OnClickListener{ _, _ ->
            Log.d(TAG, "You clicked Ok!")
            val dialog: AlertDialog = builder.create()
            dialog.setTitle("Advertisement!")
            val message = TextView(this)
            message.textSize = 21f
            val s = SpannableString("This is an advertisement! Please visit: google.com")
            Linkify.addLinks(s, Linkify.WEB_URLS)
            message.text = s
            message.movementMethod = LinkMovementMethod.getInstance()
            dialog.setView(message)
            dialog.show()
        })
        val dialog: AlertDialog = builder.create()
        dialog.setTitle("Test AlertDialog!")
        val message = TextView(this)
        message.textSize = 21f
        val s = SpannableString("This is an Alert Dialog! Please visit: google.com")
        Linkify.addLinks(s, Linkify.WEB_URLS)
        message.text = s
        message.movementMethod = LinkMovementMethod.getInstance()
        dialog.setView(message)
        dialog.show()
    }
}
