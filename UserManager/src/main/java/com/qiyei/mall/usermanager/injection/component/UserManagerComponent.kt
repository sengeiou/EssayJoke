package com.qiyei.mall.usermanager.injection.component


import com.qiyei.mall.usermanager.injection.module.UserManagerModule
import com.qiyei.mall.usermanager.ui.activity.UserRegisterActivity
import dagger.Component

/**
 * @author Created by qiyei2015 on 2018/9/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@Component(modules = arrayOf(UserManagerModule::class))
interface UserManagerComponent {

    /**
     * 需要注入的地方
     */
    fun inject(activity: UserRegisterActivity)

}