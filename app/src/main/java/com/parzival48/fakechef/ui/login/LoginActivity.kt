package com.parzival48.fakechef.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.parzival48.fakechef.R
import com.parzival48.fakechef.ui.lobby.LobbyActivity

class LoginActivity : AppCompatActivity(), LoginInterface.View {

    private lateinit var presenter: LoginPresenter
    private lateinit var txtName: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(view = this)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.cleanUp()
    }

    override fun goToLobbyPage() {
        val nextScreen = Intent(this, LobbyActivity::class.java)
        startActivity(nextScreen)
        finish()
    }

    private fun initView() {
        txtName = findViewById(R.id.txt_name)
        btnLogin = findViewById(R.id.btn_login)
        /** Handle Button Click **/
        btnLogin.setOnClickListener {
            presenter.authenticate(txtName.text.toString())
        }
    }

}
