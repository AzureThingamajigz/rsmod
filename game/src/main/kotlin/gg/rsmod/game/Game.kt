package gg.rsmod.game

import com.google.inject.Inject
import gg.rsmod.game.config.InternalConfig
import gg.rsmod.game.coroutine.GameCoroutineScope
import gg.rsmod.game.dispatch.GameJobDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed class GameState {
    object Inactive : GameState()
    object Active : GameState()
    object ShutDown : GameState()
}

class Game @Inject constructor(
    private val internalConfig: InternalConfig,
    private val coroutineScope: GameCoroutineScope,
    private val jobDispatcher: GameJobDispatcher
) {

    var state: GameState = GameState.Inactive

    fun start() {
        if (state != GameState.Inactive) {
            error("::start has already been called.")
        }
        val delay = internalConfig.gameTickDelay
        state = GameState.Active
        coroutineScope.start(delay.toLong())
    }

    private fun CoroutineScope.start(delay: Long) = launch {
        while (state != GameState.ShutDown) {
            jobDispatcher.executeAll()
            delay(delay)
        }
    }
}
