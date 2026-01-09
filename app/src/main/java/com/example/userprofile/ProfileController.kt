package com.example.userprofile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bluelinelabs.conductor.Controller

class ProfileController(args: Bundle?) : Controller(args) {
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.controller_profile, container, false)
        val name = args.getString("Name")
        val age = args.getString("Age")
        val email = args.getString("Email")

        val textViewName = view.findViewById<TextView>(R.id.textViewName1)
        textViewName.text = "Name:  $name"
        val textViewAge = view.findViewById<TextView>(R.id.textViewAge1)
        textViewAge.text = "Age: $age"
        val textViewEmail = view.findViewById<TextView>(R.id.textViewEmail1)
        textViewEmail.text = "Email: $email"
        val backButton = view.findViewById<Button>(R.id.btnback)
        backButton.setOnClickListener {
            activity?.finish()
        }
        return view
    }
}