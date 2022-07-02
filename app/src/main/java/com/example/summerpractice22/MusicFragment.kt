package com.example.summerpractice22

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice22.databinding.FragmentMusicBinding

class MusicFragment : Fragment(R.layout.fragment_music) {
    private var _binding: FragmentMusicBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMusicBinding.bind(view)

        with(binding){
            btnSearch.setOnClickListener(){
                val bundle = Bundle()
                bundle.putString("ARG_TEXT","Music to SearchMusic")
                findNavController().navigate(
                    R.id.action_musicFragment_to_searchFragment,
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