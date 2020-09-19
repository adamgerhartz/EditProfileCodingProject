package com.example.editprofilecodingproject.data.repository

import android.util.Log
import com.example.editprofilecodingproject.data.api.ApiHelper
import com.example.editprofilecodingproject.data.db.entity.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUserData(): Single<User> {
        return apiHelper.getProfileData()
    }
}