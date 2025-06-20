package jam.personal_folio.portfolio.domain.tag.controller;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.tag.dto.TagResponseDto;
import jam.personal_folio.portfolio.domain.tag.service.PortfolioTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios/{portfolioId}/tags")
@RequiredArgsConstructor
public class PortfolioTagController {

    private final PortfolioTagService portfolioTagService;

    @GetMapping
    public ApiResponse<List<TagResponseDto>> getTagsByPortfolio(@PathVariable Long portfolioId) {
        return portfolioTagService.getTagsByPortfolio(portfolioId);
    }

    @PostMapping("/{tagId}")
    public ApiResponse<Void> addTagToPortfolio(@PathVariable Long portfolioId,
                                               @PathVariable Long tagId) {
        return portfolioTagService.addTagToPortfolio(portfolioId, tagId);
    }

    @DeleteMapping("/{tagId}")
    public ApiResponse<Void> removeTagFromPortfolio(@PathVariable Long portfolioId,
                                                    @PathVariable Long tagId) {
        return portfolioTagService.removeTagFromPortfolio(portfolioId, tagId);
    }
}