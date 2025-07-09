package com.example.weekgineer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class informacion : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_informacion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        context?.let { ctx ->
            val cardItems = listOf(
                CardData(
                    "Lunes",
                    "Plazuela UNS",
                    "Inauguración",
                    R.drawable.inauguracion,
                    "Lunes 02 - 06 - 2025",
                    descripcion = ctx.getString(R.string.Lunes01)
                ),
                CardData(
                    "Martes",
                    "Auditorios",
                    "Conferencias EPIA, EPIAG, EPISI",
                    R.drawable.ingeniero2,
                    "Martes 03 - 06 - 2025",
                    ctx.getString(R.string.Martes02)
                ),
                CardData(
                    "Miércoles",
                    "Auditorios",
                    "Conferencias EPIE, EPIM, EPIC",
                    R.drawable.central,
                    "Martes 03 - 06 - 2025",
                    ctx.getString(R.string.Miercoles03)
                ),
                CardData(
                    "Jueves",
                    "Capilla  y AUditorio",
                    "Día Central",
                    R.drawable.misa,
                    "Martes 03 - 06 - 2025",
                    ctx.getString(R.string.Jueves04)
                ),
                CardData(
                    "Viernes",
                    "Complejo Deportivo UNS",
                    "Campeonatos",
                    R.drawable.dia_ingeniero,
                    "Martes 03 - 06 - 2025",
                    ctx.getString(R.string.Viernes05)
                )
            )

            recyclerView.adapter = CardAdapter(cardItems) { cardView, item ->
                val extras = FragmentNavigatorExtras(cardView to cardView.transitionName)
                val action = informacionDirections.actionInformacionToDetail(
                    titulo = item.title,
                    subhead = item.subhead,
                    infoText = item.infoText,
                    imagenResId = item.imageResId,
                    fecha = item.fecha,
                    descripcion = item.descripcion

                )
                findNavController().navigate(action, extras)
            }
        }
    }
}
