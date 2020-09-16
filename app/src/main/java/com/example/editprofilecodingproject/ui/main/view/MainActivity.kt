package com.example.editprofilecodingproject.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.editprofilecodingproject.DataSource
import com.example.editprofilecodingproject.R
import com.example.editprofilecodingproject.TopSpacingItemDecoration
import com.example.editprofilecodingproject.data.api.ApiHelper
import com.example.editprofilecodingproject.data.api.ApiServiceImpl
import com.example.editprofilecodingproject.data.model.ProfileInfo
import com.example.editprofilecodingproject.ui.base.ViewModelFactory
import com.example.editprofilecodingproject.ui.main.adapter.MainAdapter
//import com.example.editprofilecodingproject.ui.main.adapter.ProfileRecyclerAdapter
import com.example.editprofilecodingproject.ui.main.viewmodel.MainViewModel
import com.example.editprofilecodingproject.utils.Status
import kotlinx.android.synthetic.main.activity_main.*


//class MainActivity : AppCompatActivity() {
//
//    private lateinit var profileAdapter: ProfileRecyclerAdapter
//    private val mainActivityViewModel: MainActivityViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        NavigationUI.setUpActionBar
//
//        initRecyclerView()
//        addDataSets()
//    }
//
//    private fun addDataSets(){
//        val data = DataSource.createDataSet()
//        profileAdapter.submitList(data)
//    }
//
//    private fun initRecyclerView() {
//        recycler_view.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            val topSpacingDecorator = TopSpacingItemDecoration(30)
//            addItemDecoration(topSpacingDecorator)
//            profileAdapter = ProfileRecyclerAdapter()
//            adapter = profileAdapter
//        }
//    }
//}


class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf<ProfileInfo>())
        recycler_view.addItemDecoration(
            DividerItemDecoration(
                recycler_view.context,
                (recycler_view.layoutManager as LinearLayoutManager).orientation
            )
        )
        recycler_view.adapter = adapter
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel::class.java)
    }

    private fun setupObserver() {
        mainViewModel.getProfileData().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { profileData -> renderList(profileData) }
                    recycler_view.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recycler_view.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(profileData: List<ProfileInfo>) {
        adapter.addData(profileData)
        adapter.notifyDataSetChanged()
    }


}