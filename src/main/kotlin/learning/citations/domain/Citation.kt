package learning.citations.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "citation")
class Citation(
    val text: String,
    val author: String = "UNKNOWN"
) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null
}