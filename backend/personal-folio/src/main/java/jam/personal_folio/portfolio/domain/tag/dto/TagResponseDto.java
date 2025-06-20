package jam.personal_folio.portfolio.domain.tag.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.tag.entity.Tag;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagResponseDto {

    @Schema(description = "태그 ID", example = "1")
    private Long id;

    @Schema(description = "태그명", example = "밝음")
    private String name;

    public static TagResponseDto from(Tag tag) {
        return TagResponseDto.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }
}
