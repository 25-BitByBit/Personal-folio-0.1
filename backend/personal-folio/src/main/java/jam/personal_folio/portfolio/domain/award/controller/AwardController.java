package jam.personal_folio.portfolio.domain.award.controller;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.award.dto.AwardRequestDto;
import jam.personal_folio.portfolio.domain.award.dto.AwardResponseDto;
import jam.personal_folio.portfolio.domain.award.service.AwardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios/{portfolioId}/awards")
@RequiredArgsConstructor
public class AwardController {

    private final AwardService awardService;

    @PostMapping
    public ApiResponse<Void> addAward(@PathVariable Long portfolioId, @RequestBody AwardRequestDto dto) {
        return awardService.addAward(portfolioId, dto);
    }

    @GetMapping
    public ApiResponse<List<AwardResponseDto>> getAwardList(@PathVariable Long portfolioId) {
        return awardService.getAwardList(portfolioId);
    }

    @GetMapping("/{awardId}")
    public ApiResponse<AwardResponseDto> getAward(@PathVariable Long awardId) {
        return awardService.getAward(awardId);
    }

    @PutMapping("/{awardId}")
    public ApiResponse<Void> updateAward(@PathVariable Long awardId, @RequestBody AwardRequestDto dto) {
        return awardService.updateAward(awardId, dto);
    }

    @DeleteMapping("/{awardId}")
    public ApiResponse<Void> deleteAward(@PathVariable Long awardId) {
        return awardService.deleteAward(awardId);
    }
}
