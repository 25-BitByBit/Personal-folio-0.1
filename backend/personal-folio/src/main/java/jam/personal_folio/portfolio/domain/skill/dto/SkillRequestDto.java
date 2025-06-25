package jam.personal_folio.portfolio.domain.skill.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillRequestDto {
    @Schema(description = "기술명(검색어, 해시태그 용도)", example = "java", required = true)
    private String name;
}
