package com.example.editprofilecodingproject.data.repository

import com.example.editprofilecodingproject.data.api.ApiHelper
import com.example.editprofilecodingproject.data.model.ProfileInfo
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getProfileData(): Single<List<ProfileInfo>> {

        return apiHelper.getProfileData()

    }

}