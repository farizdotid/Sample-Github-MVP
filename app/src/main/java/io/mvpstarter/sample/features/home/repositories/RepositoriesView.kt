package io.mvpstarter.sample.features.home.repositories

import io.mvpstarter.sample.data.model.Repository
import io.mvpstarter.sample.features.base.MvpView

/**
 * Created by Fariz Ramadhan.
 * website : https://farizdotid.com/
 * github : https://github.com/farizdotid
 * linkedin : https://www.linkedin.com/in/farizramadhan/
 */
interface RepositoriesView : MvpView{
    fun showLoading()
    fun dismissLoading()
    fun showError(error: Throwable)
    fun isReqRepositories(repositories : List<Repository>)
}