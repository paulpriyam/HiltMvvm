package com.example.hiltmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiltmvvm.R
import com.example.hiltmvvm.ui.adapter.RetroAdapter
import com.example.hiltmvvm.viewmodel.RetroViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RetroViewModel
    private lateinit var retroAdapter: RetroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(RetroViewModel::class.java)
        retroAdapter = RetroAdapter()
        rvRecords.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decorator =
                DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decorator)
            adapter = retroAdapter
        }

        viewModel.getAllRecords().observe(this) {
            retroAdapter.setData(it)
            retroAdapter.notifyDataSetChanged()
        }
        viewModel.makeApiCall()

    }
}