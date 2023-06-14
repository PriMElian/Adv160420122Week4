package com.example.adv160420122week4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adv160420122week4.R
import com.example.adv160420122week4.databinding.FragmentStudentDetailBinding
import com.example.adv160420122week4.util.loadImage
import com.example.adv160420122week4.viewmodel.DetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_student_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater,
            R.layout.fragment_student_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(studentId)*/

        val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
        viewModel.fetch(studentId)

        observeViewModel()
    }

    private fun observeViewModel() {
        /*viewModel.studentLD.observe(viewLifecycleOwner, Observer { studentLD->
            val txtID = view?.findViewById<TextView>(R.id.txtID)
            val txtName = view?.findViewById<TextView>(R.id.txtName)
            val txtBod = view?.findViewById<TextView>(R.id.txtBod)
            val txtPhone = view?.findViewById<TextView>(R.id.txtPhone)
            val imgView = view?.findViewById<ImageView>(R.id.imageView2)
            val progressbar = view?.findViewById<ProgressBar>(R.id.progressBar2)
            val btnNotif = view?.findViewById<Button>(R.id.btnNotif)

            btnNotif?.setOnClickListener {
                Observable.timer(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Log.d("Messages", "five seconds")
                        MainActivity.showNotification(studentLD.name.toString(),
                            "A new notification created",
                            R.drawable.baseline_email_24)
                    }
            }


            txtID?.setText(studentLD.id)
            txtName?.setText(studentLD.name)
            txtBod?.setText(studentLD.dob)
            txtPhone?.setText(studentLD.phone)
            if (progressbar != null) {
                imgView?.loadImage(studentLD.photoUrl, progressbar)
            }
        })*/

        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
          dataBinding.student = it
        })
    }
}