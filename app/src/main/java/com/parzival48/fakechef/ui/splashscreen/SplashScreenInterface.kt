package com.parzival48.fakechef.ui.splashscreen

interface SplashScreenInterface {
    interface View {
        fun goToLoginPage()
        fun showAlertDialog(title: String, message: String)
    }

    interface Presenter {
        fun cleanUp()
        fun checkVersion()
    }
}