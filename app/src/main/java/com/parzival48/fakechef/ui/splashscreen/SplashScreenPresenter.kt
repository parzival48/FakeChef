package com.parzival48.fakechef.ui.splashscreen

import android.util.Log
import com.parzival48.fakechef.model.AppProperties
import com.parzival48.fakechef.service.HttpAPI
import com.parzival48.fakechef.service.NetworkCaller
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SplashScreenPresenter(private var view: SplashScreenInterface.View? = null) : SplashScreenInterface.Presenter {

    private val THIS_VERSION = "0.1.1"

    override fun cleanUp() {
        view = null
    }

    override fun checkVersion() {
        var latestVersion = AppProperties(false,"","","-1")
        val service = NetworkCaller.converterRetrofit
        service.create(HttpAPI::class.java)
            .getAppProperties()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: Observer<AppProperties>{
                override fun onComplete() {
                }
                override fun onSubscribe(d: Disposable) {
                }
                override fun onNext(status: AppProperties) {
                    latestVersion = status
                }
                override fun onError(e: Throwable) {
                    Log.e("FakeChef","No connection")
                }
            })
        Thread {
            Thread.sleep(3000)
            if(latestVersion.online) {
                if(latestVersion.version == THIS_VERSION) {
                    view?.goToLoginPage()
                }
                else{
                    view?.showAlertDialog("Update Require",
                        "The latest version of this app is available on Play Store"
                    )
                }
            }
            else {
                view?.showAlertDialog("Offline Server",
                    "The game server is not available right now."
                )
            }
        }.start()
    }

}