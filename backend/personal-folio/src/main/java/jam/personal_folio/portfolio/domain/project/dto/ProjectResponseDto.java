package jam.personal_folio.portfolio.domain.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.project.entity.Project;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponseDto {
    @Schema(description = "프로젝트 ID", example = "1")
    private Long id;

    @Schema(description = "프로젝트 명", example = "포트폴리오 웹사이트")
    private String name;

    @Schema(description = "소속/기관", example = "개인")
    private String organization;

    @Schema(description = "시작일", example = "2025-06-21")
    private LocalDate startDate;

    @Schema(description = "종료일", example = "2025-06-21", nullable = true)
    private LocalDate endDate;

    @Schema(description = "진행 중 여부", example = "false")
    private boolean isOngoing;

    @Schema(description = "설명", example = "React + Spring Boot 기반 포트폴리오 사이트")
    private String description;

    @Schema(description = "관련 링크", example = "https://github.com/username/project")
    private String url;

    public static ProjectResponseDto from(Project project) {
        return ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .organization(project.getOrganization())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .isOngoing(project.isOngoing())
                .description(project.getDescription())
                .url(project.getUrl())
                .build();
    }
}
