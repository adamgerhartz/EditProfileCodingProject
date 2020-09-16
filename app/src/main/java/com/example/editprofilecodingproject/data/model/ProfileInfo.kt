package com.example.editprofilecodingproject.data.model

import com.google.gson.annotations.SerializedName

data class ProfileInfo(
    @SerializedName("name")
    var name: String = "",
    @SerializedName("description")
    var description: String = ""
) {
    override fun toString(): String {
        return "ProfileInfo(name='$name',description='$description')"
    }
}

