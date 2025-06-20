package jam.personal_folio.portfolio.domain.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jam.personal_folio.portfolio.entity.Portfolio;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "projects")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 255)
    private String organization;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = true)
    private LocalDate endDate;

    @Builder.Default
    @Column(nullable = false)
    private boolean isOngoing = false;

    @Size(max = 1000)
    @Column(nullable = false, length = 1000)
    private String description;

    @Column(length = 1000)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void update(Project updated) {
        this.name = updated.name;
        this.organization = updated.organization;
        this.startDate = updated.startDate;
        this.endDate = updated.isOngoing ? null : updated.endDate;
        this.isOngoing = updated.isOngoing;
        this.description = updated.description;
        this.url = updated.url;
    }
}
