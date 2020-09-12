package study.europe.europekotlinbe.controller

import org.springframework.web.bind.annotation.*
import study.europe.europekotlinbe.entity.Todo
import study.europe.europekotlinbe.repository.TodoRepository

@RestController
@RequestMapping("todo")
class TodoController (private val todoRepository: TodoRepository) {

    @GetMapping("")
    fun readAll(): List<Todo> = todoRepository.findAll().toList()

    @GetMapping("{id}")
    fun read(@PathVariable id:Long): Todo? = todoRepository.findById(id).orElse(null)

    @PostMapping("")
    fun create(@RequestBody todoMap: Map<String, Object>): Todo {
        val tt = todoMap.get("title")
        val title = tt.toString()
        return todoRepository.save(Todo(title))
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:Long) = todoRepository.deleteById(id)

    @PutMapping("{id}")
    fun update(@PathVariable id:Long, @RequestBody todoMap: Map<String, Object>): Todo {
        val todo :Todo = todoRepository.findById(id).orElseThrow{IllegalArgumentException()}
        todo.title = todoMap.get("title").toString()
        return todoRepository.save(todo)
    }

}