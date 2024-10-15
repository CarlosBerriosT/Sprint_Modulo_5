package com.example.tilla

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.tilla.databinding.FragmentListaZapatillaBinding

class FragListaZapatilla : Fragment(), Adapter.ZapatillaCallBack {

    private lateinit var binding: FragmentListaZapatillaBinding
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
    ): View {
        binding = FragmentListaZapatillaBinding.inflate(LayoutInflater.from(activity))
        initAdapter()
        return (binding.root)
    }

    private fun initAdapter() {
        val adapter = Adapter()
        val listaZapatilla = ZapatillaList.getZapatilla()
        adapter.setData(listaZapatilla)
        adapter.callback = this
        binding.RecyclerViewZapatilla.adapter = adapter
        binding.btnFloatCarrito.setOnClickListener {
            findNavController().navigate(R.id.action_fragListaZapatilla_to_fragCarritoCompras)
        }
    }

    companion object {
        const val ARG_PARAM1 = "param1"
        const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragListaZapatilla().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun showInforFragment(zapatilla: Zapatilla) {
        val bundle = Bundle()
        bundle.putString("nombre", zapatilla.nombre)
        bundle.putString("url", zapatilla.imgUrl)
        bundle.putString("precio", zapatilla.precio.toString())
        findNavController().navigate(R.id.action_FragListaZapatilla_to_fragVistaZapatilla, bundle)
    }
}
