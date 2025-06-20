package jam.personal_folio.portfolio.domain.language.service;

import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.global.response.ResponseStatus;
import jam.personal_folio.portfolio.domain.language.dto.LanguageRequestDto;
import jam.personal_folio.portfolio.domain.language.dto.LanguageResponseDto;
import jam.personal_folio.portfolio.domain.language.entity.Language;
import jam.personal_folio.portfolio.domain.language.repository.LanguageRepository;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final PortfolioRepository portfolioRepository;

    public ApiResponse<Void> addLanguage(Long portfolioId, LanguageRequestDto dto) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        Language language = dto.toEntity();
        language.setPortfolio(portfolio);
        languageRepository.save(language);

        return ApiResponse.of(ResponseStatus.CREATED_SUCCESS.getHttpStatus(), ResponseStatus.CREATED_SUCCESS.getMessage());
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<LanguageResponseDto>> getLanguageList(Long portfolioId) {
        List<LanguageResponseDto> list = languageRepository.findByPortfolioId(portfolioId).stream()
                .map(LanguageResponseDto::from)
                .toList();
        return ApiResponse.ok(list);
    }

    @Transactional(readOnly = true)
    public ApiResponse<LanguageResponseDto> getLanguage(Long languageId) {
        Language language = languageRepository.findById(languageId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.LANGUAGE_NOT_FOUND));
        return ApiResponse.ok(LanguageResponseDto.from(language));
    }

    public ApiResponse<Void> updateLanguage(Long languageId, LanguageRequestDto dto) {
        Language language = languageRepository.findById(languageId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.LANGUAGE_NOT_FOUND));
        language.update(dto);
        return ApiResponse.of(ResponseStatus.UPDATED_SUCCESS.getHttpStatus(), ResponseStatus.UPDATED_SUCCESS.getMessage());
    }

    public ApiResponse<Void> deleteLanguage(Long languageId) {
        Language language = languageRepository.findById(languageId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.LANGUAGE_NOT_FOUND));
        languageRepository.delete(language);
        return ApiResponse.of(ResponseStatus.DELETED_SUCCESS.getHttpStatus(), ResponseStatus.DELETED_SUCCESS.getMessage());
    }
}
