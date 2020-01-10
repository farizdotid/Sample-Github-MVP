package io.mvpstarter.sample.features.home.users

import android.annotation.SuppressLint
import android.util.Log
import io.mvpstarter.sample.data.DataManager
import io.mvpstarter.sample.data.model.User
import io.mvpstarter.sample.features.base.BasePresenter
import io.mvpstarter.sample.injection.ConfigPersistent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Fariz Ramadhan.
 * website : https://farizdotid.com/
 * github : https://github.com/farizdotid
 * linkedin : https://www.linkedin.com/in/farizramadhan/
 */
@ConfigPersistent
class UserPresenter @Inject
constructor(private val dataManager: DataManager) : BasePresenter<UserView>() {
    @SuppressLint("CheckResult")
    fun getUsers() {
        checkViewAttached()
        mvpView?.showLoading()
        dataManager.getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            mvpView?.dismissLoading()

                            val users: ArrayList<User> = ArrayList()
                            it.map {result ->
                                val login = result.login
                                val url = result.url
                                val type = result.type
                                val avatarUrl = result.avatar_url
                                users.add(User(login, url, type, avatarUrl))
                            }
                            mvpView?.isReqUsers(users)
                        },
                        onError = { mvpView?.apply {
                            mvpView?.dismissLoading()
                            showError(it)
                        } }
                )
    }
}