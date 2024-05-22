package br.com.coletto.forum.service

import br.com.coletto.forum.model.Usuario
import br.com.coletto.forum.repository.TopicoRepository
import br.com.coletto.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (private val repository: UsuarioRepository) {


    fun buscarPorId(id: Long): Usuario {
        return repository.getOne(id)
    }
}
