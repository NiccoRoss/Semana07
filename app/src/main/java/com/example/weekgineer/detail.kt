package com.example.weekgineer

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialContainerTransform

class detail : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_host_fragment // <- usa el ID del NavHost de MainActivity
            duration = 300
            scrimColor = Color.TRANSPARENT
            containerColor = Color.WHITE
        }

        sharedElementReturnTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_host_fragment
            duration = 300
            scrimColor = Color.TRANSPARENT
            containerColor = Color.WHITE
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = detailArgs.fromBundle(requireArguments())

        val imageView = view.findViewById<ImageView>(R.id.imageIn)
        val fechaText = view.findViewById<TextView>(R.id.tvfecha)
        val descripcionText = view.findViewById<TextView>(R.id.detailText)

        imageView.setImageResource(args.imagenResId)
        fechaText.text = args.fecha
        descripcionText.text = args.descripcion
    }
}
