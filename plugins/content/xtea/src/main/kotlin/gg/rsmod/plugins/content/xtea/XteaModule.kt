package gg.rsmod.plugins.content.xtea

import com.google.inject.Scope
import dev.misfitlabs.kotlinguice4.KotlinModule
import gg.rsmod.game.model.domain.repo.XteaRepository

class XteaModule(private val scope: Scope) : KotlinModule() {

    override fun configure() {
        bind<XteaRepository>()
            .to<XteaInMemoryRepository>()
            .`in`(scope)
    }
}
