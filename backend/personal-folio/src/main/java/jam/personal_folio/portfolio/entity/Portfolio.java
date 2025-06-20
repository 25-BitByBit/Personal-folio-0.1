package jam.personal_folio.portfolio.entity;

import jakarta.persistence.*;
import jam.personal_folio.portfolio.dto.PortfolioRequestDto;
import jam.personal_folio.portfolio.domain.award.entity.Award;
import jam.personal_folio.portfolio.domain.career.entity.Career;
import jam.personal_folio.portfolio.domain.certificate.entity.Certificate;
import jam.personal_folio.portfolio.domain.file.entity.File;
import jam.personal_folio.portfolio.domain.language.entity.Language;
import jam.personal_folio.portfolio.domain.link.entity.Link;
import jam.personal_folio.portfolio.domain.project.entity.Project;
import jam.personal_folio.portfolio.domain.skill.entity.PortfolioSkill;
import jam.personal_folio.portfolio.domain.tag.entity.PortfolioTag;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "portfolio")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PortfolioType portfolioType;

    @Column(length = 1000)
    private String portfolioIntroduction;

    @Builder.Default
    @Column(nullable = false)
    private Boolean portfolioIsReported = false;

    @Builder.Default
    @Column(nullable = false)
    private Boolean isSubmitted = false; // 제출 여부 (미완성, 완성)

    @Builder.Default
    @Column(nullable = false)
    private Boolean isDeleted = false;

    @Builder.Default
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioTag> portfolioTags = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Link> links = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> files = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Career> careers = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Language> languages = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Award> awards = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificate> certificates = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioSkill> portfolioSkills = new ArrayList<>();

    // 연관관계 편의 메서드
    public void addPortfolioTag(PortfolioTag tag) {
        portfolioTags.add(tag);
        tag.setPortfolio(this);
    }

    public void addLink(Link link) {
        links.add(link);
        link.setPortfolio(this);
    }

    public void addFile(File file) {
        files.add(file);
        file.setPortfolio(this);
    }

    public void addProject(Project project) {
        projects.add(project);
        project.setPortfolio(this);
    }

    public void addCareer(Career career) {
        careers.add(career);
        career.setPortfolio(this);
    }

    public void addLanguage(Language language) {
        languages.add(language);
        language.setPortfolio(this);
    }

    public void addAward(Award award) {
        awards.add(award);
        award.setPortfolio(this);
    }

    public void addCertificate(Certificate certificate) {
        certificates.add(certificate);
        certificate.setPortfolio(this);
    }

    public void addPortfolioSkill(PortfolioSkill portfolioSkill) {
        portfolioSkills.add(portfolioSkill);
        portfolioSkill.setPortfolio(this);
    }

    public void submit() {
        this.isSubmitted = true;
    }

    public static Portfolio create() {
        return Portfolio.builder()
                .portfolioType(PortfolioType.GENERAL)
                .portfolioIsReported(false)
                .isSubmitted(false)
                .isDeleted(false)
                .build();
    }

    public void updateInfo(PortfolioRequestDto dto) {
        this.portfolioType = dto.getPortfolioType();
        this.portfolioIntroduction = dto.getPortfolioIntroduction();
    }
}
