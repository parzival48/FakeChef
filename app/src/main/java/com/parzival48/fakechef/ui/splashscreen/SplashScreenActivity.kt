package com.parzival48.fakechef.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.parzival48.fakechef.R
import com.parzival48.fakechef.ui.dialog.AlertPopup
import com.parzival48.fakechef.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity(), SplashScreenInterface.View {

    private lateinit var presenter: SplashScreenPresenter
    private lateinit var fragManagement : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        presenter = SplashScreenPresenter(view = this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.cleanUp()
    }

    override fun onStart() {
        super.onStart()
        presenter.checkVersion()
    }

    override fun goToLoginPage() {
        val nextScreen = Intent(this, LoginActivity::class.java)
        startActivity(nextScreen)
        finish()
    }

    override fun showAlertDialog(title: String, message: String) {
        /*
        runOnUiThread {
            txtDialogTitle.text = title
            txtDialogMessage.text = message
            updateDialogLayout.visibility = View.VISIBLE
        }
        */
        runOnUiThread {
            fragManagement = supportFragmentManager
            val alertDialogFragment = AlertPopup(title, message)
            alertDialogFragment.show(fragManagement,"fragment_alert")
        }
    }
}
