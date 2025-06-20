package jam.personal_folio.portfolio.domain.language.controller;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.language.dto.LanguageRequestDto;
import jam.personal_folio.portfolio.domain.language.dto.LanguageResponseDto;
import jam.personal_folio.portfolio.domain.language.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios/{portfolioId}/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @PostMapping
    public ApiResponse<Void> addLanguage(@PathVariable Long portfolioId,
                                         @RequestBody LanguageRequestDto dto) {
        return languageService.addLanguage(portfolioId, dto);
    }

    @GetMapping
    public ApiResponse<List<LanguageResponseDto>> getLanguageList(@PathVariable Long portfolioId) {
        return languageService.getLanguageList(portfolioId);
    }

    @GetMapping("/{languageId}")
    public ApiResponse<LanguageResponseDto> getLanguage(@PathVariable Long languageId) {
        return languageService.getLanguage(languageId);
    }

    @PutMapping("/{languageId}")
    public ApiResponse<Void> updateLanguage(@PathVariable Long languageId, @RequestBody LanguageRequestDto dto) {
        return languageService.updateLanguage(languageId, dto);
    }

    @DeleteMapping("/{languageId}")
    public ApiResponse<Void> deleteLanguage(@PathVariable Long languageId) {
        return languageService.deleteLanguage(languageId);
    }
}
