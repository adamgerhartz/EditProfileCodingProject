package com.example.editprofilecodingproject.data.api

import android.provider.ContactsContract
import com.example.editprofilecodingproject.data.model.ProfileInfo
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl : ApiService {

    override fun getProfileData(): Single<List<ProfileInfo>> {
        return Rx2AndroidNetworking.get("https://raw.githubusercontent.com/adamgerhartz/EditProfileCodingProject/master/app/src/main/res/values/data.json")
            .build()
            .getObjectListSingle(ProfileInfo::class.java)
    }

}