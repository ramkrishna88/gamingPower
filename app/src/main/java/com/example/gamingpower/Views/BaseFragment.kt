package com.example.gamingpower.Views

import androidx.fragment.app.Fragment
import com.example.gamingpower.ViewModel.GiveawaysViewModel
import com.example.gamingpower.adapter.GiveawayAdapter
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@AndroidEntryPoint
open class BaseFragment : Fragment() {
    protected val giveawaysViewModel: GiveawaysViewModel by sharedViewModel()

    protected val giveawaysAdapter by lazy {
        GiveawayAdapter()
    }
}
