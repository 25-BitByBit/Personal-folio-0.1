package jam.personal_folio.portfolio.domain.language.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.language.entity.Language;
import jam.personal_folio.portfolio.domain.language.entity.LanguageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageResponseDto {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "언어", example = "ENGLISH")
    private LanguageType languageType;

    @Schema(description = "시험명", example = "TOEIC")
    private String examName;

    @Schema(description = "급수", example = "없음")
    private String grade;

    @Schema(description = "점수", example = "850")
    private String score;

    @Schema(description = "취득일", example = "2024-06-21")
    private LocalDate issuedDate;

    public static LanguageResponseDto from(Language entity) {
        return LanguageResponseDto.builder()
                .id(entity.getId())
                .languageType(entity.getLanguageType())
                .examName(entity.getExamName())
                .grade(entity.getGrade())
                .score(entity.getScore())
                .issuedDate(entity.getIssuedDate())
                .build();
    }
}
