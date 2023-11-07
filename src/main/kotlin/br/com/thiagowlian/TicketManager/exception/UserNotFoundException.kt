package br.com.thiagowlian.TicketManager.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST, reason = "Não foi possível encontrar um usuário com esse ID!")
class UserNotFoundException(message: String) : Exception(message) {
}