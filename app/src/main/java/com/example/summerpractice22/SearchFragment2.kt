package com.example.summerpractice22

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice22.databinding.FragmentSearch2Binding
import com.google.android.material.snackbar.Snackbar

class SearchFragment2: Fragment(R.layout.fragment_search2) {
    private var _binding: FragmentSearch2Binding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearch2Binding.bind(view)

        val text = arguments?.getString(SearchFragment2.ARG_TEXT).orEmpty()

        if (text.isNotEmpty()) {
            Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show()
        }

        with(binding) {
            btnBack.setOnClickListener() {
                findNavController().popBackStack(
                )
            }
        }
    }
    companion object {

        private const val ARG_TEXT = "ARG_TEXT"

    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
