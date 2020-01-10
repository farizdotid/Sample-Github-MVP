package io.mvpstarter.sample.features.home.users

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import io.mvpstarter.sample.R
import io.mvpstarter.sample.data.model.User
import io.mvpstarter.sample.features.base.BaseFragment
import io.mvpstarter.sample.injection.component.FragmentComponent
import io.mvpstarter.sample.util.TOAST
import kotlinx.android.synthetic.main.fragment_users.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class UsersFragment : BaseFragment(), UserView {

    @Inject lateinit var userAdapter: UserAdapter
    @Inject lateinit var userPresenter: UserPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentComponent().inject(this)
        userPresenter.attachView(this)
        rvUsers.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = userAdapter
        }

        userPresenter.getUsers()
    }

    override fun layoutId(): Int {
        return R.layout.fragment_users
    }

    override fun showLoading() {
        pbLoading.visibility = View.VISIBLE
    }

    override fun dismissLoading() {
        pbLoading.visibility = View.GONE
    }

    override fun showError(error: Throwable) {
        TOAST(error.message.toString(), Toast.LENGTH_SHORT)
    }

    override fun isReqUsers(users: List<User>) {
        userAdapter.apply {
            setUsers(users)
            notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        userPresenter.detachView()
    }
}