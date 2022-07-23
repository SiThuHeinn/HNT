package com.sithuhein.mm.hanacodetest.presentation.ui.responseone

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sithuhein.mm.hanacodetest.R
import com.sithuhein.mm.hanacodetest.databinding.FragmentHomeBinding
import com.sithuhein.mm.hanacodetest.databinding.FragmentResponseOneBinding
import com.sithuhein.mm.hanacodetest.presentation.ui.MainViewModel
import com.sithuhein.mm.hanacodetest.presentation.util.UiState.Data
import com.sithuhein.mm.hanacodetest.presentation.util.UiState.Error
import com.sithuhein.mm.hanacodetest.presentation.util.UiState.Loading
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ResponseOneFragment : Fragment() {

    private var _binding: FragmentResponseOneBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: ResponseOneFragmentAdapter

    private val viewModel by viewModels<ResponseOneViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResponseOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ResponseOneFragmentAdapter()
        binding.responseOneRv.layoutManager = LinearLayoutManager(requireContext())
        binding.responseOneRv.adapter = adapter

        viewModel.fetchFromCache()

        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                when(state) {
                    is Loading -> {
                        binding.loading.visibility = View.VISIBLE
                    }

                    is Data -> {
                        state.data?.forEach {
                            Log.d("HanaCodeTest", "Fragment -> ${it.title}")
                        }
                        binding.loading.visibility = View.INVISIBLE
                        adapter.setList(state.data.orEmpty())
                    }

                    is Error -> {
                        binding.loading.visibility = View.INVISIBLE
                    }
                 }
            }
        }

        binding.btnHome.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}