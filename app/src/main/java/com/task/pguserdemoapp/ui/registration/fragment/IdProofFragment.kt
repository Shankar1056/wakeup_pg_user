package com.task.pguserdemoapp.ui.registration.fragment

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.FragmenrIdProofBinding
import com.task.pguserdemoapp.ui.registration.RegistrationViewModel
import kotlinx.android.synthetic.main.fragmenr_id_proof.*

class IdProofFragment : Fragment() {
    val REQUEST_IMAGE_CAPTURE = 1
    var idViewModel: RegistrationViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: FragmenrIdProofBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragmenr_id_proof, container, false)
        idViewModel = activity?.run {
            ViewModelProviders.of(this)[RegistrationViewModel::class.java]
        }
        binding.idproofViewModel = idViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image_outer.setOnClickListener {
            takePicture()
        }
    }

    private fun takePicture() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(activity!!.packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == AppCompatActivity.RESULT_OK) {
            val imageBitmap = data.extras?.get("data") as Bitmap
            image_outer.setImageBitmap(imageBitmap)
        }
    }
}