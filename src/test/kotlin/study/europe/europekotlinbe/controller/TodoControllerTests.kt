package study.europe.europekotlinbe.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import study.europe.europekotlinbe.entity.Todo
import study.europe.europekotlinbe.repository.TodoRepository

@WebMvcTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TodoControllerTests(@Autowired val mockMvc: MockMvc) {
    @MockBean lateinit var todoRepository:TodoRepository

    @BeforeAll
    fun setup() {
        Mockito.`when`(todoRepository.save(any<Todo>())).thenAnswer {
            i -> Todo(i.getArgument(0, Todo::class.java).title)
        }
    }

    @Test
    fun `create`() {
        val title = "test title"
        mockMvc.post("/todo") {
            contentType = MediaType.APPLICATION_JSON
            content = ObjectMapper().writeValueAsString((Todo(title)))
        }.andExpect {
            status { isOk }
            content { MockMvcResultMatchers.jsonPath("$.title").value(title)}
        }
    }
}