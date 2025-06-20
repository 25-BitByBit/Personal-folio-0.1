package jam.personal_folio.portfolio.domain.award.service;

import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.global.response.ResponseStatus;
import jam.personal_folio.portfolio.domain.award.dto.AwardRequestDto;
import jam.personal_folio.portfolio.domain.award.dto.AwardResponseDto;
import jam.personal_folio.portfolio.domain.award.entity.Award;
import jam.personal_folio.portfolio.domain.award.repository.AwardRepository;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AwardService {

    private final AwardRepository awardRepository;
    private final PortfolioRepository portfolioRepository;

    public ApiResponse<Void> addAward(Long portfolioId, AwardRequestDto dto) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        Award award = dto.toEntity(portfolio);
        awardRepository.save(award);
        return ApiResponse.of(ResponseStatus.CREATED_SUCCESS.getHttpStatus(), ResponseStatus.CREATED_SUCCESS.getMessage());
    }

    public ApiResponse<List<AwardResponseDto>> getAwardList(Long portfolioId) {
        List<AwardResponseDto> list = awardRepository.findByPortfolioId(portfolioId).stream()
                .map(AwardResponseDto::from)
                .toList();
        return ApiResponse.ok(list);
    }

    public ApiResponse<AwardResponseDto> getAward(Long awardId) {
        Award award = awardRepository.findById(awardId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.AWARD_NOT_FOUND));
        return ApiResponse.ok(AwardResponseDto.from(award));
    }

    public ApiResponse<Void> updateAward(Long awardId, AwardRequestDto dto) {
        Award award = awardRepository.findById(awardId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.AWARD_NOT_FOUND));
        award.update(dto);
        return ApiResponse.of(ResponseStatus.UPDATED_SUCCESS.getHttpStatus(), ResponseStatus.UPDATED_SUCCESS.getMessage());
    }

    public ApiResponse<Void> deleteAward(Long awardId) {
        Award award = awardRepository.findById(awardId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.AWARD_NOT_FOUND));
        awardRepository.delete(award);
        return ApiResponse.of(ResponseStatus.DELETED_SUCCESS.getHttpStatus(), ResponseStatus.DELETED_SUCCESS.getMessage());
    }
}
