package com.example.summerpractice22

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.summerpractice22.databinding.FragmentSearchBinding
import com.example.summerpractice22.information.FriendsAdapter
import com.example.summerpractice22.information.FriendsRepository
import com.google.android.material.snackbar.Snackbar

class SearchFragment: Fragment(R.layout.fragment_search) {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private var adapter: FriendsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind(view)

        val text = arguments?.getString(SearchFragment.ARG_TEXT).orEmpty()
        initAdapter()

        if (text.isNotEmpty()) {
            Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show()
        }

        with(binding){
            btnBack.setOnClickListener(){
                findNavController().navigateUp(
                )
            }
        }
    }

    private val friendsAdapter by lazy {
        FriendsAdapter(
            FriendsRepository.friends,
            Glide.with(this)
        ) {
            findNavController().navigate(
                R.id.action_searchFragment_to_informationFragment,
                InformationFragment.createBundle("${it.id}")
            )
        }
    }
    fun initAdapter(){
        binding.rvSearch.adapter = friendsAdapter
    }

    companion object {

        private const val ARG_TEXT = "ARG_TEXT"

    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}