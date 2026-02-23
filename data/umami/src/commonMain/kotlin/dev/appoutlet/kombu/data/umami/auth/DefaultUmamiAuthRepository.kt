package dev.appoutlet.kombu.data.umami.auth

import dev.appoutlet.umami.api.Auth
import dev.appoutlet.umami.domain.User
import org.koin.core.annotation.Single

@Single
internal class DefaultUmamiAuthRepository(private val umamiAuth: Auth) : UmamiAuthRepository {
    override suspend fun login(username: String, password: String): User {
        return umamiAuth.login(username, password).user
    }
}
