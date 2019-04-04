package com.macsanityapps.capsl.navigation.gamelist


import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.macsanityapps.base.core.BaseFragment
import com.macsanityapps.capsl.BR
import com.macsanityapps.capsl.ClickListener
import com.macsanityapps.capsl.R
import com.macsanityapps.capsl.databinding.FragmentGameListBinding
import com.macsanityapps.capsl.domain.model.GameListResult
import com.macsanityapps.capsl.navigation.MainActivity
import me.tatarka.bindingcollectionadapter2.ItemBinding
import javax.inject.Inject


class GameListFragment : BaseFragment(), ClickListener<GameListResult> {

    @Inject
    lateinit var gameListViewModel: GameListViewModel

    override fun onStart() {
        super.onStart()

        (activity as MainActivity).setToolbarTitle("Choose a game")
        gameListViewModel.list()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        FragmentGameListBinding.inflate(inflater, container, false)
            .apply {
                state = this@GameListFragment.gameListViewModel.state
                gamelistbinding = ItemBinding
                    .of<GameListResult>(BR.game, R.layout.view_game_item)
                    .bindExtra(BR.listener, this@GameListFragment)
                executePendingBindings()
            }
            .root




    override fun onItemClick(t: GameListResult) {
        navController().navigate(GameListFragmentDirections.actionGameListFragmentToStageListFragment(t))
    }

}
