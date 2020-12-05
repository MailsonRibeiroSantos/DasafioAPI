package com.mailsonribeiro.desafioapi.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import com.mailsonribeiro.desafioapi.R


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navController = Navigation.findNavController(view)
        view.findViewById<MaterialButton>(R.id.btnRegisterLogin).setOnClickListener{
            navController.navigate(R.id.registerFragment)
        }
        view.findViewById<MaterialButton>(R.id.btnLoginLogin).setOnClickListener{
            navController.navigate(R.id.homeFragment)
        }
    }


}