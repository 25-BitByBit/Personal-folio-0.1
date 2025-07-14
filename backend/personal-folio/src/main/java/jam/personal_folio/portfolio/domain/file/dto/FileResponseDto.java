package jam.personal_folio.portfolio.domain.file.dto;

public record FileResponseDto(
        Long id,
        String fileName,
        String s3Key,
        String fileUrl
) {}
