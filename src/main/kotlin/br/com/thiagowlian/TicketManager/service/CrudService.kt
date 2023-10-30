package br.com.thiagowlian.TicketManager.service

interface CrudService <T, ID>{

    fun create(entity: T)

    fun find(id: ID)

    fun delete(id: ID)

    fun update(entity: T)
}