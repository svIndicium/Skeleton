package hu.indicium.dev.services.status

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.Get
import org.slf4j.LoggerFactory

@Controller("/status")
class StatusController {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Produces(MediaType.TEXT_PLAIN)
    @Get
    fun index(): String {
        return "OK"
    }

    @Error(global = true)
    fun handleError(request: HttpRequest<*>, throwable: Throwable?): HttpResponse<Unit> {
        logger.error("${request.methodName} ${request.path}:", throwable)
        return HttpResponse.serverError()
    }
}