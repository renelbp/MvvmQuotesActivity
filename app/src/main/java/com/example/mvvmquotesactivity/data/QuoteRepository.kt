package com.example.mvvmquotesactivity.data

import com.example.mvvmquotesactivity.data.model.QuoteModel
import com.example.mvvmquotesactivity.data.model.QuoteProvider
import com.example.mvvmquotesactivity.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()
    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quoteList = response
        return response
    }
}