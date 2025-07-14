package jam.personal_folio.portfolio.domain.file.dto;

public record FileSaveDto(
        String fileName,
        String s3Key,
        String fileUrl
) {}

