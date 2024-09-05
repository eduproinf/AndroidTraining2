package com.cepaleon.androidtraining2.features.login.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cepaleon.androidtraining2.R
import com.cepaleon.androidtraining2.features.login.LoginFactory
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var loginFactory: LoginFactory
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginFactory = LoginFactory(this)
        loginViewModel = loginFactory.provideLoginViewModel()
        setContentView(R.layout.activity_login)
        setupView()
    }

    private fun setupView() {
        val actionValidate = findViewById<Button>(R.id.action_validate)
        actionValidate.setOnClickListener {
            Log.d("@dev", "se ha hecho clic")
            val username = findViewById<EditText>(R.id.input_username).text.toString()
            val password = findViewById<EditText>(R.id.input_password).text.toString()
            val rememberIsChecked = findViewById<CheckBox>(R.id.rememeber_checkbox).isChecked
            val isValid: Boolean = loginViewModel.validateClicked(username, password, rememberIsChecked)
            if (isValid) {
                Snackbar.make(
                    findViewById(R.id.main),
                    R.string.message_login_ok,
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                Snackbar.make(
                    findViewById(R.id.main),
                    R.string.message_login_fails,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loginViewModel.onResume()?.let { username ->
            findViewById<EditText>(R.id.input_username).setText(username)
        }
    }
}