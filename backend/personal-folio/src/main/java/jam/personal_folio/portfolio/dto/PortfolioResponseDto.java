package jam.personal_folio.portfolio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.award.dto.AwardResponseDto;
import jam.personal_folio.portfolio.domain.career.dto.CareerResponseDto;
import jam.personal_folio.portfolio.domain.certificate.dto.CertificateResponseDto;
import jam.personal_folio.portfolio.domain.language.dto.LanguageResponseDto;
import jam.personal_folio.portfolio.domain.project.dto.ProjectResponseDto;
import jam.personal_folio.portfolio.domain.skill.dto.SkillResponseDto;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.entity.PortfolioType;
import jam.personal_folio.portfolio.domain.link.dto.LinkResponseDto;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioResponseDto {
    @Schema(description = "포트폴리오 ID", example = "1")
    private Long id;

    @Schema(description = "포트폴리오 타입", example = "DEFAULT")
    private PortfolioType portfolioType;

    @Schema(description = "포트폴리오 소개", example = "백엔드 개발자 포트폴리오입니다.")
    private String portfolioIntroduction;

    @Schema(description = "제출 여부", example = "true")
    private Boolean isSubmitted;

    //하위 항목
    @Schema(description = "포트폴리오에 포함된 링크 리스트")
    private List<LinkResponseDto> links;

    @Schema(description = "포트폴리오에 포함된 수상 경력 리스트")
    private List<AwardResponseDto> awards;

    @Schema(description = "포트폴리오에 포함된 자격증 리스트")
    private List<CertificateResponseDto> certificates;

    @Schema(description = "포트폴리오에 포함된 경력 리스트")
    private List<CareerResponseDto> careers;

    @Schema(description = "포트폴리오에 포함된 프로젝트 리스트")
    private List<ProjectResponseDto> projects;

    @Schema(description = "포트폴리오에 포함된 외국어 능력 리스트")
    private List<LanguageResponseDto> languages;

    @Schema(description = "포트폴리오에 포함된 기술 스택 리스트")
    private List<SkillResponseDto> portfolioSkills;

    public static PortfolioResponseDto from(Portfolio entity) {
        return PortfolioResponseDto.builder()
                .id(entity.getId())
                .portfolioType(entity.getPortfolioType())
                .portfolioIntroduction(entity.getPortfolioIntroduction())
                .isSubmitted(entity.getIsSubmitted())
                .links(entity.getLinks().stream().map(LinkResponseDto::from).toList())
                .awards(entity.getAwards().stream().map(AwardResponseDto::from).toList())
                .certificates(entity.getCertificates().stream().map(CertificateResponseDto::from).toList())
                .careers(entity.getCareers().stream().map(CareerResponseDto::from).toList())
                .projects(entity.getProjects().stream().map(ProjectResponseDto::from).toList())
                .languages(entity.getLanguages().stream().map(LanguageResponseDto::from).toList())
                .portfolioSkills(entity.getPortfolioSkills().stream()
                        .map(portfolioSkill -> SkillResponseDto.from(portfolioSkill.getSkill()))
                        .toList())
                .build();
    }
}
