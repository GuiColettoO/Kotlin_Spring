package br.com.coletto.forum.dto

import br.com.coletto.forum.model.StatusTopico
import java.time.LocalDateTime

data class InputTopicoDTO(
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long,
)

data class OutputTopicoDTO(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime,
)
