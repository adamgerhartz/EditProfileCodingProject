package com.example.editprofilecodingproject.models

import android.graphics.drawable.Drawable

data class ProfileInfo(
    var name: String,
    var description: String,
    var photo: String = "/Users/adamgerhartz/AndroidStudioProjects/EditProfileCodingProject/app/src/main/res/drawable/profile_pic.png",
    var headerTextEditProfile: String = "Edit Profile"
) {
    override fun toString(): String {
        return "ProfileInfo(name='$name', " +
                           "description='$description', " +
                           "photo='$photo', " +
                           "headerTextEditProfile='$headerTextEditProfile')"
    }
}

