package jam.personal_folio.portfolio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.entity.PortfolioType;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioSummaryDto {
    @Schema(description = "포트폴리오 ID", example = "1")
    private Long id;

    @Schema(description = "포트폴리오 타입", example = "DEFAULT")
    private PortfolioType portfolioType;

    @Schema(description = "포트폴리오 소개", example = "백엔드 개발자 포트폴리오입니다.")
    private String portfolioIntroduction;

    @Schema(description = "제출 여부", example = "true")
    private Boolean isSubmitted;

    public static PortfolioSummaryDto from(Portfolio entity) {
        return PortfolioSummaryDto.builder()
                .id(entity.getId())
                .portfolioType(entity.getPortfolioType())
                .portfolioIntroduction(entity.getPortfolioIntroduction())
                .isSubmitted(entity.getIsSubmitted())
                .build();
    }
}
