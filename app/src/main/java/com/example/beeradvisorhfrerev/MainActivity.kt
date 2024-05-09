package com.example.beeradvisorhfrerev

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.beeradvisorhfrerev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val findBeerButton = findViewById<Button>(R.id.find_beers)

        val beerSpinner = findViewById<Spinner>(R.id.beer_color)

        val beerSuggestionsTextView = findViewById<TextView>(R.id.brands)

        findBeerButton.setOnClickListener {

            val selectedColor = beerSpinner.selectedItem.toString()

            beerSuggestionsTextView.text = "Brand Color is ${selectedColor}"

        }//Button.setOnClickListener


    }//onCreate


}