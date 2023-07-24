package com.example.zapatsrpint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zapatsrpint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initAdapter()

    }

    private fun initAdapter() {
        val adapter = Adapter()
        val zapatilla = Zapatilla.getZapatilla()
        adapter.setData(zapatilla)
        binding.RecyclerView.adapter = adapter
    }
}