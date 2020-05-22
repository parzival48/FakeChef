package com.parzival48.fakechef.ui.lobby

interface LobbyInterface {
    interface View {
        fun goToGameRoom()
    }

    interface Presenter {
        fun cleanUp()
        fun findRoom()
    }
}