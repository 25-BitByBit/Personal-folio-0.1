package jam.personal_folio.portfolio.domain.career.controller;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.career.dto.CareerRequestDto;
import jam.personal_folio.portfolio.domain.career.dto.CareerResponseDto;
import jam.personal_folio.portfolio.domain.career.service.CareerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
public class CareerController {

    private final CareerService careerService;

    @PostMapping("/{portfolioId}/careers")
    public ApiResponse<Void> addCareer(@PathVariable Long portfolioId, @RequestBody CareerRequestDto dto) {
        return careerService.addCareer(portfolioId, dto);
    }

    @GetMapping("/{portfolioId}/careers")
    public ApiResponse<List<CareerResponseDto>> getCareerList(@PathVariable Long portfolioId) {
        return careerService.getCareerList(portfolioId);
    }

    @GetMapping("/careers/{careerId}")
    public ApiResponse<CareerResponseDto> getCareer(@PathVariable Long careerId) {
        return careerService.getCareer(careerId);
    }

    @PutMapping("/careers/{careerId}")
    public ApiResponse<Void> updateCareer(@PathVariable Long careerId, @RequestBody CareerRequestDto dto) {
        return careerService.updateCareer(careerId, dto);
    }

    @DeleteMapping("/careers/{careerId}")
    public ApiResponse<Void> deleteCareer(@PathVariable Long careerId) {
        return careerService.deleteCareer(careerId);
    }
}
