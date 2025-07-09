package com.example.weekgineer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val etUsuario = view.findViewById<EditText>(R.id.etUsuario)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)
        val btnLogin = view.findViewById<MaterialButton>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val user = etUsuario.text.toString().trim()
            val pass = etPassword.text.toString().trim()

            if (user == "admin" && pass == "1234") {
                findNavController().navigate(R.id.action_loginFragment_to_informacion)
            } else {
                Toast.makeText(requireContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
