package jam.personal_folio.portfolio.domain.link.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.domain.link.entity.Link;
import jam.personal_folio.portfolio.domain.link.entity.LinkType;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LinkRequestDto {
    @Schema(description = "링크 URL", example = "https://github.com/username")
    private String url;

    @Schema(description = "링크 타입 (예: GITHUB, BLOG, YOUTUBE, WEBSITE, OTHER)", example = "GITHUB")
    private int type;

    public Link toEntity(Portfolio portfolio) {
        return Link.builder()
                .url(this.url)
                .type(LinkType.fromCode(this.type))
                .portfolio(portfolio)
                .build();
    }
}
