package br.com.coletto.forum.dto

import br.com.coletto.forum.model.StatusTopico
import jakarta.validation.constraints.*
import java.time.LocalDateTime

data class InputTopicoDTO(

    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val titulo: String,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val mensagem: String,
    @field:NotNull
    val idCurso: Long,
    @field:NotNull
    val idAutor: Long,
)

data class OutputTopicoDTO(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime,
)

data class UpdateTopicoDTO(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val titulo: String,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val mensagem: String
)