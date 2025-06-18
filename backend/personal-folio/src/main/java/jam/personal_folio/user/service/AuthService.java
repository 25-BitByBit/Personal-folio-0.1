package jam.personal_folio.user.service;

import jam.personal_folio.user.dto.UserSigninRequest;
import jam.personal_folio.user.entity.User;
import jam.personal_folio.user.vo.Email;
import jam.personal_folio.user.repository.UserRepository;
import jam.personal_folio.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    // 로그인 메서드
    public String signin(UserSigninRequest request) {
        String email = request.email();
        String rawPassword = request.password();

        // 1. 이메일로 사용자 조회
        User user = userRepository.findByEmail(new Email(email))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));

        // 2. 비밀번호 일치 확인
        if (!passwordEncoder.matches(rawPassword, user.getPassword().getValue())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 3. JWT 토큰 발급
        return jwtProvider.createToken(user);
    }
}
