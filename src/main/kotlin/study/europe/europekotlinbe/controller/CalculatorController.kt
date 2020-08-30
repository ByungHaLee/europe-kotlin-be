package study.europe.europekotlinbe.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("calculator")
class CalculatorController {

    @GetMapping("add/{arg1}/{arg2}")
    fun add(@PathVariable arg1: Int, @PathVariable arg2: Int):Int = arg1 + arg2
}