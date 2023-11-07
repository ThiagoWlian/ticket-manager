package br.com.thiagowlian.TicketManager.service

import br.com.thiagowlian.TicketManager.model.User
import br.com.thiagowlian.TicketManager.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(var userRepository: UserRepository) : BaseService<User, Long> (userRepository) {
}