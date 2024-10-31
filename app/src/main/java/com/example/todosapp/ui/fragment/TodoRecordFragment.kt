package com.example.todosapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.todosapp.R
import com.example.todosapp.databinding.FragmentToDoRecordBinding
import com.example.todosapp.ui.viewmodel.TodoRecordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoRecordFragment : Fragment() {
    private lateinit var binding: FragmentToDoRecordBinding
    private lateinit var viewModel: TodoRecordViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do_record, container,false)
        binding.toDoRecordFragment = this
        binding.todoRecordToolbarTitle = "To Do Record"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TodoRecordViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun registerButton(name:String){
        viewModel.register(name)
    }
}