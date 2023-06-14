package com.example.adv160420122week4.model

import com.google.gson.annotations.SerializedName

data class Student(
    var id:String?, //? agar bisa di isi null
    @SerializedName("student_name")
    var name:String?,
    @SerializedName("birth_of_date")
    var dob:String?,
    var phone:String?,
    @SerializedName("photo_url")
    var photoUrl:String?
)