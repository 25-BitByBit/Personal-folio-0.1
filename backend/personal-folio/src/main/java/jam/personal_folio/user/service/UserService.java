package jam.personal_folio.user.service;

import jam.personal_folio.user.dto.UserSignupRequest;
import jam.personal_folio.user.entity.User;
import jam.personal_folio.user.repository.UserRepository;
import jam.personal_folio.user.vo.Email;
import jam.personal_folio.user.vo.Password;
import jam.personal_folio.user.vo.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(UserSignupRequest request) {
        Email email = new Email(request.email());

        // 중복 검사
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        Password password = new Password(passwordEncoder.encode(request.password()));
        String name = request.name();
        PhoneNumber phoneNumber = new PhoneNumber(request.phoneNumber());
        Integer careerYear = request.careerYear();

        User user = new User(
                email,
                false,
                password,
                name,
                phoneNumber,
                false,
                careerYear
        );

        userRepository.save(user);
    }
}
