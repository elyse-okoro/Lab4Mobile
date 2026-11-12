package com.example.lab4mobile.ui.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lab4mobile.CityApplication
import com.example.lab4mobile.R
import com.example.lab4mobile.data.model.Place
import com.example.lab4mobile.databinding.FragmentListBinding
import com.example.lab4mobile.ui.CityViewModel
import com.example.lab4mobile.ui.CityViewModelFactory
import com.example.lab4mobile.ui.list.PlaceAdapter
import com.example.lab4mobile.ui.navigateFrom

/** Места одной категории. Категория приходит аргументом Safe Args (categoryId). */
class PlacesFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val args: PlacesFragmentArgs by navArgs()

    private val viewModel: CityViewModel by activityViewModels {
        CityViewModelFactory(requireActivity().application as CityApplication)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PlaceAdapter { place -> openPlace(place) }
        binding.list.layoutManager =
            GridLayoutManager(requireContext(), resources.getInteger(R.integer.list_span_count))
        binding.list.adapter = adapter
        adapter.submitList(viewModel.getPlaces(args.categoryId))
    }

    private fun openPlace(place: Place) {
        findNavController().navigateFrom(
            R.id.placesFragment,
            PlacesFragmentDirections.actionPlacesToPlaceDetail(place.id, getString(place.nameRes))
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
