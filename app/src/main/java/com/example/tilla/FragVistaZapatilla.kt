package com.example.tilla

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import coil.load
import com.example.tilla.databinding.FragmentVistaZapatillaBinding

class FragVistaZapatilla : Fragment() {

    private lateinit var binding: FragmentVistaZapatillaBinding
    private lateinit var mSharedPreferences: SharedPreferences
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null

    companion object {
        const val ARG_PARAM1 = "param1"
        const val ARG_PARAM2 = "param2"
        const val ARG_PARAM3 = "param3"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragVistaZapatilla().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("nombre")
            param2 = it.getString("url")
            param3 = it.getString("precio")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mSharedPreferences = requireActivity().applicationContext.getSharedPreferences("llave", Context.MODE_PRIVATE)
        binding = FragmentVistaZapatillaBinding.inflate(LayoutInflater.from(activity))
        initAdapter()
        binding.btnAgregar.setOnClickListener {
            mSharedPreferences.edit().putString(param1,param1).apply()
            Toast.makeText(context, "Agrego al Carro", Toast.LENGTH_SHORT).show()
        }

        return (binding.root)
    }

    private fun initAdapter() {
        binding.txtNombreVista.text = "$param1"
        binding.imageView.load(param2)
        binding.txtPrecioVista.text = "$ $param3"
    }
}
