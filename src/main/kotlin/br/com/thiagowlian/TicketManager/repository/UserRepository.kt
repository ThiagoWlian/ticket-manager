package br.com.thiagowlian.TicketManager.repository

import br.com.thiagowlian.TicketManager.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}