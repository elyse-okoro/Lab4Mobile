package com.example.lab4mobile.ui.categories

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
import com.example.lab4mobile.data.model.Category
import com.example.lab4mobile.databinding.FragmentListBinding
import com.example.lab4mobile.ui.CityViewModel
import com.example.lab4mobile.ui.CityViewModelFactory
import com.example.lab4mobile.ui.list.CategoryAdapter
import com.example.lab4mobile.ui.navigateFrom

class CategoriesFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CityViewModel by activityViewModels {
        CityViewModelFactory(requireActivity().application as CityApplication)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CategoryAdapter(
            placesCount = { category -> viewModel.getPlaces(category.id).size },
            onClick = { category -> openCategory(category) }
        )
        binding.list.layoutManager =
            GridLayoutManager(requireContext(), resources.getInteger(R.integer.list_span_count))
        binding.list.adapter = adapter
        adapter.submitList(viewModel.categories)
    }

    private fun openCategory(category: Category) {
        findNavController().navigateFrom(
            R.id.categoriesFragment,
            CategoriesFragmentDirections.actionCategoriesToPlaces(category.id, getString(category.titleRes))
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
