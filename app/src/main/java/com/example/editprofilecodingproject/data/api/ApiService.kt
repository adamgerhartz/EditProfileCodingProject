package com.example.editprofilecodingproject.data.api

import com.example.editprofilecodingproject.data.model.ProfileInfo
import io.reactivex.Single

interface ApiService {

    fun getProfileData(): Single<List<ProfileInfo>>

}