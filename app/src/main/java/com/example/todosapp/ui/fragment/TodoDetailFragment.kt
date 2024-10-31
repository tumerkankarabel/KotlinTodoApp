package com.example.todosapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todosapp.R
import com.example.todosapp.databinding.FragmentToDoDetailBinding
import com.example.todosapp.ui.viewmodel.TodoDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoDetailFragment : Fragment() {
    private lateinit var binding:FragmentToDoDetailBinding
    private lateinit var viewModel: TodoDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do_detail, container,false)
        binding.toDoDetailFragment = this
        binding.todoDetailToolbarTitle = "To Do Detail"

        val bundle:TodoDetailFragmentArgs by navArgs()
        val comingTodo = bundle.todo
        binding.todoObject = comingTodo

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TodoDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun updateButton(id:Int,name:String){
        viewModel.update(id,name)
    }
}