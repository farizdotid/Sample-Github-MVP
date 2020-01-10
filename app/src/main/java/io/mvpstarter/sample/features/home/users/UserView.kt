package io.mvpstarter.sample.features.home.users

import io.mvpstarter.sample.data.model.User
import io.mvpstarter.sample.features.base.MvpView

/**
 * Created by Fariz Ramadhan.
 * website : https://farizdotid.com/
 * github : https://github.com/farizdotid
 * linkedin : https://www.linkedin.com/in/farizramadhan/
 */
interface UserView : MvpView{
    fun showLoading()
    fun dismissLoading()
    fun showError(error: Throwable)
    fun isReqUsers(users : List<User>)
}