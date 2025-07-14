package jam.personal_folio.user.dto;

public record UserSigninResponse(
        String message,
        String token
) {}