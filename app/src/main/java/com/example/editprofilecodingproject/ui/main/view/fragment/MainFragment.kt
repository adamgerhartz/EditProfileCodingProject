package com.example.editprofilecodingproject.ui.main.view.fragment

//import com.example.editprofilecodingproject.ui.main.adapter.MainAdapter
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.editprofilecodingproject.R
import com.example.editprofilecodingproject.data.api.ApiHelper
import com.example.editprofilecodingproject.data.api.ApiServiceImpl
import com.example.editprofilecodingproject.databinding.MainFragmentBinding
import com.example.editprofilecodingproject.ui.base.ViewModelFactory
import com.example.editprofilecodingproject.ui.main.viewmodel.MainViewModel
import com.example.editprofilecodingproject.utils.Status
import kotlinx.android.synthetic.main.edit_name_fragment.*
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.main_fragment.view.*
import org.kodein.di.Copy

class MainFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var navController: NavController
    var recipient1: String? = null
    var recipient2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient1 = requireArguments().getString("recipient1").toString()
        recipient2 = requireArguments().getString("recipient2").toString()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.fullName.value1 = recipient1.toString()
        binding.fullName.value2 = recipient2.toString()
        return binding.getRoot()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //setupUI()

        setupViewModel()
        setupObserver()


        // we're all set up and initialized
        // now to wait for events to start rolling in
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<View>(profile_image.id).setOnClickListener(this)
        view.findViewById<View>(full_Name.id).setOnClickListener(this)
        view.findViewById<View>(phone_number.id).setOnClickListener(this)
        view.findViewById<View>(email_address.id).setOnClickListener(this)
        view.findViewById<View>(about_me.id).setOnClickListener(this)



    }

//    private fun setupUI() {
//        recycler_view.layoutManager = LinearLayoutManager(activity)
//        adapter = MainAdapter(arrayListOf<ProfileInfo>())
//        recycler_view.addItemDecoration(
//            CustomDividerItemDecoration(
//                recycler_view.context,
//                (recycler_view.layoutManager as LinearLayoutManager).orientation,
//                false
//            )
//        )
//        recycler_view.addItemDecoration(
//            TopSpacingItemDecoration(30)
//        )
//        recycler_view.adapter = adapter
//    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel::class.java)
        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this




    }

    private fun setupObserver() {
        mainViewModel.getProfileData().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    // Render data before setting to visible
                    progressBar.visibility = View.GONE
                    edit_profile_views.visibility = View.VISIBLE

                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    edit_profile_views.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            profile_image.id -> {
                val bundle = bundleOf(Pair("recipient", mainViewModel.getProfileData().value!!.data!!.image_uri))
                navController.navigate(
                    R.id.action_mainFragment_to_editPhotoFragment,
                    bundle
                )
            }
            full_Name.id -> {
                val bundle = bundleOf(
                    Pair("recipient1", mainViewModel.getProfileData().value!!.data!!.first_nm),
                    Pair("recipient2", mainViewModel.getProfileData().value!!.data!!.last_nm)
                )
                navController.navigate(
                    R.id.action_mainFragment_to_editNameFragment,
                    bundle
                )
            }
            phone_number.id -> {
                val bundle = bundleOf(Pair("recipient", mainViewModel.getProfileData().value!!.data!!.phone))
                navController.navigate(
                    R.id.action_mainFragment_to_editPhoneNumberFragment,
                    bundle
                )
            }
            email_address.id -> {
                val bundle = bundleOf(Pair("recipient", mainViewModel.getProfileData().value!!.data!!.email))
                navController.navigate(
                    R.id.action_mainFragment_to_editEmailAddressFragment,
                    bundle
                )
            }
            about_me.id -> {
                val bundle = bundleOf(Pair("recipient", mainViewModel.getProfileData().value!!.data!!.about_me))
                navController.navigate(
                    R.id.action_mainFragment_to_editAboutMeFragment,
                    bundle
                )
            }
        }
    }

}