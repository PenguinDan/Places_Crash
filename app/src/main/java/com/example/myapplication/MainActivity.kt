package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // NOT NECESSARY TO PLACE API-KEY since it will go to ON_FAIL, crashes regardless
        // if the api is valid or not
        Places.initialize(application, "API-KEY")
        val client = Places.createClient(application)

        val sessionToken = AutocompleteSessionToken.newInstance()
        client.findAutocompletePredictions(
                FindAutocompletePredictionsRequest.builder()
                        .setSessionToken(sessionToken)
                        .setTypeFilter(TypeFilter.CITIES)
                        .setQuery("")
                        .build()
        ).addOnSuccessListener {
            val two = 2
        }
    }
}