package jam.personal_folio.user.dto;

public record UserSigninRequest(
        String email,
        String password
){}