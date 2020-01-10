package io.mvpstarter.sample.injection.component

import io.mvpstarter.sample.injection.PerActivity
import io.mvpstarter.sample.injection.module.ActivityModule
import io.mvpstarter.sample.features.base.BaseActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)
}
