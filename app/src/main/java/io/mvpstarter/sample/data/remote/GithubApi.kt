package io.mvpstarter.sample.data.remote

import io.mvpstarter.sample.data.model.ResponseRepositories
import io.mvpstarter.sample.data.model.ResponseUsers
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Fariz Ramadhan.
 * website : https://farizdotid.com/
 * github : https://github.com/farizdotid
 * linkedin : https://www.linkedin.com/in/farizramadhan/
 */
interface GithubApi {

    @GET("repos/square/retrofit/contributors")
    fun getUsers() : Single<List<ResponseUsers>>

    @GET("search/repositories")
    fun getRepositories(@Query("q") keyword:String) : Single<ResponseRepositories>
}