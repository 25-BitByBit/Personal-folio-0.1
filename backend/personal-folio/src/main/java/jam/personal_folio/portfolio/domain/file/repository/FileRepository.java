package jam.personal_folio.portfolio.domain.file.repository;

import jam.personal_folio.portfolio.domain.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
