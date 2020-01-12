package com.task.pguserdemoapp.ui.login.fragment

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.FragmentMobileNumberBinding
import com.task.pguserdemoapp.ui.login.LoginViewModel
import com.task.pguserdemoapp.ui.registration.UserRegistrationActivity
import com.task.pguserdemoapp.utilz.Utility
import kotlinx.android.synthetic.main.fragment_mobile_number.*


class MobileNumberFragment : Fragment() {
    var viewModel: LoginViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: FragmentMobileNumberBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_mobile_number,
                container,
                false
            )
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWidgit()
        editTextChangeListener()



        viewModel?.otpReceived?.observe(this, Observer {
            submit_button.text = resources.getString(R.string.title_verify_otp)
            circular_text_view_one.setText(it.message?.get(0)?.toString())
            circular_text_view_two.setText(it.message?.get(1)?.toString())
            circular_text_view_three.setText(it.message?.get(2)?.toString())
            circular_text_view_four.setText(it.message?.get(3)?.toString())
        })

        submit_button.setOnClickListener {
            viewModel?.onButtonClick(submit_button.text.toString())
        }

        viewModel?.showProgressDialog?.observe(this, Observer {
            if (it) avi.show()
            else avi.hide()
        })

        viewModel?.errorMessage?.observe(this, Observer {

            Utility.showToast(activity, it)
        })

        viewModel?.oTPVerified?.observe(this, Observer {

            startActivity(Intent(activity, UserRegistrationActivity::class.java))
            activity?.finish()
        })


    }

    private fun editTextChangeListener() {
        circular_text_view_one.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length === 1) {
                    circular_text_view_two.requestFocus()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable) {}

        })


        circular_text_view_two.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable) {
                if (s.length === 1) {
                    circular_text_view_three.requestFocus()
                } else if (s.length === 0) {
                    circular_text_view_one.requestFocus()
                }
            }

        })

        circular_text_view_three.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable) {
                if (s.length === 1) {
                    circular_text_view_four.requestFocus()
                } else if (s.length === 0) {
                    circular_text_view_two.requestFocus()
                }
            }

        })

        circular_text_view_four.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable) {
                if (s.length === 1) {
                    circular_text_view_four.clearFocus()
                } else if (s.length === 0) {
                    circular_text_view_three.requestFocus()
                }
            }

        })
    }


    private fun initWidgit() {


    }
}