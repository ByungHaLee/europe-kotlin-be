package study.europe.europekotlinbe.repository

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import study.europe.europekotlinbe.entity.Todo

@DataJpaTest
class TodoRepositoryTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val todoRepository: TodoRepository){

    @Test
    fun `Create a todo`() {
        val todo = Todo("test todo")
        todoRepository.save(todo)
        val found = todoRepository.findAll().toList()
        assertThat(found[0].title).isEqualTo(todo.title)
    }

    @Test
    fun `Find all todos`() {
        val todo1 = Todo("toto1")
        entityManager.persist(todo1)
        val todo2 = Todo("toto2")
        entityManager.persist(todo2)
        entityManager.flush()
        val found = todoRepository.findAll().toList()
        assertThat(found.size).isEqualTo(2)
    }

    @Test
    fun `Find a todo`() {
        val todo1 = Todo("toto1")
        entityManager.persist(todo1)
        entityManager.flush()
        val found = todoRepository.findAll().toList()
        assertThat(found.size).isEqualTo(1)
        val todo = found[0]
        val foundTodo = todoRepository.findById(todo.id!!).orElse(null)
        assertThat(foundTodo?.title).isEqualTo(todo.title)
    }

    @Test
    fun `Delete a todo`() {
        val todo1 = Todo("toto1")
        entityManager.persist(todo1)
        entityManager.flush()
        val found = todoRepository.findAll().toList()
        assertThat(found.size).isEqualTo(1)
        val todo = found[0]
        todoRepository.deleteById(todo.id!!)
        val foundTodo = todoRepository.findById(todo.id!!).orElse(null)
        assertThat(foundTodo).isNull()
    }

    @Test
    fun `Update a todo`() {
        val todo1 = Todo("toto1")
        val updateTitle = "changed todo"
        entityManager.persist(todo1)
        entityManager.flush()
        val found = todoRepository.findAll().toList()[0]
        found.title = updateTitle
        todoRepository.save(found)
        val updatedTodo = todoRepository.findById(found.id!!).orElse(null)!!
        assertThat(updatedTodo.title).isEqualTo(updateTitle)

    }
}