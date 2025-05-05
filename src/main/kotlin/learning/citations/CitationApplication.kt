package learning.citations

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CitationApplication

fun main(args: Array<String>) {
    runApplication<CitationApplication>(*args)
}