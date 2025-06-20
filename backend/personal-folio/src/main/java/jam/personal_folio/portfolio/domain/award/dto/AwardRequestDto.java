package jam.personal_folio.portfolio.domain.award.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.award.entity.Award;
import jam.personal_folio.portfolio.entity.Portfolio;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AwardRequestDto {

    @Schema(description = "수상명", example = "OO 대학교 경진 대회")
    private String name;

    @Schema(description = "수상 기관", example = "OO 대학교")
    private String organization;

    @Schema(description = "수상 날짜", example = "2025-06-21")
    private LocalDate date;

    public Award toEntity(Portfolio portfolio) {
        return Award.builder()
                .name(name)
                .organization(organization)
                .date(date)
                .portfolio(portfolio)
                .build();
    }
}
