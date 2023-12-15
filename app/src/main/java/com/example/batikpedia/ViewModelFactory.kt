package com.example.batikpedia

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.batikpedia.data.BatikRepository
import com.example.batikpedia.di.Injection
import com.example.batikpedia.ui.detection.DetectionViewModel

class ViewModelFactory(private val repository: BatikRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DetectionViewModel::class.java) -> {
                DetectionViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        @JvmStatic
        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository())
            }.also { instance = it }
    }
}