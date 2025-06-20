package jam.personal_folio.portfolio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jam.personal_folio.portfolio.entity.PortfolioType;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioRequestDto {

    @Schema(description = "포트폴리오 타입", example = "DEFAULT")
    @NotNull
    private PortfolioType portfolioType;

    @Schema(description = "포트폴리오 소개", example = "백엔드 개발자 포트폴리오입니다.")
    private String portfolioIntroduction;
}
