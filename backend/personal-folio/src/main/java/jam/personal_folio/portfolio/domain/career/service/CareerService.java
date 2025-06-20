package jam.personal_folio.portfolio.domain.career.service;

import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.global.response.ResponseStatus;
import jam.personal_folio.portfolio.domain.career.dto.CareerRequestDto;
import jam.personal_folio.portfolio.domain.career.dto.CareerResponseDto;
import jam.personal_folio.portfolio.domain.career.entity.Career;
import jam.personal_folio.portfolio.domain.career.repository.CareerRepository;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CareerService {

    private final PortfolioRepository portfolioRepository;
    private final CareerRepository careerRepository;

    public ApiResponse<Void> addCareer(Long portfolioId, CareerRequestDto dto) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        Career career = dto.toEntity(portfolio);
        careerRepository.save(career);

        return ApiResponse.of(ResponseStatus.CREATED_SUCCESS.getHttpStatus(),
                ResponseStatus.CREATED_SUCCESS.getMessage());
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<CareerResponseDto>> getCareerList(Long portfolioId) {
        List<Career> careers = careerRepository.findByPortfolioId(portfolioId);
        List<CareerResponseDto> result = careers.stream()
                .map(CareerResponseDto::from)
                .toList();
        return ApiResponse.ok(result);
    }

    @Transactional(readOnly = true)
    public ApiResponse<CareerResponseDto> getCareer(Long careerId) {
        Career career = careerRepository.findById(careerId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.CAREER_NOT_FOUND));
        return ApiResponse.ok(CareerResponseDto.from(career));
    }

    public ApiResponse<Void> updateCareer(Long careerId, CareerRequestDto dto) {
        Career career = careerRepository.findById(careerId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.CAREER_NOT_FOUND));

        career.update(dto);

        return ApiResponse.of(ResponseStatus.UPDATED_SUCCESS.getHttpStatus(),
                ResponseStatus.UPDATED_SUCCESS.getMessage());
    }

    public ApiResponse<Void> deleteCareer(Long careerId) {
        if (!careerRepository.existsById(careerId)) {
            throw new CustomException(ExceptionStatus.CAREER_NOT_FOUND);
        }
        careerRepository.deleteById(careerId);

        return ApiResponse.of(ResponseStatus.DELETED_SUCCESS.getHttpStatus(),
                ResponseStatus.DELETED_SUCCESS.getMessage());
    }
}
