package jam.personal_folio.user.dto;

public record UserSignupRequest(
        String email,
        String password,
        String name,
        String phoneNumber,
        Integer careerYear
) {}
