package com.sithuhein.mm.hanacodetest.domain.usecase

import com.sithuhein.mm.hanacodetest.domain.repository.MainRepository
import javax.inject.Inject

class FetchResponseOneUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    suspend operator fun invoke() = mainRepository.fetchResponseOneData()
}