package jam.personal_folio.user.controller;

import jam.personal_folio.user.dto.UserSignupRequest;
import jam.personal_folio.user.dto.UserSigninRequest;
import jam.personal_folio.user.dto.UserSigninResponse;메ㅑ
import jam.personal_folio.user.service.UserService;
import jam.personal_folio.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserSignupRequest request) {
        userService.signup(request);
        return new ResponseEntity<>("회원가입 성공!", HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<UserSigninResponse> signin(@RequestBody UserSigninRequest request) {
        String token = authService.signin(request);
        return ResponseEntity.ok(new UserSigninResponse("로그인 성공!", token));
    }
}
