package com.example.zapatsrpint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.zapatsrpint.databinding.ItemBinding


private fun RecyclerView.ViewHolder.bind(item: Zapato) {

}

class Adapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var zapatos = mutableListOf<Zapato>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding= ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder (binding)
    }

    override fun getItemCount(): Int {
        return zapatos.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = zapatos[position]
        holder.bind(item)
    }
    fun setData(listazapatos: List<zapato>){
        zapatos = listazapatos.toMutableList()
    }
    inner class ViewHolder ( val binding: ItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:zapato){
            binding.txtNombreItem.text =item.nombre
            binding.txtPrecioItem.text = item.precio.toString()
            binding.imgzapatoItem.load(item.url)



                notifyDataSetChanged()

                binding.txtNombre.text = item.nombre
                binding.txtPrecio.text = item.precio.toString()
                binding.imgZapato.load(item.url)
                val bundle = Bundle()
                bundle.putString("nombre",item.nombre)
                bundle.putString("precio", item.precio.toString())
                bundle.putString("url",item.url)
                binding.cardview.setOnClickListener({
                    Navigation.findNavController(binding.root).navigate(R.id.action_carritoFragment_to_detailFragment,bundle)
                })
        }
    }








}