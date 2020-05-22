package com.parzival48.fakechef.ui.lobby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.parzival48.fakechef.R

class LobbyActivity : AppCompatActivity(), LobbyInterface.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby)
    }

    override fun goToGameRoom() {
        TODO("Not yet implemented")
    }
}
