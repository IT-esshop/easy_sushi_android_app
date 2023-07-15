package com.example.easysushi.domain.usecases

import com.example.easysushi.domain.model.Ware
import com.example.easysushi.domain.repository.WaresRepository

class GetAllWaresUseCase(
    private val repository: WaresRepository
) {

    operator fun invoke(): List<Ware>{
        return repository.getAllWares()
    }
}