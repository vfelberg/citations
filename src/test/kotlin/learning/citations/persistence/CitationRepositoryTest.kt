package learning.citations.persistence

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.jdbc.JdbcTestUtils.deleteFromTables

@SpringBootTest
class CitationRepositoryTest @Autowired constructor(
    private val jdbcTemplate: JdbcTemplate,
    private val citationRepository: CitationRepository,
) {

    @BeforeEach
    fun cleanUp() {
        deleteFromTables(jdbcTemplate, "citation")
    }

    @Test
    fun testPersistence() {
        assertThat(citationRepository.findAll().size).isEqualTo(0)

        val text1 = "The greatest glory in living lies not in never falling, but in rising every time we fall."
        val author1 = "Nelson Mandela"

        val text2 = "The way to get started is to quit talking and begin doing."
        val author2 = "Walt Disney"

        val text3 = "Life is what happens when you're busy making other plans."
        val author3 = "John Lennon"

        jdbcTemplate.update("INSERT INTO citation(id, text, author) VALUES('1', ?, ?)", text1, author1)
        jdbcTemplate.update("INSERT INTO citation(id, text, author) VALUES('2', ?, ?)", text2, author2)
        jdbcTemplate.update("INSERT INTO citation(id, text, author) VALUES('3', ?, ?)", text3, author3)

        assertThat(citationRepository.findById("1")).hasValueSatisfying { citation ->
            assertThat(citation.text).isEqualTo(text1)
            assertThat(citation.author).isEqualTo(author1)
        }
        assertThat(citationRepository.findById("2")).hasValueSatisfying { citation ->
            assertThat(citation.text).isEqualTo(text2)
            assertThat(citation.author).isEqualTo(author2)
        }
        assertThat(citationRepository.findById("3")).hasValueSatisfying { citation ->
            assertThat(citation.text).isEqualTo(text3)
            assertThat(citation.author).isEqualTo(author3)
        }
    }
}