package jam.personal_folio.portfolio.domain.tag.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.tag.entity.Tag;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagRequestDto {

    @Schema(description = "태그명", example = "밝음")
    private String name;

    public Tag toEntity() {
        return Tag.builder()
                .name(this.name)
                .build();
    }
}

