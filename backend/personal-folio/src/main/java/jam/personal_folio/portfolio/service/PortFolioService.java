package jam.personal_folio.portfolio.service;

import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.global.response.ResponseStatus;
import jam.personal_folio.portfolio.dto.PortfolioRequestDto;
import jam.personal_folio.portfolio.dto.PortfolioResponseDto;
import jam.personal_folio.portfolio.dto.PortfolioSummaryDto;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.entity.PortfolioType;
import jam.personal_folio.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PortFolioService {
    private final PortfolioRepository portfolioRepository;

    @Transactional
    public ApiResponse<Long> createEmptyPortfolio() {
        Portfolio portfolio = Portfolio.create();
        Portfolio saved = portfolioRepository.save(portfolio);
        return ApiResponse.ok(saved.getId());
    }

    @Transactional(readOnly = true)
    public ApiResponse<PortfolioResponseDto> getPortfolio(Long id) {
        Portfolio portfolio = findPortfolioOrThrow(id);
        return ApiResponse.ok(PortfolioResponseDto.from(portfolio));
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<PortfolioSummaryDto>> getPortfolioList() {
        List<Portfolio> portfolios = portfolioRepository.findAll();
        return ApiResponse.ok(portfolios.stream()
                .map(PortfolioSummaryDto::from)
                .toList());
    }

    public ApiResponse<Void> updatePortfolioInfo(Long id, PortfolioRequestDto dto) {
        Portfolio portfolio = findPortfolioOrThrow(id);
        portfolio.updateInfo(dto);
        return ApiResponse.ok();
    }

    public ApiResponse<Void> deleteDraftPortfolio(Long id) {
        Portfolio portfolio = findPortfolioOrThrow(id);
        portfolioRepository.delete(portfolio);
        return ApiResponse.ok();
    }

    public ApiResponse<Void> submitPortfolio(Long id) {
        Portfolio portfolio = findPortfolioOrThrow(id);
        portfolio.submit();
        return ApiResponse.ok();
    }

    private Portfolio findPortfolioOrThrow(Long id) {
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));
    }
}
