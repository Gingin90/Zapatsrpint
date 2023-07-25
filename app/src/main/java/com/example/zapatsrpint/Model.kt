package com.example.zapatsrpint

import android.content.SharedPreferences

class Model {

        private lateinit var zapatos:MutableList<zapato>
        private lateinit var mSharedPreferences: SharedPreferences
        fun guardarData (zapato: zapato):MutableList<zapato>{
            zapatos.add(zapato)
            return zapatos
        }
}