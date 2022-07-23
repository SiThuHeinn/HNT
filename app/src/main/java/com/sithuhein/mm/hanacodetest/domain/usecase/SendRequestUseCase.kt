package com.sithuhein.mm.hanacodetest.domain.usecase

import com.sithuhein.mm.hanacodetest.domain.model.SendRequest
import com.sithuhein.mm.hanacodetest.domain.repository.MainRepository
import javax.inject.Inject

class SendRequestUseCase @Inject constructor(
    private val repository: MainRepository
) {

    operator fun invoke(request: SendRequest) = repository.sendRequest(request)
}