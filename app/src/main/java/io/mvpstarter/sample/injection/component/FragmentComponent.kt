package io.mvpstarter.sample.injection.component

import io.mvpstarter.sample.injection.PerFragment
import io.mvpstarter.sample.injection.module.FragmentModule
import dagger.Subcomponent
import io.mvpstarter.sample.features.home.repositories.RepositoriesFragment
import io.mvpstarter.sample.features.home.users.UsersFragment

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent{
    fun inject(usersFragment: UsersFragment)
    fun inject(repositoriesFragment: RepositoriesFragment)
}