package com.sithuhein.mm.hanacodetest.domain.usecase

import com.sithuhein.mm.hanacodetest.domain.repository.MainRepository
import javax.inject.Inject


class MainUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    operator fun invoke() = mainRepository.mockedFetch()
}