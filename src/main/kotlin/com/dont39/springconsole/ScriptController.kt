package com.dont39.springconsole

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @author sirius
 * @since 2020/07/06
 */
@RestController
@RequestMapping("script")
class ScriptController @Autowired constructor(
  private val kotlinScriptService: KotlinScriptService,
  private val groovyScriptService: GroovyScriptService
) {

  data class RunScriptRequest(
      val code: String
  )

  @PostMapping("kotlin")
  fun runKotlin(@RequestParam request: RunScriptRequest): String {
    return kotlinScriptService.execute(request.code)
  }

  @PostMapping("groovy")
  fun runGroovy(@RequestParam request: RunScriptRequest): String {
    return groovyScriptService.execute(request.code)
  }
}
