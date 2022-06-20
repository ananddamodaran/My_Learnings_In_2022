package dev.anand.dagger_hilt_pg.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}