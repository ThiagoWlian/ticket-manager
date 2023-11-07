package br.com.thiagowlian.TicketManager.service

import br.com.thiagowlian.TicketManager.exception.ValueNotFoundException
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

abstract class BaseService <T, ID> (private var repository: JpaRepository<T, ID>){

    fun save(entity: T) {
        repository.save(entity)
    }

    fun findById(id: ID): T {
        var value: Optional<T> = repository.findById(id)
        if (value.isPresent)
            return value.get();
        else
            throw ValueNotFoundException("Não existe nenhum valor com o ID informado!")
    }

    fun findAll() {
        repository.findAll()
    }

    fun delete(id: ID) {
        repository.deleteById(id)
    }
}