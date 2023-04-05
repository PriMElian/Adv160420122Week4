package com.example.adv160420122week4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.adv160420122week4.model.Student
import com.google.gson.Gson

/*class DetailViewModel:ViewModel() {*/
class DetailViewModel(application: Application):
    AndroidViewModel(application) {
    val studentLD = MutableLiveData<Student>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch(studentId: String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id=$studentId"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val result = Gson().fromJson<Student>(response, Student::class.java)
                studentLD.value = result
                Log.d("showvolley", response.toString())
            },
            {
                Log.d("showvoley", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

        /*val student1 = Student("16055","Nonie","1998/03/28","5718444778",
            "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        studentLD.value = student1*/
    }
}