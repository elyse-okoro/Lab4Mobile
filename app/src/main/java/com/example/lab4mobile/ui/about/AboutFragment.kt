package com.example.lab4mobile.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab4mobile.BuildConfig
import com.example.lab4mobile.R
import com.example.lab4mobile.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.aboutVersion.text = getString(R.string.about_version, BuildConfig.VERSION_NAME)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
