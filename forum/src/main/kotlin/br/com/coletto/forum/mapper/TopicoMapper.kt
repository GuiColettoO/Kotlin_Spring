package br.com.coletto.forum.mapper

import br.com.coletto.forum.dto.InputTopicoDTO
import br.com.coletto.forum.dto.OutputTopicoDTO
import br.com.coletto.forum.model.Topico
import br.com.coletto.forum.service.CursoService
import br.com.coletto.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoOutputMapper: Mapper<Topico, OutputTopicoDTO> {

    override fun map(t: Topico): OutputTopicoDTO {
        return OutputTopicoDTO(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status,
        )
    }
}

@Component
class TopicoInputMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
    ) : Mapper<InputTopicoDTO, Topico>{

    override fun map(t: InputTopicoDTO): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor),
        )
    }
}