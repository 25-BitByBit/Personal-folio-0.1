package jam.personal_folio.portfolio.domain.link.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.link.entity.LinkType;
import jam.personal_folio.portfolio.domain.link.entity.Link;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LinkResponseDto {
    @Schema(description = "링크 식별자", example = "1")
    private Long id;

    @Schema(description = "링크 URL", example = "https://github.com/username")
    private String url;

    @Schema(description = "링크 타입 (예: GITHUB, BLOG, YOUTUBE, WEBSITE, OTHER)", example = "GITHUB")
    private LinkType type;

    public static LinkResponseDto from(Link link) {
        return LinkResponseDto.builder()
                .id(link.getId())
                .url(link.getUrl())
                .type(link.getType())
                .build();
    }
}