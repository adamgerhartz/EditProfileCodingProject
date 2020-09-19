package com.example.editprofilecodingproject.ui.main.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.editprofilecodingproject.R
import com.example.editprofilecodingproject.ui.main.viewmodel.EditNameViewModel
import kotlinx.android.synthetic.main.custom_toolbar.view.*
import kotlinx.android.synthetic.main.edit_name_fragment.*
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.update_button.*
import kotlinx.android.synthetic.main.update_button.view.*

class EditNameFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var recipient1: String
    private lateinit var recipient2: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient1 = requireArguments().getString("recipient1").toString()
        recipient2 = requireArguments().getString("recipient2").toString()

        Log.i("RECIP", recipient1 + " and " + recipient2)
    }


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
        view?.findViewById<TextView>(R.id.first_name_text)?.text = "First Name"
        view?.findViewById<TextView>(R.id.last_name_text)?.text = "Last Name"
        view?.findViewById<EditText>(R.id.edit_text_first_name)?.setText(recipient1, TextView.BufferType.EDITABLE)
        view?.findViewById<EditText>(R.id.edit_text_last_name)?.setText(recipient2, TextView.BufferType.EDITABLE)
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