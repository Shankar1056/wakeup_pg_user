package com.task.pguserdemoapp.ui.registration

import android.app.Application
import android.app.DatePickerDialog
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

import com.task.pguserdemoapp.MyApplication
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.utilz.Utility
import com.task.pguserdemoapp.utilz.network.ApiCallback

import java.util.*


class RegistrationViewModel(val app: Application) : AndroidViewModel(app) {

    var switchBasicInfo = MutableLiveData<Boolean>()
    var switchEmergency = MutableLiveData<Boolean>()
    var switchIdProofPage = MutableLiveData<Boolean>()
    var switchFIngetPage = MutableLiveData<Boolean>()

    var switchHOmePage = MutableLiveData<Boolean>()
    var completionPercentage = MutableLiveData<String>()

    var selectedDate = MutableLiveData<String>()
    var dob = MutableLiveData<String>()
    var doj = MutableLiveData<String>()

    var inputErrorMessage = MutableLiveData<String>()

    var showProgressDialog = MutableLiveData<Boolean>()

    var model = RegisrationDataModel()
    var regisModel = RegistrationModel()
    var onResponse = MutableLiveData<RegistrationModel>()
    var regisrationDataModel = MutableLiveData<RegisrationDataModel>()
    var onResponseMessage = MutableLiveData<String>()
    var clickedCount = MutableLiveData<Int>()


    fun onBasicInfoClicked(view: View) {

        switchBasicInfo.value = true
        clickedCount.value = 1
        completionPercentage.value = ""
    }

    fun onEmergencyInfoClicked(view: View) {

        switchEmergency.value = true
        clickedCount.value = 2
        completionPercentage.value = "25% completed"
    }

    fun onIdProofClicked(view: View) {

        switchIdProofPage.value = true

        clickedCount.value = 3
        completionPercentage.value = "50% completed"

    }

    fun onFingerPrintClicked(view: View) {

        switchFIngetPage.value = true
        clickedCount.value = 4
        completionPercentage.value = "75% completed"

    }

    fun onBasicButtonClicked(view: View) {
        showProgressDialog.value = true
        model.pg_id = 1
        if (model.name?.isEmpty()!!) {
            inputErrorMessage.value = app.resources.getString(R.string.title_error_name)
        } else if (model.date_of_birth?.isEmpty()!!) {
            inputErrorMessage.value = app.resources.getString(R.string.title_error_dob)
        } else if (model.mobile?.isEmpty()!!) {
            inputErrorMessage.value = app.resources.getString(R.string.title_error_mobile)
        } else if (model.mobile?.length!! < 10) {
            inputErrorMessage.value = app.resources.getString(R.string.title_incorrect_mobile)
        } else if (model.email_id?.isEmpty()!!) {
            inputErrorMessage.value = app.resources.getString(R.string.title_error_email)
        } else if (!Utility.isValidEmail1(model.email_id)) {
            inputErrorMessage.value = app.resources.getString(R.string.title_incorrect_email)
        } else if (model.joining_date?.isEmpty()!!) {
            inputErrorMessage.value = app.resources.getString(R.string.title_error_joining_date)
        } else {

            if (MyApplication.getInstance().networkStateMonitor.isUp) {
                regisModel.basicRegister(model, object : ApiCallback() {
                    override fun onSuccess(obj: Any?) {
                        onResponse.value = obj as RegistrationModel
                        if (obj.status!!) {
                            regisrationDataModel.value = obj.response!![0]
                            switchEmergency.value = true
                        } else {
                            onResponseMessage.value = obj.message
                        }
                        showProgressDialog.value = false
                    }

                    override fun onHandledError() {
                        showProgressDialog.value = false
                    }
                })
            } else {
                showProgressDialog.value = false
                TODO()
            }
        }

    }

    fun onEmergencyClicked(view: View) {
        switchHOmePage.value = true
        clickedCount.value = 2

    }


    fun getaadhar(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                // viewModel?._phone = (editable.toString())
            }
        }
    }

    fun onCompleteClicked(view: View) {

    }


    fun getDate(view: View) {
        var c = Calendar.getInstance()
        var mYear = c.get(Calendar.YEAR)
        var mMonth = c.get(Calendar.MONTH)
        var mDay = c.get(Calendar.DAY_OF_MONTH)

        var datePickerDialog =
            DatePickerDialog(
                getApplication<Application>().applicationContext,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                }, mYear, mMonth, mDay
            )
        datePickerDialog.show()
    }

    fun getName(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                model.name = editable.toString()
            }
        }
    }


    fun getMobile(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                model.mobile = editable.toString()
            }
        }
    }

    fun getNmbrtWhatsApp(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                model.alternate_number = editable.toString()
            }
        }
    }

    fun getEmail(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                model.email_id = editable.toString()
            }
        }
    }

    fun getInstituteName(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                model.institute_office_name = editable.toString()
            }
        }
    }

    fun getInstituteArea(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                model.institute_office_location = editable.toString()
            }
        }
    }

    fun getIdCardNumber(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                model.id_card = editable.toString()
            }
        }
    }


    fun getDateCalender(isDOB: Boolean, context: Context) {
        val c = Calendar.getInstance()
        var mYear = c.get(Calendar.YEAR)
        var mMonth = c.get(Calendar.MONTH)
        var mDay = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            context,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                if (isDOB) {
                    dob.value = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    model.date_of_birth =
                        (year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth.toString())
                } else {
                    doj.value = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    model.joining_date =
                        (year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth.toString())
                }
            }, mYear, mMonth, mDay
        )
        datePickerDialog.show()
    }


}