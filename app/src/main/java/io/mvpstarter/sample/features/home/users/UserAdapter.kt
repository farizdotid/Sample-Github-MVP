package io.mvpstarter.sample.features.home.users

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import io.mvpstarter.sample.R
import io.mvpstarter.sample.data.model.User
import io.mvpstarter.sample.util.loadImageFromUrl
import javax.inject.Inject

class UserAdapter @Inject
constructor() : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList: List<User> = emptyList<User>()

    fun setUsers(users: List<User>) {
        userList = users
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]

        val name = user.login
        val url = user.url
        val type = user.type
        val avatarUrl = user.avatarUrl

        holder.bind(name, url, type, avatarUrl)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.tvName)
        lateinit var tvName: TextView

        @BindView(R.id.tvUrl)
        lateinit var tvUrl: TextView

        @BindView(R.id.tvType)
        lateinit var tvType: TextView

        @BindView(R.id.ivAvatar)
        lateinit var ivAvatar: ImageView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bind(name: String, url: String, type: String, avatarUrl: String) {
            tvName.text = name
            tvUrl.text = url
            tvType.text = type
           ivAvatar.loadImageFromUrl(avatarUrl)
        }
    }

}