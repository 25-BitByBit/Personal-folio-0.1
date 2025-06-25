package jam.personal_folio.portfolio.domain.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.project.entity.Project;
import jam.personal_folio.portfolio.entity.Portfolio;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequestDto {
    @Schema(description = "프로젝트 명", example = "포트폴리오 웹사이트", required = true)
    private String name;

    @Schema(description = "소속/기관", example = "개인")
    private String organization;

    @Schema(description = "시작일", example = "2025-06-21")
    private LocalDate startDate;

    @Schema(description = "종료일 (진행 중인 경우 null)", example = "2025-06-21", nullable = true)
    private LocalDate endDate;

    @Schema(description = "진행 중 여부", example = "false")
    private boolean isOngoing;

    @Schema(description = "설명", example = "React + Spring Boot 기반 포트폴리오 사이트", nullable = true)
    private String description;

    @Schema(description = "관련 링크", example = "https://github.com/username/project")
    private String url;

    public Project toEntity(Portfolio portfolio) {
        return Project.builder()
                .name(this.name)
                .organization(this.organization)
                .startDate(this.startDate)
                .endDate(this.isOngoing ? null : this.endDate)
                .isOngoing(this.isOngoing)
                .description(this.description)
                .url(this.url)
                .portfolio(portfolio)
                .build();
    }
}
