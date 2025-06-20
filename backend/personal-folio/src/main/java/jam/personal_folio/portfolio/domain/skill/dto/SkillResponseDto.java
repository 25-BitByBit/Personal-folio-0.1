package jam.personal_folio.portfolio.domain.skill.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.skill.entity.Skill;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillResponseDto {
    @Schema(description = "기술 ID", example = "1")
    private Long id;

    @Schema(description = "기술명(검색어, 해시태그 용도)", example = "java")
    private String name;

    public static SkillResponseDto from(Skill skill) {
        return SkillResponseDto.builder()
                .id(skill.getId())
                .name(skill.getName())
                .build();
    }
}
