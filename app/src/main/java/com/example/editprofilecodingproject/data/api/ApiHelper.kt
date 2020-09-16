package com.example.editprofilecodingproject.data.api

class ApiHelper(private val apiService: ApiService) {

    fun getProfileData() = apiService.getProfileData()

}