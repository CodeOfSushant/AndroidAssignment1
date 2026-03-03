package com.example.userprofile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.userprofile.databinding.ActivityProfileinputBinding

class ProfileInputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileinputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileinputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSubmit.setOnClickListener {
            lateinit var name: String
            lateinit var age: String
            lateinit var email: String
            var isValid = true

                name = binding.etName.text.toString()
                if (name.isEmpty() || !name.matches("^[A-Za-z\\s]+$".toRegex()) || name.length < 2) {
                    Toast.makeText(
                        this,
                        " Name Cant be Empty/Enter Valid Name",
                        Toast.LENGTH_SHORT
                    ).show()
                    isValid = false
                }
                age = binding.etAge.text.toString()
                if (age.isEmpty()) {
                    Toast.makeText(this, "Please Enter Valid Age", Toast.LENGTH_SHORT).show()
                    isValid = false
                }else {
                    try {
                        val ageInt = age.toInt()
                        if (ageInt <= 0) {
                            Toast.makeText(this, "Please Enter Valid Age", Toast.LENGTH_SHORT).show()
                            isValid = false
                        }
                    } catch (e: NumberFormatException) {
                        Toast.makeText(this, "Please Enter Valid Age", Toast.LENGTH_SHORT).show()
                        isValid = false
                    }
                }

                email = binding.etEmail.text.toString()
                if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                        .matches()
                ) {
                    Toast.makeText(this, "Enter Valid Email", Toast.LENGTH_SHORT).show()
                    isValid = false
                }

            if (isValid) {
                val intent = Intent(this, ProfileDisplayActivity::class.java)
                val bundle = Bundle()
                bundle.putString("Name", name)
                bundle.putString("Age", age)
                bundle.putString("Email", email)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, " Please Enter correct Details First", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}