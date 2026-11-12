package com.example.lab4mobile.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lab4mobile.CityApplication
import com.example.lab4mobile.R
import com.example.lab4mobile.data.model.Place
import com.example.lab4mobile.databinding.FragmentPlaceDetailBinding
import com.example.lab4mobile.ui.CityViewModel
import com.example.lab4mobile.ui.CityViewModelFactory

/** Экран рекомендации. id места приходит аргументом Safe Args (placeId). */
class PlaceDetailFragment : Fragment() {

    private var _binding: FragmentPlaceDetailBinding? = null
    private val binding get() = _binding!!

    private val args: PlaceDetailFragmentArgs by navArgs()

    private val viewModel: CityViewModel by activityViewModels {
        CityViewModelFactory(requireActivity().application as CityApplication)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPlaceDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val place = viewModel.getPlace(args.placeId)
        if (place == null) {
            findNavController().navigateUp()
            return
        }
        showPlace(place)
        binding.favoriteButton.setOnClickListener { viewModel.toggleFavorite(place.id) }
        viewModel.favoriteIds.observe(viewLifecycleOwner) { ids -> showFavorite(place.id in ids) }
    }

    private fun showPlace(place: Place) {
        binding.placeImage.setImageResource(place.imageRes)
        binding.placeCategory.setText(viewModel.getCategory(place.categoryId).titleRes)
        binding.placeName.setText(place.nameRes)
        binding.placeAddress.setText(place.addressRes)
        binding.placeDescription.setText(place.descriptionRes)
    }

    private fun showFavorite(isFavorite: Boolean) {
        binding.favoriteButton.setText(
            if (isFavorite) R.string.action_remove_favorite else R.string.action_add_favorite
        )
        binding.favoriteButton.setIconResource(
            if (isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_border
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
