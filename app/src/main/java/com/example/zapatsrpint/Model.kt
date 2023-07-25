package com.example.zapatsrpint

import android.content.SharedPreferences

class Model {

        private lateinit var zapatos:MutableList<Zapatio>
        private lateinit var mSharedPreferences: SharedPreferences
        fun guardarData (zapato: Zapatio):MutableList<Zapatio>{
            zapatos.add(zapato)
            return zapatos
        }
}