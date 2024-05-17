package br.com.coletto.forum.service

import br.com.coletto.forum.dto.InputTopicoDTO
import br.com.coletto.forum.dto.OutputTopicoDTO
import br.com.coletto.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService) {

    fun listar(): List<OutputTopicoDTO> {
        return topicos.stream().map { t -> }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): OutputTopicoDTO {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return OutputTopicoDTO(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriacao = topico.dataCriacao,
            status = topico.status,
        )
    }

    fun cadastrar(topicoDTO: InputTopicoDTO) {

        topicos.plus(Topico(
            id = topicos.size.toLong() + 1,
            titulo = topicoDTO.titulo,
            mensagem = topicoDTO.mensagem,
            curso = cursoService.buscarPorId(topicoDTO.idCurso),
            autor = usuarioService.buscarPorId(topicoDTO.idAutor),
            )
        )
    }
}