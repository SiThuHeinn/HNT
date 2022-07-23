package com.sithuhein.mm.hanacodetest.domain.usecase

import com.sithuhein.mm.hanacodetest.domain.repository.MainRepository
import javax.inject.Inject

class FetchResponseTwoFromCache @Inject constructor(
    private val repository: MainRepository

) {
}