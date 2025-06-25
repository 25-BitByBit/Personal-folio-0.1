package jam.personal_folio.user.repository;

import jam.personal_folio.user.entity.User;
import jam.personal_folio.user.vo.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(Email email); // Email 객체를 기반으로 조회
    boolean existsByEmail(Email email);
}
