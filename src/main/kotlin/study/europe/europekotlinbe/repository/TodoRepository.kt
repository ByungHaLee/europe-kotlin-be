package study.europe.europekotlinbe.repository

import org.springframework.data.repository.CrudRepository
import study.europe.europekotlinbe.entity.Todo

interface TodoRepository : CrudRepository<Todo, Long> {
}