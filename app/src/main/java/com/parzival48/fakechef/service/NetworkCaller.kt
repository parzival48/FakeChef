package com.parzival48.fakechef.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class NetworkCaller {

    companion object {
        val converterRetrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl("http://192.168.43.28:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(unsafeOkHttpClient)
                .build()

        val defaultRetrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl("http://192.168.43.28:8080/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(unsafeOkHttpClient)
                .build()

        private val unsafeOkHttpClient: OkHttpClient
            get() = try {
                val trustAllCerts =
                    arrayOf<TrustManager>(
                        object : X509TrustManager {
                            @Throws(CertificateException::class)
                            override fun checkClientTrusted(
                                chain: Array<X509Certificate>,
                                authType: String
                            ) {
                            }

                            @Throws(CertificateException::class)
                            override fun checkServerTrusted(
                                chain: Array<X509Certificate>,
                                authType: String
                            ) {
                            }

                            override fun getAcceptedIssuers(): Array<X509Certificate> {
                                return arrayOf()
                            }
                        }
                    )
                val sslContext =
                    SSLContext.getInstance("SSL")
                sslContext.init(null, trustAllCerts, SecureRandom())
                val sslSocketFactory = sslContext.socketFactory
                val builder = OkHttpClient.Builder()
                builder.sslSocketFactory(sslSocketFactory)
                builder.hostnameVerifier { hostname, session -> true }
                builder.build()
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
    }
}