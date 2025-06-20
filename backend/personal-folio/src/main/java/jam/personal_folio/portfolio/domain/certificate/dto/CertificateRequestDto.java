package jam.personal_folio.portfolio.domain.certificate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.certificate.entity.Certificate;
import jam.personal_folio.portfolio.domain.certificate.entity.PassType;
import jam.personal_folio.portfolio.entity.Portfolio;
import lombok.*;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateRequestDto {
    @Schema(description = "자격증명", example = "정보처리기사")
    private String name;

    @Schema(description = "발급 기관", example = "한국산업인력공단")
    private String issuer;

    @Schema(description = "발급일", example = "2025-06-21")
    private LocalDate issuedDate;

    @Schema(description = "합격 구분", example = "FINAL")
    private int passType;

    public Certificate toEntity(Portfolio portfolio) {
        return Certificate.builder()
                .name(name)
                .issuer(issuer)
                .issuedDate(issuedDate)
                .passType(PassType.fromCode(passType))
                .portfolio(portfolio)
                .build();
    }
}
