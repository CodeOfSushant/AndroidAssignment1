package com.example.userprofile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profileinput)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            lateinit var name: String
            lateinit var age: String
            lateinit var email: String
            var isValid = true

            try {
                name = editTextName.text.toString()
                if (name.isEmpty() || !name.matches("^[A-Za-z\\s]+$".toRegex()) || name.length < 2) {
                    Toast.makeText(
                        this,
                        " Name Cant be Empty/Enter Valid Name",
                        Toast.LENGTH_SHORT
                    ).show()
                    isValid = false
                }
                age = editTextAge.text.toString()
                if (age.toInt() <= 0 || age.isEmpty()) {
                    Toast.makeText(this, "Please Enter Valid Age", Toast.LENGTH_SHORT).show()
                    isValid = false
                }
                email = editTextEmail.text.toString()
                if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                        .matches()
                ) {
                    Toast.makeText(this, "Enter Valid Email", Toast.LENGTH_SHORT).show()
                    isValid = false
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Please Enter Valid Age", Toast.LENGTH_SHORT).show()
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
            if (!isValid) {
                Toast.makeText(this, " Please Enter correct Details First", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}