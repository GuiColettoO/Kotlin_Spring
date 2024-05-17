package br.com.coletto.forum.mapper

import br.com.coletto.forum.dto.OutputTopicoDTO
import br.com.coletto.forum.model.Topico

class TopicoOutpuMapper: Mapper<Topico, OutputTopicoDTO> {

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