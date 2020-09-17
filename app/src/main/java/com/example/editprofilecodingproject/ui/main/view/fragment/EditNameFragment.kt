package com.example.editprofilecodingproject.ui.main.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.editprofilecodingproject.R
import com.example.editprofilecodingproject.ui.main.viewmodel.EditNameViewModel

class EditNameFragment : Fragment() {

    companion object {
        fun newInstance() = EditNameFragment()
    }

    private lateinit var viewModel: EditNameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.edit_name_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditNameViewModel::class.java)
        // TODO: Use the ViewModel
    }

}