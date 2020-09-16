package com.example.editprofilecodingproject.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.editprofilecodingproject.data.model.ProfileInfo
import com.example.editprofilecodingproject.data.repository.MainRepository
import com.example.editprofilecodingproject.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val profileData = MutableLiveData<Resource<List<ProfileInfo>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchData()
    }

    private fun fetchData() {
        profileData.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getProfileData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ dataList ->
                    profileData.postValue(Resource.success(dataList))
                }, { throwable ->
                    profileData.postValue(Resource.error("Something went wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getProfileData(): LiveData<Resource<List<ProfileInfo>>> {
        return profileData
    }

}