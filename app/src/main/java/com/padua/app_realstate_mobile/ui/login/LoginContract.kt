package com.padua.app_realstate_mobile.ui.login

import com.padua.app_realstate_mobile.network.bean.LoginRequest

interface LoginContract {

    interface Interactor {
        fun login(loginRequest: LoginRequest)
    }

}