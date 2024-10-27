package com.example.fragmentpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fragmentpractice.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    private var binding: FragmentSecondBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)

        binding?.content?.text = arguments?.getString(ARG_DATA)

        binding?.confirmButton?.setOnClickListener { closeWithResult("Confirm") }
        binding?.rejectButton?.setOnClickListener { closeWithResult("Reject") }
    }

    private fun closeWithResult(data: String) {
        val resultRequestKey = arguments?.getString(RESULT_REQUEST_KEY).orEmpty()
        val resultDataKey = arguments?.getString(RESULT_DATA_KEY)
        val result = Bundle().apply { putString(resultDataKey, data) }

        parentFragmentManager.setFragmentResult(resultRequestKey, result)
        parentFragmentManager.popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val ARG_DATA = "arg_data"
        private const val RESULT_REQUEST_KEY = "result_request_key"
        private const val RESULT_DATA_KEY = "result_data_key"

        fun newInstance(data: String, resultRequestKey: String, resultDataKey: String): SecondFragment {
            return SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DATA, data)
                    putString(RESULT_REQUEST_KEY, resultRequestKey)
                    putString(RESULT_DATA_KEY, resultDataKey)
                }
            }
        }

    }
}