package com.example.recyclervieweducacionit

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclervieweducacionit.databinding.ViewForProductsBinding

class RecyclerViewHolder (view: View) : RecyclerView.ViewHolder(view){

    private var binding = ViewForProductsBinding.bind(view)

    fun paintItem(product: Product, listener: RecyclerViewAdapter.RecyclerViewClickListener, position: Int, clickListenerDelete: (Int) -> Unit){
        with(binding){
            nameOfProduct.text = product.name
            descriptionOfProduct.text = product.description
            priceOfProduct.text = product.price

            //Picasso.get().load(product.imagen).into(imagenProducto)

            btnVerMas.setOnClickListener {

                listener.onDetailClick(product, position)

            }

            btnBorrarItem.setOnClickListener {
                clickListenerDelete(bindingAdapterPosition)
            }

        }

        //Picasso.get().load(product.imagen).into(binding.imagenProducto)

    }

}