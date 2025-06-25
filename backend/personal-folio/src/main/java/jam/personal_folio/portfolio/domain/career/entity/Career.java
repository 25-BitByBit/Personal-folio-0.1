package jam.personal_folio.portfolio.domain.career.entity;

import jakarta.persistence.*;
import jam.personal_folio.portfolio.domain.career.dto.CareerRequestDto;
import jam.personal_folio.portfolio.entity.Portfolio;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "careers")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String companyName;

    @Column(nullable = false, length = 100)
    private String department;

    @Column(nullable = false, length = 100)
    private String jobTitle;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column(nullable = false)
    private Boolean isCurrentlyWorking;

    @Column(nullable = false, length = 100)
    private String position;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String task;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RetirementReason retirementReason;

    @Column(nullable = false, length = 100)
    private String region;

    @Column(nullable = false)
    private Integer salary;

    @Column(nullable = false)
    private Integer careerMonth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void update(CareerRequestDto dto) {
        this.companyName = dto.getCompanyName();
        this.department = dto.getDepartment();
        this.jobTitle = dto.getJobTitle();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
        this.isCurrentlyWorking = dto.getIsCurrentlyWorking();
        this.position = dto.getPosition();
        this.task = dto.getTask();
        this.retirementReason = RetirementReason.fromCode(dto.getRetirementReason());
        this.region = dto.getRegion();
        this.salary = dto.getSalary();
        this.careerMonth = dto.getCareerMonth();
    }
}
