package com.sithuhein.mm.hanacodetest.presentation.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.sithuhein.mm.hanacodetest.R
import com.sithuhein.mm.hanacodetest.databinding.FragmentHomeBinding
import com.sithuhein.mm.hanacodetest.presentation.ui.responseone.ResponseOneViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnShowData1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment2_to_responseOneFragment)
        }

        binding.btnDownloadData1.setOnClickListener {
            Snackbar.make(view, "Clicked", Snackbar.LENGTH_LONG).show()

            viewModel.fetch()
        }


        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                if (it.isNotEmpty()) {
                    Snackbar.make(view, "Success $it", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}