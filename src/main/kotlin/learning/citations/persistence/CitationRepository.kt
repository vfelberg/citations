package learning.citations.persistence

import learning.citations.domain.Citation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CitationRepository : JpaRepository<Citation, String>