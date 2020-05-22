package com.parzival48.fakechef.ui.ingredientmenu

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.parzival48.fakechef.R

class IngredientMenuFragment : Fragment() {

    companion object {
        fun newInstance() = IngredientMenuFragment()
    }

    private lateinit var viewModel: IngredientMenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ingredient_menu_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(IngredientMenuViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
