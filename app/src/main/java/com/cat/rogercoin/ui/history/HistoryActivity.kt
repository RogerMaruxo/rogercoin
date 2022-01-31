package com.cat.rogercoin.ui.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.cat.rogercoin.core.extensions.createDialog
import com.cat.rogercoin.core.extensions.createProgressDialog
import com.cat.rogercoin.databinding.ActivityHistoryBinding
import com.cat.rogercoin.presentation.HistoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryActivity : AppCompatActivity () {

    private val viewModel by viewModel<HistoryViewModel>()
    private val adapter by lazy { HistoryListAdapter() }
    private val dialog by lazy { createProgressDialog() }
    private val binding by lazy { ActivityHistoryBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvHistory.adapter = adapter
        binding.rvHistory.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        )

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        bindObserve()

        lifecycle.addObserver(viewModel)
    }

    private fun bindObserve() {
        viewModel.state.observe(this) {
            when (it) {
                HistoryViewModel.State.Loading -> dialog.show()
                is HistoryViewModel.State.Error -> {
                    dialog.dismiss()
                    createDialog {
                        setMessage(it.error.message)
                    }.show()
                }
                is HistoryViewModel.State.Success -> {
                    dialog.dismiss()
                    adapter.submitList(it.list)
                }
            }
        }
    }
}