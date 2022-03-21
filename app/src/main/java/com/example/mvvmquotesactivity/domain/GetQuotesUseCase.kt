package com.example.mvvmquotesactivity.domain

import com.example.mvvmquotesactivity.data.QuoteRepository
import com.example.mvvmquotesactivity.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}