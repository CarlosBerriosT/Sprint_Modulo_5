package com.example.tilla

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tilla.databinding.ItemCarritoBinding
import com.example.tilla.databinding.ItemLayoutBinding
import kotlin.coroutines.coroutineContext

class AdapterCarrito: RecyclerView.Adapter <AdapterCarrito.ViewHolder>() {

    var zapatillaCarro = mutableListOf<Zapatilla>()
    private lateinit var mSharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCarritoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        mSharedPreferences = parent.context.getSharedPreferences("llave", Context.MODE_PRIVATE)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return zapatillaCarro.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = zapatillaCarro[position]
        holder.bind(item)
    }


    fun setData(zapatillaList: MutableList<Zapatilla>){
        this.zapatillaCarro = zapatillaList.toMutableList()
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        zapatillaCarro.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(val binding: ItemCarritoBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(zapatilla: Zapatilla){
            binding.txtNombreCarrito.text = zapatilla.nombre
            binding.txtPrecioCarrito.text = "$ " + zapatilla.precio.toString()
            binding.imgCarrito.load(zapatilla.imgUrl)
            binding.imgDelete.setOnClickListener {
                val position = adapterPosition
                val itemRemove = zapatillaCarro[position]
                mSharedPreferences.edit().remove(itemRemove.nombre).apply()
                removeItem(position)
                Toast.makeText(binding.root.context,"Eliminado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}