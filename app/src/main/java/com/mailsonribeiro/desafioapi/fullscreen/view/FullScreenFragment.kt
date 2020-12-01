package com.mailsonribeiro.desafioapi.fullscreen.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.mailsonribeiro.desafioapi.R
import com.mailsonribeiro.desafioapi.listagem.view.HomeFragment
import com.squareup.picasso.Picasso


class FullScreenFragment : DialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_full_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagem = view.findViewById<ImageView>(R.id.ivFullScreen)

        val miniatura = arguments?.getString(HomeFragment.COMICS_MINIATURA)

        var navController = Navigation.findNavController(view)

        Picasso.get().load(miniatura).into(imagem)
        view.findViewById<ImageView>(R.id.ivClose).setOnClickListener {
            navController.popBackStack()
        }
    }




    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog =  super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }


}