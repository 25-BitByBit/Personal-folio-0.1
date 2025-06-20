package jam.personal_folio.portfolio.domain.skill.controller;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.skill.dto.SkillResponseDto;
import jam.personal_folio.portfolio.domain.skill.service.PortfolioSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios/{portfolioId}/skills")
@RequiredArgsConstructor
public class PortfolioSkillController {
    private final PortfolioSkillService portfolioSkillService;

    // 특정 포트폴리오에 연결된 스킬 조회
    @GetMapping
    public ApiResponse<List<SkillResponseDto>> getSkillsByPortfolio(@PathVariable Long portfolioId) {
        return portfolioSkillService.getSkillsByPortfolio(portfolioId);
    }

    // 포트폴리오에 스킬 추가 (DB에 이미 존재하는 스킬 ID로 연결)
    @PostMapping("/{skillId}")
    public ApiResponse<Void> addSkillToPortfolio(@PathVariable Long portfolioId,
                                                 @PathVariable Long skillId) {
        return portfolioSkillService.addSkillToPortfolio(portfolioId, skillId);
    }

    // 포트폴리오에서 스킬 제거
    @DeleteMapping("/{skillId}")
    public ApiResponse<Void> removeSkillFromPortfolio(@PathVariable Long portfolioId,
                                                      @PathVariable Long skillId) {
        return portfolioSkillService.removeSkillFromPortfolio(portfolioId, skillId);
    }
}
