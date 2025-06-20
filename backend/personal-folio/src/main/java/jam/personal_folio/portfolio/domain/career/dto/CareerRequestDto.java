package jam.personal_folio.portfolio.domain.career.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jam.personal_folio.portfolio.domain.career.entity.Career;
import jam.personal_folio.portfolio.domain.career.entity.RetirementReason;
import jam.personal_folio.portfolio.entity.Portfolio;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CareerRequestDto {

    @Schema(description = "회사명", example = "teamjam")
    private String companyName;

    @Schema(description = "입사일", example = "2025-06-21")
    private LocalDate startDate;

    @Schema(description = "퇴사일", example = "2025-06-21")
    private LocalDate endDate;

    @Schema(description = "재직 여부", example = "false")
    private Boolean isCurrentlyWorking;

    @Schema(description = "직무", example = "백엔드 개발")
    private String jobTitle;

    @Schema(description = "근무 부서", example = "플랫폼개발팀")
    private String department;

    @Schema(description = "직급 또는 직책", example = "대리")
    private String position;

    @Schema(description = "담당 업무", example = "API 서버 개발 및 운영")
    private String task;

    @Schema(description = "퇴사 사유", example = "개인사정")
    private int retirementReason;

    @Schema(description = "근무 지역", example = "서울")
    private String region;

    @Schema(description = "연봉 (단위: 만원)", example = "4500")
    private Integer salary;

    @Schema(description = "총 경력 개월 수", example = "36")
    private Integer careerMonth;

    public Career toEntity(Portfolio portfolio) {
        return Career.builder()
                .companyName(companyName)
                .startDate(startDate)
                .endDate(endDate)
                .isCurrentlyWorking(isCurrentlyWorking)
                .jobTitle(jobTitle)
                .department(department)
                .position(position)
                .task(task)
                .retirementReason(RetirementReason.fromCode(retirementReason))
                .region(region)
                .salary(salary)
                .careerMonth(careerMonth)
                .portfolio(portfolio)
                .build();
    }
}
