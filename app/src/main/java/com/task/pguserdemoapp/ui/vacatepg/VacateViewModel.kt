package com.task.pguserdemoapp.ui.vacatepg

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VacateViewModel : ViewModel() {
    var resolvedVisibility = MutableLiveData<Boolean>()
    var unresolvedVisibility = MutableLiveData<Boolean>()
    var registerVisibility = MutableLiveData<Boolean>()
    var logsVisibility = MutableLiveData<Boolean>()
    var complaintVisibility = MutableLiveData<Boolean>()
    var complaintFrameVisibility = MutableLiveData<Boolean>()

    var switchResolved = MutableLiveData<Boolean>()
    var switchUnresolved = MutableLiveData<Boolean>()
    var switchRegister = MutableLiveData<Boolean>()
    var switchVisitorLog = MutableLiveData<Boolean>()
    var switchTocomplainScreen = MutableLiveData<Boolean>()
    var switchtoUnresolvedDetailScreen = MutableLiveData<Boolean>()

    var sendVacateInfoClicked = MutableLiveData<Boolean>()
    var intimateClicked = MutableLiveData<Boolean>()

    var changeGridSubItem = MutableLiveData<Boolean>()

    init {
        complaintVisibility.value= true
        unresolvedVisibility.value = true
        resolvedVisibility.value = false
        complaintFrameVisibility.value = false
        changeGridSubItem.value = false
        registerVisibility.value = true
        logsVisibility.value = false
    }

    fun onUnresolvedClicked(view: View){
        complaintVisibility.value= true
        unresolvedVisibility.value = true
        resolvedVisibility.value = false
        switchUnresolved.value = true
        complaintFrameVisibility.value = false

    }

    fun onResolvedClicked(view: View){
        unresolvedVisibility.value = false
        resolvedVisibility.value = true
        complaintVisibility.value= true
        switchResolved.value = true
        complaintFrameVisibility.value = false
    }

    fun onRegisterClicked(view: View){
        registerVisibility.value = true
        logsVisibility.value = false
        switchRegister.value = true
    }

    fun onLogsClicked(view: View){
        registerVisibility.value = false
        logsVisibility.value = true
        switchVisitorLog.value = true
    }

    fun onFloatingButtonClicked(view: View){
        complaintVisibility.value= false
        complaintFrameVisibility.value = true
        switchTocomplainScreen.value = true
    }

    fun onGridViewClicked(view: View){
        changeGridSubItem.value = true
    }

    fun onVacateInfoSendClicked(view: View){
        sendVacateInfoClicked.value = true
    }

    fun onIntimateClicked(view: View){
        intimateClicked.value = true
    }
}