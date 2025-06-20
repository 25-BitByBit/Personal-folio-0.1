package jam.personal_folio.portfolio.domain.award.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.award.entity.Award;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AwardResponseDto {
    @Schema(description = "수상 ID", example = "1")
    private Long id;

    @Schema(description = "수상명", example = "OO 대학교 경진 대회")
    private String name;

    @Schema(description = "수상 기관", example = "OO 대학교")
    private String organization;

    @Schema(description = "수상 날짜", example = "2025-06-21")
    private LocalDate date;

    public static AwardResponseDto from(Award award) {
        return AwardResponseDto.builder()
                .id(award.getId())
                .name(award.getName())
                .organization(award.getOrganization())
                .date(award.getDate())
                .build();
    }
}
