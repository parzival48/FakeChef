package com.parzival48.fakechef.service

import com.parzival48.fakechef.model.AppProperties
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface HttpAPI {

    @GET("app.json")
    fun getAppProperties() : Observable<AppProperties>

    @FormUrlEncoded
    @POST("login")
    fun postUser(
        @Field("name") name: String,
        @Field("image") image: String
    ) : Observable<String>

    @GET("allingredients.json")
    fun getAllIngredients() : Call<AppProperties>

}