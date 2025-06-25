package jam.personal_folio.portfolio.domain.certificate.entity;

import jakarta.persistence.*;
import jam.personal_folio.portfolio.domain.certificate.dto.CertificateRequestDto;
import jam.personal_folio.portfolio.entity.Portfolio;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "certificates")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String issuer;

    @Column(nullable = false)
    private LocalDate issuedDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private PassType passType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void update(CertificateRequestDto dto) {
        this.name = dto.getName();
        this.issuer = dto.getIssuer();
        this.issuedDate = dto.getIssuedDate();
        this.passType = PassType.fromCode(dto.getPassType());
    }
}
