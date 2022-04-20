package com.example.gamingpower.Views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamingpower.Model.GiveAwayItem
import com.example.gamingpower.Utils.GiveAwayState
import com.example.gamingpower.databinding.FragmentPcGiveAwayBinding

class PCGiveawaysFragment : BaseFragment() {

    private val binding by lazy {
        FragmentPcGiveAwayBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.pcGiveawaysRv.apply {
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
                    val giveaways = state.GiveAwayItem as List<GiveAwayItem>
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

        giveawaysViewModel.getGiveawaysByPlatform()

        return binding.root
    }
}