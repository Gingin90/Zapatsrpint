package com.example.zapatsrpint

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.zapatsrpint.databinding.ItemcarritoBinding

class AdapterCarrito: RecyclerView.Adapter <AdapterCarrito.ViewHolder>() {
    var zapatos = mutableListOf<Zapatio>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCarrito.ViewHolder {

        var binding =ItemcarritoBinding.inflate(LayoutInflater.from(parent.context),parent , false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = zapatos[position]
        holder.bind(item)
    }


    override fun getItemCount(): Int {
        return zapatos.size
    }

    fun setData(listazapatos: List<Zapatio>){
        zapatos = listazapatos.toMutableList()
    }
    inner class ViewHolder ( val binding: ItemcarritoBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item:Zapatio){

            binding.txtNombreItem.text=item.nombre
            binding.txtPrecioItem.text = item.precio.toString()
            binding.imgzapatoItem.load(item.url)

            binding.btnBorrarSeleccionado.setOnClickListener {
                zapatos.remove(item)

                notifyDataSetChanged()

                Navigation.findNavController(binding.root).navigate(R.id.action_carritoFragment_to_detailFragment)
            }

        }


    }




}









