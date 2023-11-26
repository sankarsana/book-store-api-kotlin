package nrs.sankarsana.bookstore.util

import io.ktor.server.application.*
import io.ktor.util.pipeline.*
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.ktor.ext.getKoin

inline fun <reified T : Any> PipelineContext<Unit, ApplicationCall>.provide(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null,
): T {
    return application.getKoin().get<T>(qualifier, parameters)
}