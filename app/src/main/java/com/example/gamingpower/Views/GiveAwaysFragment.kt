package com.example.gamingpower.Views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamingpower.R
import com.example.gamingpower.Utils.GiveAwayState
import com.example.gamingpower.Utils.PlatformType
import com.example.gamingpower.databinding.FragmentGiveAwaysBinding

class GiveawaysFragment : BaseFragment() {

    private val binding by lazy{
        FragmentGiveAwaysBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.giveawaysRecycler.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = giveawaysAdapter
        }

        giveawaysViewModel.giveAway.observe(viewLifecycleOwner) { state ->
            when (state) {
                is GiveAwayState.LOADING -> {
                    Toast.makeText(requireContext(), "loading...", Toast.LENGTH_LONG).show()
                }
                is GiveAwayState.SUCCESS<*> -> {
                    val giveaways = state.GiveAwayItem as List<GiveAwayState>
                    giveawaysAdapter.setNewGiveaways(giveaways)
                }
                is GiveAwayState.ERROR -> {
                    Toast.makeText(
                        requireContext(),
                        state.error.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        giveawaysViewModel.getSortedGiveaways()

        binding.moveToPc.setOnClickListener {
            giveawaysViewModel.platform = PlatformType.PC
            findNavController().navigate(R.id.action_ps4GiveawaysFragment_to_PCGiveawaysFragment)
        }

        binding.moveToPs4.setOnClickListener {
            giveawaysViewModel.platform = PlatformType.PS4
            findNavController().navigate(R.id.action_giveawaysFragment_to_ps4GiveawaysFragment)
        }

        return binding.root
    }
}