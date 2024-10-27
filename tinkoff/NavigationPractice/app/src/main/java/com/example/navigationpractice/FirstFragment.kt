package com.example.navigationpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationpractice.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {

    private var binding: FragmentFirstBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        binding?.navigateButton?.setOnClickListener {
            findNavController().navigate(FirstFragmentDirections.actionFirstToSecond())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
