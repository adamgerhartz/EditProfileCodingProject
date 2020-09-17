package com.example.editprofilecodingproject.ui.main.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.editprofilecodingproject.R
import com.example.editprofilecodingproject.ui.main.viewmodel.EditEmailAddressViewModel
import kotlinx.android.synthetic.main.custom_toolbar.view.*

class EditEmailAddressFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    companion object {
        fun newInstance() = EditEmailAddressFragment()
    }

    private lateinit var viewModel: EditEmailAddressViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.edit_email_address_fragment, container, false)
        (activity as AppCompatActivity).setSupportActionBar(view.my_custom_toolbar)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditEmailAddressViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<View>(R.id.back_arrow).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.back_arrow -> requireActivity().onBackPressed()
        }
    }

}