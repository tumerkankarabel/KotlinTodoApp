package com.example.todosapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todosapp.R
import com.example.todosapp.data.entity.Todos
import com.example.todosapp.databinding.CardDesignBinding
import com.example.todosapp.ui.fragment.HomepageFragmentDirections
import com.example.todosapp.ui.viewmodel.HomepageViewModel
import com.example.todosapp.util.passingToFragment
import com.google.android.material.snackbar.Snackbar

class TodosAdapter(var mContext: Context,var todosList:List<Todos>,var viewModel:HomepageViewModel)
    : RecyclerView.Adapter<TodosAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design:CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding:CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_design,parent,false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val todo = todosList.get(position)
        val d = holder.design

        d.todoObject = todo

        d.cardViewRow.setOnClickListener {
            val passing = HomepageFragmentDirections.passingDetail(todo = todo)
            Navigation.passingToFragment(it,passing)
        }

        d.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Should ${todo.name} be deleted?",Snackbar.LENGTH_SHORT)
                .setAction("YES"){
                    viewModel.delete(todo.id)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return todosList.size
    }
}