package com.example.recyclervieweducacionit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.recyclervieweducacionit.databinding.FragmentProductsBinding

class ProductsFragment : Fragment(R.layout.fragment_products) {

    private lateinit var binding: FragmentProductsBinding

    private lateinit var adapter: RecyclerViewAdapter

    private var listProductFinal: MutableList<Product> = mutableListOf(
        Product("Harina","harina rica","$500","harina rica en carbohidratos"),
    Product("chocolates","chocolates ricos","$200","chocolates rica en carbohidratos"),
    Product("azucar","azucar rica","$300","azucar rica en carbohidratos"),
    Product("mani","mani rico","$800","mani rica en carbohidratos"),
    Product("Frutos Secos","frutos secos ricos","$600","frutos secos rica en carbohidratos"),
    Product("flan","flan rico","$1100","flan rica en carbohidratos"),
    Product("gaseosa","gaseosa rica","$900","gaseosa rica en carbohidratos"),
    Product("leche","leche rica","$200","leche rica en carbohidratos"),
    Product("yerba","yerba buena","$500","yerba rica en carbohidratos"),
    Product("queso","queso rico","$600","queso rica en carbohidratos"),
    Product("jugo","jugo rico","$300","jugo rica en carbohidratos"),
    Product("jabon","jabon rica","$700","jabon rica en carbohidratos"),
    Product("servilletas","servilletas ricas","$8500","servilletas rica en carbohidratos"))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProductsBinding.bind(view)

        setupRV()

        filterByProductName()

    }

    private fun filterByProductName() {
        binding.etSearch.addTextChangedListener { name ->
            val newList = mutableListOf<Product>()

            if (!name.isNullOrBlank()){
                listProductFinal.forEach {
                    if (it.name.lowercase().contains(name.toString().lowercase())){
                        newList.add(it)
                    }
                }
                binding.rvProducts.adapter = RecyclerViewAdapter(newList, object : RecyclerViewAdapter.RecyclerViewClickListener{
                    override fun onDetailClick(product: Product, position: Int) {
                        val showMoreInfo = MoreInfoProductFragment.newInstance(product,position)
                        showMoreInfo.show(childFragmentManager, "the bottom sheet is showing")
                    }
                },clickListenerDelete = { position -> deleteItem(position)})

                if (newList.isEmpty()){
                    binding.tvNoInfo.text = "No se encotraron productos con ese nombre"
                } else {
                    binding.tvNoInfo.text = ""
                }

            } else{
                binding.rvProducts.adapter = RecyclerViewAdapter(listProductFinal, object : RecyclerViewAdapter.RecyclerViewClickListener{
                    override fun onDetailClick(product: Product, position: Int) {
                        val showMoreInfo = MoreInfoProductFragment.newInstance(product,position)
                        showMoreInfo.show(childFragmentManager, "the bottom sheet is showing")
                    }

                }, clickListenerDelete = { position -> deleteItem(position)
                    adapter.notifyDataSetChanged()})
                binding.tvNoInfo.text= ""
            }
        }
    }

    private fun setupRV() {
        adapter = RecyclerViewAdapter(listProductFinal, object : RecyclerViewAdapter.RecyclerViewClickListener{
            override fun onDetailClick(product: Product, position: Int) {
                val showMoreInfo = MoreInfoProductFragment.newInstance(product,position)
                showMoreInfo.show(childFragmentManager, "the bottom sheet is showing")
            }

        }, clickListenerDelete = { position -> deleteItem(position)
            adapter.notifyDataSetChanged()
        })


        binding.rvProducts.adapter = adapter
    }



    private fun deleteItem(position: Int) {
        listProductFinal.removeAt(position)
        binding.rvProducts.adapter = RecyclerViewAdapter(listProductFinal, object : RecyclerViewAdapter.RecyclerViewClickListener{
            override fun onDetailClick(product: Product, position: Int) {
                val showMoreInfo = MoreInfoProductFragment.newInstance(product,position)
                showMoreInfo.show(childFragmentManager, "the bottom sheet is showing")
            }

        }, clickListenerDelete = { position -> deleteItem(position)
        })

    }

    companion object{
        val list1 = listOf(
            Product("Harina","harina rica","$500","harina rica en carbohidratos"),
            Product("chocolates","chocolates ricos","$200","chocolates rica en carbohidratos"),
            Product("azucar","azucar rica","$300","azucar rica en carbohidratos"),
            Product("mani","mani rico","$800","mani rica en carbohidratos"),
            Product("Frutos Secos","frutos secos ricos","$600","frutos secos rica en carbohidratos"),
            Product("flan","flan rico","$1100","flan rica en carbohidratos"),
            Product("gaseosa","gaseosa rica","$900","gaseosa rica en carbohidratos"),
            Product("leche","leche rica","$200","leche rica en carbohidratos"),
            Product("yerba","yerba buena","$500","yerba rica en carbohidratos"),
            Product("queso","queso rico","$600","queso rica en carbohidratos"),
            Product("jugo","jugo rico","$300","jugo rica en carbohidratos"),
            Product("jabon","jabon rica","$700","jabon rica en carbohidratos"),
            Product("servilletas","servilletas ricas","$8500","servilletas rica en carbohidratos")
        )
    }

}