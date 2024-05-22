package br.com.coletto.forum.service

import br.com.coletto.forum.model.Curso
import br.com.coletto.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.findById(id).orElseThrow { RuntimeException("Curso não encontrado") }
    }


}
