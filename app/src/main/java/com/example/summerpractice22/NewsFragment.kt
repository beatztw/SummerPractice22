package com.example.summerpractice22

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice22.databinding.FragmentNewsBinding

class NewsFragment: Fragment(R.layout.fragment_news) {
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewsBinding.bind(view)
        with(binding){
            btnSearch.setOnClickListener(){
                val bundle = Bundle()
                bundle.putString("ARG_TEXT","News to SearchNews")
                findNavController().navigate(
                    R.id.action_newsFragment_to_searchFragment,
                    bundle
                )
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}