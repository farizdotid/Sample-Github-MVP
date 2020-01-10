package io.mvpstarter.sample.features.home.repositories

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import io.mvpstarter.sample.R
import io.mvpstarter.sample.data.model.Repository
import javax.inject.Inject

class RepositoriesAdapter @Inject
constructor() : RecyclerView.Adapter<RepositoriesAdapter.RepositoryViewHolder>() {

    private var repositoryList: List<Repository> = emptyList<Repository>()

    fun setRepositories(repositories: List<Repository>) {
        repositoryList = repositories
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_repository, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val user = repositoryList[position]

        val name = user.name
        val url = user.htmlUrl
        val ownerName = user.ownerName

        holder.bind(name, url, ownerName)
    }

    override fun getItemCount(): Int {
        return repositoryList.size
    }

    inner class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.tvName)
        lateinit var tvName: TextView

        @BindView(R.id.tvHtmlUrl)
        lateinit var tvHtmlUrl: TextView

        @BindView(R.id.tvOwner)
        lateinit var tvOwner: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bind(fullname: String, url: String, ownerName: String) {
            val worddingName = "Nama : $fullname"
            tvName.text = worddingName

            val worddingUrl= "Url : $url"
            tvHtmlUrl.text = worddingUrl

            val worddingOwner= "Owner : $ownerName"
            tvOwner.text = worddingOwner
        }
    }

}