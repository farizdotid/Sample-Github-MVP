package io.mvpstarter.sample.data

import io.mvpstarter.sample.annotation.OpenClassOnDebug
import io.mvpstarter.sample.data.model.ResponseRepositories
import io.mvpstarter.sample.data.model.ResponseUsers
import io.mvpstarter.sample.data.remote.GithubApi
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@OpenClassOnDebug
@Singleton
class DataManager @Inject
constructor(private val githubApi: GithubApi) {

    fun getUserList() : Single<List<ResponseUsers>> {
        return githubApi.getUsers()
    }

    fun getRepositoriesList(keyword:String) : Single<ResponseRepositories>{
        return githubApi.getRepositories(keyword)
    }
}