package com.example.recyclervieweducacionit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclervieweducacionit.databinding.FragmentMoreInfoProductBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MoreInfoProductFragment (private val item: Product, private val position: Int) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentMoreInfoProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMoreInfoProductBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.moreInfo.text = item.descriptionExtended

    }

    companion object {

        @JvmStatic
        fun newInstance(item: Product, position: Int)=
            MoreInfoProductFragment(item, position)
    }

}