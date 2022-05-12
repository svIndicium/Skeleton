package hu.indicium.dev.services.mongodb

import com.fasterxml.jackson.databind.Module
import com.mongodb.MongoClientSettings
import com.mongodb.reactivestreams.client.MongoClient
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import org.bson.codecs.configuration.CodecRegistry
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.id.jackson.IdJacksonModule
import org.litote.kmongo.service.ClassMappingType
import org.litote.kmongo.util.CollectionNameFormatter

@Factory
class ClientFactory {

    init {
        CollectionNameFormatter.useLowerCaseCollectionNameBuilder()
    }

    @Singleton
    fun codecRegistry(): CodecRegistry = ClassMappingType.codecRegistry(MongoClientSettings.getDefaultCodecRegistry())

    @Singleton
    fun coroutineClient(client: MongoClient): CoroutineClient = client.coroutine

    @Singleton
    fun idJacksonModule(): Module = IdJacksonModule()
}