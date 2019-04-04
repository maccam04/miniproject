package com.macsanityapps.capsl.navigation.stagelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.macsanityapps.base.core.BaseFragment
import com.macsanityapps.capsl.BR
import com.macsanityapps.capsl.ClickListener
import com.macsanityapps.capsl.R
import com.macsanityapps.capsl.databinding.FragmentStageListBinding
import com.macsanityapps.capsl.domain.model.StageListResult
import com.macsanityapps.capsl.navigation.MainActivity
import me.tatarka.bindingcollectionadapter2.ItemBinding
import javax.inject.Inject


class StageListFragment : BaseFragment(), ClickListener<StageListResult> {

    @Inject
    lateinit var stageListViewModel: StageListViewModel

    override fun onStart() {
        super.onStart()

        (activity as MainActivity).setToolbarTitle("Add Tournament information")

        stageListViewModel.list()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        FragmentStageListBinding.inflate(inflater, container, false)
            .apply {
                state = this@StageListFragment.stageListViewModel.state
                stagelistbinding = ItemBinding
                    .of<StageListResult>(BR.stage, R.layout.view_stage_item)
                    .bindExtra(BR.listener, this@StageListFragment)
                executePendingBindings()
            }
            .root

    override fun onItemClick(t: StageListResult) {

    }

}
