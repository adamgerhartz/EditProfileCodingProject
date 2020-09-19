package com.example.editprofilecodingproject.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity(tableName = "profile_tbl")
data class User(

    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "image_uri") var image_uri: String,
    @ColumnInfo(name = "first_nm") var first_nm: String,
    @ColumnInfo(name = "last_nm") var last_nm: String,
    @ColumnInfo(name = "phone") var phone: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "about_me") var about_me: String

) {
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}

