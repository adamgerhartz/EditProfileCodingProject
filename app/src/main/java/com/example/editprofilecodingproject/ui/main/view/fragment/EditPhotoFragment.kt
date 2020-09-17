package com.example.editprofilecodingproject.ui.main.view.fragment

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.editprofilecodingproject.R
import com.example.editprofilecodingproject.ui.main.viewmodel.EditPhotoViewModel
import kotlinx.android.synthetic.main.custom_toolbar.view.*
import kotlinx.android.synthetic.main.edit_photo_fragment.view.*


class EditPhotoFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    companion object {
        fun newInstance() = EditPhotoFragment()
    }

    private lateinit var viewModel: EditPhotoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.edit_photo_fragment, container, false)
        (activity as AppCompatActivity).setSupportActionBar(view.my_custom_toolbar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<View>(R.id.back_arrow).setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditPhotoViewModel::class.java)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.back_arrow -> requireActivity().onBackPressed()
        }
    }

}