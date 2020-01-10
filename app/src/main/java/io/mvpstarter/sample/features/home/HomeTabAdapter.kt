package io.mvpstarter.sample.features.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import io.mvpstarter.sample.features.home.repositories.RepositoriesFragment
import io.mvpstarter.sample.features.home.users.UsersFragment

/**
 * Created by Fariz Ramadhan.
 * website : https://farizdotid.com/
 * github : https://github.com/farizdotid
 * linkedin : https://www.linkedin.com/in/farizramadhan/
 */
class HomeTabAdapter (fm: FragmentManager, private val mNumOfTabs: Int) :
        FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> UsersFragment()
            1 -> RepositoriesFragment()
            else -> UsersFragment()
        }
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }

}