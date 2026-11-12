package com.example.lab4mobile.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lab4mobile.CityApplication
import com.example.lab4mobile.R
import com.example.lab4mobile.data.model.Place
import com.example.lab4mobile.databinding.FragmentHomeBinding
import com.example.lab4mobile.ui.CityViewModel
import com.example.lab4mobile.ui.CityViewModelFactory
import com.example.lab4mobile.ui.list.PlaceAdapter

/** Главный экран: коротко о городе и по одному месту из каждой категории. */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CityViewModel by activityViewModels {
        CityViewModelFactory(requireActivity().application as CityApplication)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PlaceAdapter { place -> openPlace(place) }
        binding.featuredList.layoutManager =
            GridLayoutManager(requireContext(), resources.getInteger(R.integer.list_span_count))
        binding.featuredList.adapter = adapter
        adapter.submitList(viewModel.featuredPlaces)
    }

    private fun openPlace(place: Place) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeToPlaceDetail(place.id, getString(place.nameRes))
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
