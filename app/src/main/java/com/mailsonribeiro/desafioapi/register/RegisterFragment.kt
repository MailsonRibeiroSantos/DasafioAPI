package com.mailsonribeiro.desafioapi.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import com.mailsonribeiro.desafioapi.R


class RegisterFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navController = Navigation.findNavController(view)
        view.findViewById<MaterialButton>(R.id.btnLoginRegister).setOnClickListener{
            navController.navigate(R.id.homeFragment)

        }

        view.findViewById<ImageView>(R.id.ivBackToolbar).setOnClickListener{
            navController.popBackStack()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }
}