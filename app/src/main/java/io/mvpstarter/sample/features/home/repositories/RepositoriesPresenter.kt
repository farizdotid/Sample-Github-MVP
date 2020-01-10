package io.mvpstarter.sample.features.home.repositories

import android.annotation.SuppressLint
import android.util.Log
import io.mvpstarter.sample.data.DataManager
import io.mvpstarter.sample.data.model.Repository
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
class RepositoriesPresenter @Inject
constructor(private val dataManager: DataManager) : BasePresenter<RepositoriesView>() {
    @SuppressLint("CheckResult")
    fun getRepositories(keyword: String) {
        checkViewAttached()
        mvpView?.showLoading()
        dataManager.getRepositoriesList(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            mvpView?.dismissLoading()

                            val repositories: ArrayList<Repository> = ArrayList()
                            it.items.map { result ->
                                val ownerName = result.owner.login
                                val htmlUrl = result.html_url
                                val name = result.name
                                repositories.add(Repository(ownerName, htmlUrl, name))
                            }
                            mvpView?.isReqRepositories(repositories)
                        },
                        onError = {
                            mvpView?.apply {
                                mvpView?.dismissLoading()
                                showError(it)
                            }
                        }
                )
    }
}