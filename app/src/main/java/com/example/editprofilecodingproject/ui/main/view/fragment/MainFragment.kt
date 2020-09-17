package com.example.editprofilecodingproject.ui.main.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.editprofilecodingproject.R
import com.example.editprofilecodingproject.data.api.ApiHelper
import com.example.editprofilecodingproject.data.api.ApiServiceImpl
import com.example.editprofilecodingproject.data.model.ProfileInfo
import com.example.editprofilecodingproject.ui.base.ViewModelFactory
import com.example.editprofilecodingproject.ui.main.adapter.MainAdapter
import com.example.editprofilecodingproject.ui.main.view.decor.CustomDividerItemDecoration
import com.example.editprofilecodingproject.ui.main.view.decor.TopSpacingItemDecoration
import com.example.editprofilecodingproject.ui.main.viewmodel.MainViewModel
import com.example.editprofilecodingproject.utils.Status
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupUI() {
        recycler_view.layoutManager = LinearLayoutManager(activity)
        adapter = MainAdapter(arrayListOf<ProfileInfo>())
        recycler_view.addItemDecoration(
            CustomDividerItemDecoration(
                recycler_view.context,
                (recycler_view.layoutManager as LinearLayoutManager).orientation,
                false
            )
        )
        recycler_view.addItemDecoration(
            TopSpacingItemDecoration(30)
        )
        recycler_view.adapter = adapter
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel::class.java)
    }

    private fun setupObserver() {
        mainViewModel.getProfileData().observe(viewLifecycleOwner, Observer {
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
                    Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(profileData: List<ProfileInfo>) {
        adapter.addData(profileData)
        adapter.notifyDataSetChanged()
    }

}