package dev.appoutlet.kombu.data.umami.auth

import dev.appoutlet.umami.domain.User

interface UmamiAuthRepository {
    suspend fun login(username: String, password: String): User
}
