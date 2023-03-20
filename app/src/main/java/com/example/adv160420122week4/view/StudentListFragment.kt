package com.example.adv160420122week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160420122week4.R
import com.example.adv160420122week4.viewmodel.ListViewModel

class StudentListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val studentListAdapter = StudentListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_list, container, false)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        val recView = view?.findViewById<RecyclerView>(R.id.recView)
        recView?.layoutManager = LinearLayoutManager(context)
        recView?.adapter = studentListAdapter

        observeViewModel()
    }

    fun observeViewModel() {
        //function 1, yaitu ketika dengan melakukan observation
        viewModel.studentsLD.observe(viewLifecycleOwner, Observer {
            studentListAdapter.updateStudentList(it)
        })

        //function 2, yaitu ketika terjadi error
        viewModel.studentLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtError = view?.findViewById<TextView>(R.id.txtError)
            if(it == true) {
                txtError?.visibility = View.VISIBLE
            } else {
                txtError?.visibility = View.GONE
            }
        })

        //function 3, yaitu ketika sedang proses mengupdate data
        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoad)
            val recView = view?.findViewById<RecyclerView>(R.id.recView)
            if(it == true) {
                recView?.visibility = View.GONE
                progressLoad?.visibility = View.VISIBLE
            } else {
                recView?.visibility = View.VISIBLE
                progressLoad?.visibility = View.GONE
            }
        })
    }
}