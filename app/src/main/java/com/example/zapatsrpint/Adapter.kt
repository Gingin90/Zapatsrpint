package com.example.zapatsrpint

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zapatsrpint.databinding.ItemBinding




class Adapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var zapatilla= mutableListOf<Zapatilla>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding= ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder (binding)
    }

    override fun getItemCount(): Int {
        return zapatilla.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = zapatilla[position]
        holder.bind(item)

    }
    fun setData(zapatilla: List<Zapatilla>) {
        this.zapatilla = zapatilla.toMutableList()
    }

    class ViewHolder( val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    fun bind(zapatilla: Zapatilla()

            binding.tvNombre.text= zapatilla.nombre
            binding.tvPrecio.text= precio.tipo
            binding.imageViewZap.load(zapatilla.imgUrl)



        }