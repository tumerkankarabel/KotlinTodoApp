package com.example.todosapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.passingToFragment(it:View, id:Int) {
    findNavController(it).navigate(id)
}

fun Navigation.passingToFragment(it:View, id:NavDirections) {
    findNavController(it).navigate(id)
}