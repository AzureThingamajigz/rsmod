package gg.rsmod.game

import com.google.inject.Scope
import dev.misfitlabs.kotlinguice4.KotlinModule
import gg.rsmod.game.action.ActionBus
import gg.rsmod.game.event.EventBus
import gg.rsmod.game.model.client.ClientList
import gg.rsmod.game.model.map.MapIsolation
import gg.rsmod.game.model.mob.NpcList
import gg.rsmod.game.model.mob.PlayerList
import gg.rsmod.game.update.mask.UpdateMaskHandlerMap
import gg.rsmod.game.update.task.UpdateTaskList

class GameModule(private val scope: Scope) : KotlinModule() {

    override fun configure() {
        bind<Game>()
            .`in`(scope)

        bind<EventBus>()
            .`in`(scope)

        bind<ActionBus>()
            .`in`(scope)

        bind<PlayerList>()
            .`in`(scope)

        bind<ClientList>()
            .`in`(scope)

        bind<NpcList>()
            .`in`(scope)

        bind<UpdateTaskList>()
            .`in`(scope)

        bind<UpdateMaskHandlerMap>()
            .`in`(scope)

        bind<MapIsolation>()
            .`in`(scope)
    }
}
