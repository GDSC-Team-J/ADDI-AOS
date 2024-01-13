package com.gdsc.addi.ui.utils

import android.net.Uri
import android.util.Log
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

object MultipartExt {
    fun convertToMultipartText(content: String): RequestBody {
        Log.d("multipart", "convertToMultipartText 들어옴")
        return content.toRequestBody("text/plain".toMediaTypeOrNull())
    }

    fun convertToMultiPartFile(image: Uri): MultipartBody.Part {
        Log.d("multipart", "convertToMultiPartFile 들어옴")
        val file = File(image.path)
        val imageRequestBody = file.asRequestBody("audio/*".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData("files", file.name, imageRequestBody)
    }
}