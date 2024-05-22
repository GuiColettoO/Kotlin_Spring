package br.com.coletto.forum.service

import br.com.coletto.forum.dto.*
import br.com.coletto.forum.exception.NotFoundException
import br.com.coletto.forum.mapper.TopicoInputMapper
import br.com.coletto.forum.mapper.TopicoOutputMapper
import br.com.coletto.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
  private val repository: TopicoRepository,
  private val topicoOutputMapper: TopicoOutputMapper,
  private val topicoInputMapper: TopicoInputMapper,
  private val notFoundMessage: String = "Topico não encontrado!")
{

  fun listar(
    nomeCurso: String?,
    paginacao: Pageable
  ): Page<OutputTopicoDTO> {
    val topicos = if (nomeCurso == null) {
      repository.findAll(paginacao)
    }else {
      repository.findByCursoNome(nomeCurso, paginacao)
    }
    return topicos.map {t -> topicoOutputMapper.map(t)}
  }

  fun buscarPorId(id: Long): OutputTopicoDTO {
    val topico = repository.findById(id)
      .orElseThrow{NotFoundException(notFoundMessage)}
    return topicoOutputMapper.map(topico)
  }

  fun cadastrar(form: InputTopicoDTO): OutputTopicoDTO {
    val topico = topicoInputMapper.map(form)
    repository.save(topico)
    return topicoOutputMapper.map(topico)
  }

  fun atualizar(form: UpdateTopicoDTO): OutputTopicoDTO {
    val topico = repository.findById(form.id)
      .orElseThrow{NotFoundException(notFoundMessage)}
    topico.titulo = form.titulo
    topico.mensagem = form.mensagem
    return topicoOutputMapper.map(topico)
  }

  fun deletar(id: Long) {
    repository.deleteById(id)
  }

  fun relatorio(): List<TopicoPorCategoriaDTO> {
    return repository.relatorio()
  }
}