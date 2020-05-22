package com.parzival48.fakechef.ui.login

interface LoginInterface {
    interface View {
        fun goToLobbyPage()
    }

    interface Presenter {
        fun cleanUp()
        fun authenticate(name: String)
    }
}