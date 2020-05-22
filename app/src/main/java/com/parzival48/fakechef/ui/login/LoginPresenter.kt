package com.parzival48.fakechef.ui.login

import android.util.Log
import com.parzival48.fakechef.service.HttpAPI
import com.parzival48.fakechef.service.NetworkCaller
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter(private var view: LoginInterface.View? = null) : LoginInterface.Presenter {

    override fun cleanUp() {
        view = null
    }

    override fun authenticate(name: String) {
        val service = NetworkCaller.defaultRetrofit
        service.create(HttpAPI::class.java)
            .postUser(name,"555.jpg")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: Observer<String> {
                override fun onComplete() {}
                override fun onSubscribe(d: Disposable) {}
                override fun onNext(result: String) {
                    Log.i("FakeChef", result)
                }
                override fun onError(e: Throwable) {}
            })
    }
}