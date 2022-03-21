package com.example.mvvmquotesactivity.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmquotesactivity.data.model.QuoteModel
import com.example.mvvmquotesactivity.data.model.QuoteProvider
import com.example.mvvmquotesactivity.domain.GetQuotesUseCase
import com.example.mvvmquotesactivity.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel:ViewModel() {

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCases = GetRandomQuoteUseCase()
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCases()
        if (quote != null){
            quoteModel.postValue(quote!!)
        }
        isLoading.postValue(false)
    }


    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }


}