package com.example.fragmentpractice

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmentpractice.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private var binding: FragmentFirstBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        binding?.navigateButton?.setOnClickListener { navigate() }

        parentFragmentManager.setFragmentResultListener(RESULT_REQUEST_KEY, this) { key, bundle ->
            handleResult(bundle)
        }

    }

    private fun handleResult(bundle: Bundle) {
        val data = bundle.getString(RESULT_DATA_KEY)
        Toast.makeText(requireContext(), data, Toast.LENGTH_SHORT).show()
    }

    private fun navigate() {
        val data = binding?.field?.text.toString()

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, SecondFragment.newInstance(data, RESULT_REQUEST_KEY, RESULT_DATA_KEY))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val RESULT_REQUEST_KEY = "result_request_key"
        private const val RESULT_DATA_KEY = "result_data_key"

    }
}