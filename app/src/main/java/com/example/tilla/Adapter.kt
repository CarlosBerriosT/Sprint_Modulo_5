package com.example.tilla

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.tilla.databinding.ItemLayoutBinding
import coil.load
class Adapter : RecyclerView.Adapter <Adapter.ViewHolder>() {

    var zapatilla = mutableListOf<Zapatilla>()
    var callback : ZapatillaCallBack? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return zapatilla.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = zapatilla[position]
        holder.bind(item)
    }

    fun setData(zapatillaList: List<Zapatilla>){
        this.zapatilla = zapatillaList.toMutableList()
    }

    inner class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(zapatilla: Zapatilla){
            binding.txtNombre.text = zapatilla.nombre
            binding.txtPrecio.text = "$ " + zapatilla.precio.toString()
            binding.imgZapatos.load(zapatilla.imgUrl)
            binding.CardCanastaZapatos.setOnClickListener{
                callback?.showInforFragment(zapatilla)
                val applicationContext = this
            }

        }
    }

    interface ZapatillaCallBack {
        fun showInforFragment(zapatilla: Zapatilla)
    }
}