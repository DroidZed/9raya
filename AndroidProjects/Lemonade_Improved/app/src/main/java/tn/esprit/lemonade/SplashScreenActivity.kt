package tn.esprit.lemonade

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(mainLooper).postDelayed({ //This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(i)
            // close this activity
            finish()
        }, 1500)
    }
}