package com.example.editprofilecodingproject.data.model

import com.google.gson.annotations.SerializedName

data class ProfileInfo(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("description")
    var description: String = ""
) {
    override fun toString(): String {
        return "ProfileInfo(id='$id',name='$name',description='$description')"
    }
}

