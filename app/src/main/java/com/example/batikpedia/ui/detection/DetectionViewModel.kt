package com.example.batikpedia.ui.detection

import androidx.lifecycle.ViewModel
import com.example.batikpedia.data.BatikRepository
import java.io.File

class DetectionViewModel(private val repository: BatikRepository): ViewModel()  {
    fun uploadImage(file: File, description: String) = repository.uploadImage(file, description)

    fun detectionImage(file: File) = repository.detectionImage(file)
}
