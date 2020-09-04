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

    @GetMapping("sub/{arg1}/{arg2}")
    fun sub(@PathVariable arg1: Int, @PathVariable arg2: Int):Int = arg1 - arg2

    @GetMapping("mul/{arg1}/{arg2}")
    fun mul(@PathVariable arg1: Int, @PathVariable arg2: Int):Int = arg1 * arg2

    @GetMapping("div/{arg1}/{arg2}")
    fun div(@PathVariable arg1: Int, @PathVariable arg2: Int):Int = arg1 / arg2
}