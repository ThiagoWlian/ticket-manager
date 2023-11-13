package br.com.thiagowlian.TicketManager.model

import jakarta.persistence.*

@Entity
@Table(name = "user_system")
data class User(
    @Column
    var name: String,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "responsible")
    var responsibleTickets: Set<Ticket>,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "creator")
    var creatorTickets: Set<Ticket>,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    )
