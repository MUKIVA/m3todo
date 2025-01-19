package di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import presentation.DefaultRootComponent
import presentation.RootComponent

val commonModule = module {

    singleOf(::DefaultRootComponent) { bind<RootComponent>() }

}