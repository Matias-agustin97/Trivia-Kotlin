package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //inflater, which is the LayoutInflater used to inflate the binding layout.Make xml into ui
        //The XML layout resource of the layout to inflate. the xml elemants
        //container for the parent ViewGroup. (This parameter is optional.)
        //false for the attachToParent value.
        //Assign the binding that DataBindingUtil.inflate returns to the binding variable.
        //Return binding.root from the method, which contains the inflated view.
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,R.layout.fragment_title,container,false)

        binding.playButton.setOnClickListener{view : View ->
            //Estamos diciendo, que esta view, en este caso playbutton, cuando se haga click que encuentre el navControoler y navege al fragmento de juego
            //Fijate el id, cuando arrastramos un fragmento a otro creamos una accion y esta accion tiene un id entre cosas
            //pasale ese id al navController y de ahi es historia papu (?
            //view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
            //The only real use is for passing args safely between fragments
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())

        }

        //This fragment has an options menu
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    //Override the onOptionsItemSelected() method to take the appropriate action when the menu item is tapped.
    // In this case, the action is to navigate to the Fragment that has the same id as the selected menu item.

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}