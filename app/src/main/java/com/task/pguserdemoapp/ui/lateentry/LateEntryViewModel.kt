package com.task.pguserdemoapp.ui.lateentry

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.task.pguserdemoapp.R

class LateEntryViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var switchLateEntry = MutableLiveData<Boolean>()
    var switchMyLog = MutableLiveData<Boolean>()
    var myLogsVisibility = MutableLiveData<Boolean>()
    var newEntryVisibility = MutableLiveData<Boolean>()
    var sendButtonEnable = MutableLiveData<Boolean>()
    var sendButtonClicked = MutableLiveData<Boolean>()
    var reasonForDelay = MutableLiveData<String>()

//    var propertyChangedCallback = object: Observable.OnPropertyChangedCallback (){
//        override fun onPropertyChanged(observable: Observable, id: Int){
//            if(reasonForDelay.equals("")){
//                sendButtonEnable.value = false
//            }else{
//                sendButtonEnable.value = true
//            }
//        }
//    }

    init {
        myLogsVisibility.value = true
        sendButtonEnable.value = true


    }

    fun onNewTabClicked(view: View) {
        switchLateEntry.value = true
        myLogsVisibility.value = false
        newEntryVisibility.value = true
    }

    fun onMyLogClicked(view: View){
        switchMyLog.value = true
        myLogsVisibility.value = true
        newEntryVisibility.value = false
    }

    fun onSendClicked(view: View){
       sendButtonClicked.value = true
    }

    fun getReason(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
               // reasonForDelay.addOnPropertyChangedCallback(propertyChangedCallback)
               // sendButtonEnable.postValue(true)
                //sendButtonEnable.postValue()
            }
        }
    }
}

