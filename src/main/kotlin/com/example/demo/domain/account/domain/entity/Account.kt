package com.example.demo.domain.account.domain.entity

import com.example.demo.domain.user.domain.entity.User
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*


@Entity
@Table
class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    val title: String,
    val description: String,
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User
) {
}