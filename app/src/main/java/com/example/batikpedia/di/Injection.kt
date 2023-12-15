package com.example.batikpedia.di

import com.example.batikpedia.data.ApiConfig
import com.example.batikpedia.data.BatikRepository

object Injection {
    fun provideRepository(): BatikRepository {
        val apiService = ApiConfig.getApiService()
        return BatikRepository.getInstance(apiService)
    }
}