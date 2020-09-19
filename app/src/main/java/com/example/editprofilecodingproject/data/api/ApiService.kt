package com.example.editprofilecodingproject.data.api

import com.example.editprofilecodingproject.data.db.entity.User
import io.reactivex.Single

interface ApiService {

    fun getProfileData(): Single<User>

}