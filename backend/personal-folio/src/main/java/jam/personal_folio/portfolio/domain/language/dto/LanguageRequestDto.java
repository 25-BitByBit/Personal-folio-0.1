package jam.personal_folio.portfolio.domain.language.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.language.entity.Language;
import jam.personal_folio.portfolio.domain.language.entity.LanguageType;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageRequestDto {
    @Schema(description = "언어", example = "ENGLISH")
    private int languageType;

    @Schema(description = "시험명", example = "TOEIC")
    private String examName;

    @Schema(description = "급수", example = "없음")
    private String grade;

    @Schema(description = "점수", example = "850")
    private String score;

    @Schema(description = "취득일", example = "2025-06-21")
    private LocalDate issuedDate;

    public Language toEntity() {
        return Language.builder()
                .languageType(LanguageType.fromCode(languageType))
                .examName(examName)
                .grade(grade)
                .score(score)
                .issuedDate(issuedDate)
                .build();
    }
}
