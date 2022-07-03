package com.example.summerpractice22

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.summerpractice22.databinding.FragmentInformationBinding
import com.example.summerpractice22.information.FriendsRepository

class InformationFragment: Fragment(R.layout.fragment_information) {
    private var _binding: FragmentInformationBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentInformationBinding.bind(view)

        val id = arguments?.getString(ARG_TEXT)?.toInt()

        val text = arguments?.getString(InformationFragment.ARG_TEXT).orEmpty()
        val friend = FriendsRepository.friends.find { it.id == id }
        binding.tvName.text =  friend?.name
        binding.tvNickname.text =  friend?.nickname
        binding.tvDate.text =  friend?.date
        binding.tvAge.text = friend?.age.toString()
        binding.tvCountry.text =  friend?.country
        binding.tvCity.text =  friend?.city

        Glide.with(this)
            .load(friend?.url)
            .into(binding.ivAvatar)


        with(binding) {
            btnBack.setOnClickListener() {
                findNavController().popBackStack(
                )
            }
        }
    }
    companion object {

        private const val ARG_TEXT = "ARG_TEXT"

        fun createBundle(text: String): Bundle {

            val bundle = Bundle()
            bundle.putString(
                InformationFragment.ARG_TEXT,
                text
            )
            return bundle
        }

    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}