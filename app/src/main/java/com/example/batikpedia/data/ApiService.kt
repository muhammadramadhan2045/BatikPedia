package com.example.batikpedia.data

import com.example.batikpedia.data.response.DetectionResponse
import com.example.batikpedia.data.response.FileUploadResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("stories/guest")
    suspend fun uploadImage(
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
    ): FileUploadResponse

    @Multipart
    @POST("/")
    suspend fun uploadDetection(
        @Part file: MultipartBody.Part,
    ):DetectionResponse


}