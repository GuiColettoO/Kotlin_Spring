package br.com.coletto.forum.controller

import br.com.coletto.forum.dto.InputTopicoDTO
import br.com.coletto.forum.dto.OutputTopicoDTO
import br.com.coletto.forum.model.Topico
import br.com.coletto.forum.service.TopicoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar():List<OutputTopicoDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): OutputTopicoDTO{
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody topicoDTO: InputTopicoDTO) {
        service.cadastrar(topicoDTO)
    }
}