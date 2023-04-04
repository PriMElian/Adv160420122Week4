package com.example.adv160420122week4.model

import com.google.gson.annotations.SerializedName

data class Student(
    val id:String?, //? agar bisa di isi null
    @SerializedName("student_name")
    val name:String?,
    @SerializedName("birth_of_date")
    val dob:String?,
    val phone:String?,
    @SerializedName("photo_url")
    val photoUrl:String?
)