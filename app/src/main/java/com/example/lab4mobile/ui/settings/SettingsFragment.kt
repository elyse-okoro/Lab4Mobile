package com.example.lab4mobile.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.lab4mobile.CityApplication
import com.example.lab4mobile.R
import com.example.lab4mobile.data.model.ThemeMode
import com.example.lab4mobile.databinding.FragmentSettingsBinding
import com.example.lab4mobile.ui.CityViewModel
import com.example.lab4mobile.ui.CityViewModelFactory
import com.example.lab4mobile.ui.toNightMode

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CityViewModel by activityViewModels {
        CityViewModelFactory(requireActivity().application as CityApplication)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.themeMode.observe(viewLifecycleOwner) { mode ->
            binding.themeGroup.check(buttonFor(mode))
        }
        binding.themeGroup.setOnCheckedChangeListener { _, checkedId ->
            val mode = modeFor(checkedId) ?: return@setOnCheckedChangeListener
            if (mode != viewModel.themeMode.value) {
                viewModel.setThemeMode(mode)
                AppCompatDelegate.setDefaultNightMode(mode.toNightMode())
            }
        }
    }

    private fun buttonFor(mode: ThemeMode): Int = when (mode) {
        ThemeMode.SYSTEM -> R.id.theme_system
        ThemeMode.LIGHT -> R.id.theme_light
        ThemeMode.DARK -> R.id.theme_dark
    }

    private fun modeFor(buttonId: Int): ThemeMode? = when (buttonId) {
        R.id.theme_system -> ThemeMode.SYSTEM
        R.id.theme_light -> ThemeMode.LIGHT
        R.id.theme_dark -> ThemeMode.DARK
        else -> null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
