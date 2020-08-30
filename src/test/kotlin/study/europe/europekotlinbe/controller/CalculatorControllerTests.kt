package study.europe.europekotlinbe.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest
class CalculatorControllerTests(@Autowired val mockMvc: MockMvc) {
    @Test
    fun `add`() {
        mockMvc.get("/calculator/add/1/2") {
        }.andExpect {
            content { string("3")}
        }
    }
    @Test
    fun `sub`() {
        mockMvc.get("/calculator/sub/2/1") {
        }.andExpect {
            content { string("1")}
        }
    }
    @Test
    fun `mul`() {
        mockMvc.get("/calculator/mul/4/2") {
        }.andExpect {
            content { string("8")}
        }
    }
    @Test
    fun `div`() {
        mockMvc.get("/calculator/div/12/3") {
        }.andExpect {
            content { string("4")}
        }
    }
}