package jam.personal_folio.portfolio.domain.award.entity;

import jakarta.persistence.*;
import jam.personal_folio.portfolio.domain.award.dto.AwardRequestDto;
import jam.personal_folio.portfolio.entity.Portfolio;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "awards")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String organization;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void update(AwardRequestDto dto) {
        this.name = dto.getName();
        this.organization = dto.getOrganization();
        this.date = dto.getDate();
    }
}
