package com.padua.app_realstate_mobile.utils

import android.view.View
import com.thekhaeng.pushdownanim.PushDownAnim

open class Utils {

    companion object {
        fun setPushDownAnimation(view: View) {
            PushDownAnim.setPushDownAnimTo(view)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_RELEASE_DURATION)
                .setInterpolatorPush(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setInterpolatorRelease(PushDownAnim.DEFAULT_INTERPOLATOR)
        }
    }


}