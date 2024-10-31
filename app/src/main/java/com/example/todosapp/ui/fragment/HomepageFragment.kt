package com.example.todosapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todosapp.R
import com.example.todosapp.databinding.FragmentHomepageBinding
import com.example.todosapp.ui.adapter.TodosAdapter
import com.example.todosapp.ui.viewmodel.HomepageViewModel
import com.example.todosapp.util.passingToFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel: HomepageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container,false)
        binding.homepageFragment = this
        binding.homepageToolbarTitle = "Todos"

        viewModel.todosList.observe(viewLifecycleOwner) {
            val todosAdapter = TodosAdapter(requireContext(),it,viewModel)
            binding.todosAdapter = todosAdapter
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomepageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun clickFab(it:View) {
        Navigation.passingToFragment(it,R.id.passingRecord)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadTodos()
    }
}