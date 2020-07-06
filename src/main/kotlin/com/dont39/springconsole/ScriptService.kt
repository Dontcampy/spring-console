package com.dont39.springconsole

import com.dont39.springconsole.ScriptService.Companion.CONTEXT_VAR_NAME
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import javax.script.ScriptEngineManager

/**
 * @author sirius
 * @since 2020/07/06
 */
interface ScriptService {
  companion object {
    const val CONTEXT_VAR_NAME = "context"
  }

  fun execute(scriptText: String): String
}

@Service
class KotlinScriptService @Autowired constructor(
  private val applicationContext: ApplicationContext
) : ScriptService {

  private val logger = LoggerFactory.getLogger(javaClass)

  private val kotlinScriptEngine = ScriptEngineManager().getEngineByExtension("kts").apply {
    put(CONTEXT_VAR_NAME, applicationContext)
  }

  override fun execute(scriptText: String): String {
    logger.info("Executing kotlin script:\n$scriptText")
    return kotlinScriptEngine.eval(scriptText).toString()
  }
}

@Service
class GroovyScriptService @Autowired constructor(
    private val applicationContext: ApplicationContext
) : ScriptService {
  private val logger = LoggerFactory.getLogger(javaClass)

  private val groovyScriptEngine = ScriptEngineManager().getEngineByName("groovy").apply {
    put(CONTEXT_VAR_NAME, applicationContext)
  }

  override fun execute(scriptText: String): String {
    logger.info("Executing kotlin script:\n$scriptText")
    return groovyScriptEngine.eval(scriptText).toString()
  }
}
