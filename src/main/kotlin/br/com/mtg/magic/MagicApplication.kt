package br.com.mtg.magic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MagicApplication

fun main(args: Array<String>) {
	runApplication<MagicApplication>(*args)
}
