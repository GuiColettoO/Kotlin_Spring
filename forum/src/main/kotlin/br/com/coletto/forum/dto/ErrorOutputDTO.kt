package br.com.coletto.forum.dto

import java.time.LocalDateTime

data class ErrorOutputDTO(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)
