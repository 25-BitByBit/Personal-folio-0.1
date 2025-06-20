package jam.personal_folio.portfolio.domain.language.entity;

import jakarta.persistence.*;
import jam.personal_folio.portfolio.domain.language.dto.LanguageRequestDto;
import jam.personal_folio.portfolio.entity.Portfolio;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "languages")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private LanguageType languageType;

    @Column(nullable = false, length = 100)
    private String examName;

    @Column(nullable = false, length = 20)
    private String grade;

    @Column(length = 20)
    private String score;

    @Column(nullable = false)
    private LocalDate issuedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void update(LanguageRequestDto dto) {
        this.languageType = LanguageType.fromCode(dto.getLanguageType());
        this.examName = dto.getExamName();
        this.grade = dto.getGrade();
        this.score = dto.getScore();
        this.issuedDate = dto.getIssuedDate();
    }
}
