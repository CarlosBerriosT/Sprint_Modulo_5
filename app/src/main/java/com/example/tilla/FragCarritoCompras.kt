package com.example.tilla

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tilla.databinding.FragmentCarritoComprasBinding

class FragCarritoCompras : Fragment() {

    private lateinit var mSharedPreferences: SharedPreferences
    private lateinit var binding: FragmentCarritoComprasBinding

    private var param1: String? = null
    private var param2: String? = null


    companion object {
        const val ARG_PARAM1 = "param1"
        const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragCarritoCompras().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

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
        binding = FragmentCarritoComprasBinding.inflate(inflater, container, false)
        mSharedPreferences = requireActivity().applicationContext.getSharedPreferences("llave", Context.MODE_PRIVATE)
        initAdapterCarrito()

        return binding.root
    }

    private fun initAdapterCarrito() {
        val adapter = AdapterCarrito()
        val listaZapatilla = listaCarrito()
        adapter.setData(listaZapatilla)

        binding.RecycleCarrito.adapter = adapter
    }

    private fun listaCarrito(): MutableList<Zapatilla> {
        val zapatilla = ZapatillaList.getZapatilla()
        val carro = mutableListOf<Zapatilla>()
        val nombre = mSharedPreferences.all

        for (z in zapatilla) {
            if (nombre.containsKey(z.nombre)) carro.add(z)
        }

        return carro
    }
}
