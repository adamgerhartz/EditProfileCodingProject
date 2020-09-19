package com.example.editprofilecodingproject.data.api

import com.example.editprofilecodingproject.data.db.entity.User
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl : ApiService {

    override fun getProfileData(): Single<User> {
        val single: Single<User> = (
                Rx2AndroidNetworking.get("https://raw.githubusercontent.com/adamgerhartz/EditProfileCodingProject/master/data.json")
                    .build()
                    .getObjectSingle(User::class.java)
                )
        return single
    }
}