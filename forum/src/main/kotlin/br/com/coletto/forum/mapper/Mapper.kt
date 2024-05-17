package br.com.coletto.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}
