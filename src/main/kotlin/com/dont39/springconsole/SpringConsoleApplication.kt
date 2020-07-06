package com.dont39.springconsole

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
class SpringConsoleApplication

fun main(args: Array<String>) {
  runApplication<SpringConsoleApplication>(*args)
}
