package hu.indicium.dev.services

import kotlin.jvm.JvmStatic
import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
            .packages("hu.indicium.dev")
            .mainClass(Application.javaClass)
            .start()
    }
}