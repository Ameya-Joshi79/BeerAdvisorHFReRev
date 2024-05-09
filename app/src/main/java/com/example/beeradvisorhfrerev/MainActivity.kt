package com.example.beeradvisorhfrerev

import android.os.Bundle
import android.util.Log
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

            //beerSuggestionsTextView.text = "Brand Color is ${selectedColor}"

            val beerSuggestionsList = getBeerList(selectedColor)

            val beerSuggestions = beerSuggestionsList.fold(""){ str, item ->
                if (str.isEmpty()) "$item" else "$str, $item"
            }

            Log.d("BEERADVISERAPP", beerSuggestions)

            beerSuggestionsTextView.text = beerSuggestions

            val beerSuggestionsUsingReduce = beerSuggestionsList.reduce{str, item ->
                str + '\n' + item
            }

            Log.d("BEERADVISERAPP", beerSuggestionsUsingReduce)

        }//Button.setOnClickListener


    }//onCreate


    fun getBeerList(selectedBeerColor:String):List<String>{

        return when(selectedBeerColor){

            "Light" -> listOf("Jail Pale Ale", "Lager Light")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
             else -> listOf("Gout Stout", "Dark Daniel")
        }//when

    }//getBeetList


}