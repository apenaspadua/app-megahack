package com.padua.app_realstate_mobile.network.bean

class LoginRequest (
    var email: String?,
    var password: String?
) {
    constructor() : this(email = null, password = null)
}