package jam.personal_folio.portfolio.controller;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.dto.PortfolioRequestDto;
import jam.personal_folio.portfolio.dto.PortfolioResponseDto;
import jam.personal_folio.portfolio.dto.PortfolioSummaryDto;
import jam.personal_folio.portfolio.service.PortFolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
public class PortfolioController {
    private final PortFolioService portfolioService;

    // "이력서 작성하기" 클릭 시 → ID만 생성
    @PostMapping
    public ApiResponse<Long> createEmptyPortfolio() {
        return portfolioService.createEmptyPortfolio();
    }

    //통합 조회
    @GetMapping("/{id}")
    public ApiResponse<PortfolioResponseDto> getPortfolio(@PathVariable Long id) {
        return portfolioService.getPortfolio(id);
    }

    //목록 조회
    @GetMapping
    public ApiResponse<List<PortfolioSummaryDto>> getPortfolioList() {
        return portfolioService.getPortfolioList();
    }

    //수정
    @PutMapping("/{id}")
    public ApiResponse<Void> updatePortfolioInfo(@PathVariable Long id, @RequestBody PortfolioRequestDto dto) {
        return portfolioService.updatePortfolioInfo(id, dto);
    }

    //삭제
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteDraftPortfolio(@PathVariable Long id) {
        return portfolioService.deleteDraftPortfolio(id);
    }

    //제출
    @PatchMapping("/{id}/submit")
    public ApiResponse<Void> submitPortfolio(@PathVariable Long id) {
        return portfolioService.submitPortfolio(id);
    }
}
