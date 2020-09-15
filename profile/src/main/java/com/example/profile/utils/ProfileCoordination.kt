package com.example.profile.utils

import android.content.Context


interface ProfileCoordination {
    fun launchEditProfileActivity(context: Context)
}

class ProfileCoordinator(
    private val injector: Injector,
    private val presentation: ProfilePresentation
) : ProfileCoordination {

    override fun launchEditProfileActivity(context: Context) {
        val intent = injector.prepare(context, EditProfileActivity::class.java) {
            it.provide(this, presentation)
        }
    }

}