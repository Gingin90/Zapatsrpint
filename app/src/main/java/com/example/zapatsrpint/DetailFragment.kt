package com.example.zapatsrpint

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import coil.load
import com.example.zapatsrpint.databinding.FragmentDetailBinding
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "nombre"
private const val ARG_PARAM2 = "precio"
private const val ARG_PARAM3 = "url"

/**
 * A simple [Fragment] subclass.
 * Use the [detalle.newInstance] factory method to
 * create an instance of this fragment.
 */
 class DetailFragment: Fragment(),IviewPresenter {
    private lateinit var binding:FragmentDetailBinding
    private lateinit var mSharedPreferences:SharedPreferences
    private lateinit var gson: Gson
    private lateinit var  zapatoslista: MutableList<Zapatio>
    val bundle = Bundle()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater)
        initListener()
        return binding.root
    }

    private fun initListener() {

        binding.imgzap.load(param3)
        binding.txtName.text =param1
        binding.txtAmount.text = "$$param2"
        mSharedPreferences =requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        gson = Gson()

        zapatoslista = getList()
        binding.imgzap.setOnClickListener {
            binding.btVolver.setOnClickListener {

            }
            Navigation.findNavController(requireView()).navigate(R.id.action_detailFragment_to_carritoFragment,bundle)
        }

        SaveData()

    }


    private fun SaveData() {
        val preferences = this.requireActivity().getSharedPreferences("pref", MODE_PRIVATE)
        binding.btnComprar.setOnClickListener{

            var nombre= param1.toString()
            var precio = param2.toString().toDouble()
            var img = param3.toString()
            val zp = Zapatio(nombre,img,precio)


            zapatoslista.add(zp)

            guardarData(zapatoslista)


            mSharedPreferences =requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
            gson = Gson()

            val jsonString = gson.toJson(zapatoslista)
            mSharedPreferences.edit().putString("mi lista", jsonString).apply()

            Toast.makeText(requireContext(), "Añadido al carro", Toast.LENGTH_SHORT).show()

        }
    }
    fun getList(): MutableList<Zapatio> {
        val jsonString = mSharedPreferences.getString("mi lista", null)
        val listType = object : TypeToken <MutableList<Zapatio>>() {}.type
        return gson.fromJson(jsonString, listType) ?: mutableListOf()
    }



    companion object {


        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment detalle.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun guardarData(data: MutableList<Zapatio>) {
        zapatoslista = data
    }


}






