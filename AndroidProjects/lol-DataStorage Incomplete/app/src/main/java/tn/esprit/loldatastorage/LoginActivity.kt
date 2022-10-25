package tn.esprit.loldatastorage

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import tn.esprit.loldatastorage.utils.LOGIN
import tn.esprit.loldatastorage.utils.PASSWORD
import tn.esprit.loldatastorage.utils.PREF_NAME


class LoginActivity : AppCompatActivity() {

    lateinit var txtLogin: TextInputEditText
    lateinit var txtLayoutLogin: TextInputLayout

    lateinit var txtPassword: TextInputEditText
    lateinit var txtLayoutPassword: TextInputLayout

    lateinit var cbRememberMe: CheckBox
    lateinit var btnLogin: MaterialButton

    private lateinit var sharedPrefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtLogin = findViewById(R.id.txtLogin)
        txtLayoutLogin = findViewById(R.id.txtLayoutLogin)

        txtPassword = findViewById(R.id.txtPassword)
        txtLayoutPassword = findViewById(R.id.txtLayoutPassword)

        cbRememberMe = findViewById(R.id.cbRememberMe)
        btnLogin = findViewById(R.id.btnLogin)

        sharedPrefs = getSharedPreferences(
            PREF_NAME, Context.MODE_PRIVATE
        )

        if (sharedPrefs.getString(LOGIN, "")!!.isNotEmpty())
            navigate()

        btnLogin.setOnClickListener {
            doLogin()
        }

    }

    private fun doLogin() {
        if (validate()) {
            if (cbRememberMe.isChecked) {
                sharedPrefs
                    .edit().apply {
                        putString(LOGIN, txtLogin.text.toString())
                        putString(PASSWORD, txtPassword.text.toString())
                        apply()
                    }
            }
            navigate()
        }
    }

    private fun validate(): Boolean {
        txtLayoutLogin.error = null
        txtLayoutPassword.error = null

        if (txtLogin.text!!.isEmpty()) {
            txtLayoutLogin.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        if (txtPassword.text!!.isEmpty()) {
            txtLayoutPassword.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        return true
    }

    private fun navigate() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}