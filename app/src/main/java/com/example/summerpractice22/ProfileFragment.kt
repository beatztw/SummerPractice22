package com.example.summerpractice22


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice22.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)
        with(binding){
            btnSearch.setOnClickListener(){
                val bundle = Bundle()
                bundle.putString("ARG_TEXT","Profile to SearchProfile")
                findNavController().navigate(
                    R.id.action_profileFragment_to_searchFragment,
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
