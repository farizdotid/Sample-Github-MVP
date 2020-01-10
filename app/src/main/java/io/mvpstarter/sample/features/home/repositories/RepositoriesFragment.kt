package io.mvpstarter.sample.features.home.repositories

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import io.mvpstarter.sample.R
import io.mvpstarter.sample.data.model.Repository
import io.mvpstarter.sample.features.base.BaseFragment
import io.mvpstarter.sample.util.TOAST
import io.mvpstarter.sample.util.hideSoftKeyboard
import kotlinx.android.synthetic.main.fragment_repositories.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class RepositoriesFragment : BaseFragment(), RepositoriesView {

    @Inject lateinit var repositoriesAdapter: RepositoriesAdapter
    @Inject lateinit var repositoriesPresenter: RepositoriesPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentComponent().inject(this)
        repositoriesPresenter.attachView(this)

        rvRepositories.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = repositoriesAdapter
        }

        etSearch.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(input: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val keywordLength = input?.length
                if (keywordLength != null) {
                    if (keywordLength >= 3){
                        val keyword = input.toString()
                        repositoriesPresenter.getRepositories(keyword)
                    }
                }
            }
        })

        ivClear.setOnClickListener {
            etSearch.setText("")
            repositoriesAdapter.apply {
                setRepositories(arrayListOf())
                notifyDataSetChanged()
            }
            activity?.hideSoftKeyboard()
        }
    }
    override fun layoutId(): Int {
        return R.layout.fragment_repositories
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

    override fun isReqRepositories(repositories: List<Repository>) {
        repositoriesAdapter.apply {
            setRepositories(repositories)
            notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        repositoriesPresenter.detachView()
    }

}