package com.example.editprofilecodingproject.ui.main.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.editprofilecodingproject.R
import com.example.editprofilecodingproject.ui.main.viewmodel.EditNameViewModel
import kotlinx.android.synthetic.main.custom_toolbar.view.*
import kotlinx.android.synthetic.main.update_button.*
import kotlinx.android.synthetic.main.update_button.view.*

class EditNameFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    companion object {
        fun newInstance() = EditNameFragment()
    }

    private lateinit var viewModel: EditNameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.edit_name_fragment, container, false)
        (activity as AppCompatActivity).setSupportActionBar(view.my_custom_toolbar)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditNameViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.back_arrow!!.setOnClickListener(this)
        view.update_button!!.setOnClickListener(this)
        update_button!!.isAllCaps = false
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.back_arrow -> requireActivity().onBackPressed()
            R.id.update_button -> {
                requireActivity().onBackPressed()
            }
        }
    }

}