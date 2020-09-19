package com.example.editprofilecodingproject.ui.main.viewmodel

//import com.example.editprofilecodingproject.ui.main.adapter.MainAdapter
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.editprofilecodingproject.data.db.entity.User
import com.example.editprofilecodingproject.data.repository.MainRepository
import com.example.editprofilecodingproject.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val user = MutableLiveData<Resource<User>>()
    private val compositeDisposable = CompositeDisposable()


    init {
        fetchData()
        Log.i("TAG", compositeDisposable.size().toString())
    }

    private fun fetchData() {
        user.postValue(Resource.loading(null))
        Thread(Runnable {
            compositeDisposable.add(
                mainRepository.getUserData()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ data ->
                        user.postValue(Resource.success(data))
                    }, { throwable ->
                        user.postValue(Resource.error("Something went wrong", null))
                    })
            )
        }).start()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getProfileData(): LiveData<Resource<User>> {
        return user
    }

}