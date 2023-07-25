package com.example.zapatsrpint

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.zapatsrpint.databinding.FragmentCarritoBinding
import com.example.zapatsrpint.databinding.ItemBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CarritoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarritoFragment : Fragment() {

    private lateinit var mSharedPreferences: SharedPreferences
    private lateinit var gson: Gson
    private lateinit var binging: FragmentCarritoBinding
    private lateinit var bingingAdapter: ItemBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarritoBinding.inflate(layoutInflater)
        bindingAdapter = ItemBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        initListener()
        return (binding.root)

    }

    private fun initListener() {

        mSharedPreferences =requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        gson = Gson()
        var lista =getList()
        val adapter = Adapter()
        adapter.setData(lista)
        binding.recyclerViewCarro.adapter=adapter
        var valorTotal:Double = calcularValor(lista)
        binging.btnBorrarLista.setOnClickListener {
            mSharedPreferences.edit().clear().apply()
            Navigation.findNavController(requireView()).navigate(R.id.action_shoesFragment_to_detailFragment)
        }
        bingingAdapter.btnBorrarSeleccionado.setOnClickListener{
            valorTotal = calcularValor(lista)
        }
    }

    private fun calcularValor(lista:MutableList<zapato>): Double {
        var valorTotal:Double=0.0
        lista.forEach { data ->
            valorTotal += data.precio.toInt()
        }
        return valorTotal
    }

    fun getList(): MutableList<zapato> {
        val jsonString = mSharedPreferences.getString("mi lista", null)
        val listType = object : TypeToken<MutableList<zapato>>() {}.type
        return gson.fromJson(jsonString, listType) ?: mutableListOf()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CarritoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CarritoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}