package jam.personal_folio.portfolio.domain.tag.service;

import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.global.response.ResponseStatus;
import jam.personal_folio.portfolio.domain.tag.dto.TagResponseDto;
import jam.personal_folio.portfolio.domain.tag.entity.PortfolioTag;
import jam.personal_folio.portfolio.domain.tag.entity.Tag;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.domain.tag.repository.PortfolioTagRepository;
import jam.personal_folio.portfolio.domain.tag.repository.TagRepository;
import jam.personal_folio.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PortfolioTagService {

    private final PortfolioRepository portfolioRepository;
    private final TagRepository tagRepository;
    private final PortfolioTagRepository portfolioTagRepository;

    @Transactional(readOnly = true)
    public ApiResponse<List<TagResponseDto>> getTagsByPortfolio(Long portfolioId) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        List<TagResponseDto> tags = portfolioTagRepository.findByPortfolio(portfolio)
                .stream()
                .map(pt -> TagResponseDto.from(pt.getTag()))
                .collect(Collectors.toList());

        return ApiResponse.ok(tags);
    }

    public ApiResponse<Void> addTagToPortfolio(Long portfolioId, Long tagId) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.TAG_NOT_FOUND));

        boolean exists = portfolioTagRepository.existsByPortfolioAndTag(portfolio, tag);
        if (exists) {
            throw new CustomException(ExceptionStatus.TAG_NOT_FOUND); // 적절한 예외로 교체
        }

        PortfolioTag pt = PortfolioTag.create(portfolio, tag);
        portfolioTagRepository.save(pt);

        return ApiResponse.of(ResponseStatus.CREATED_SUCCESS.getHttpStatus(),
                ResponseStatus.CREATED_SUCCESS.getMessage());
    }

    public ApiResponse<Void> removeTagFromPortfolio(Long portfolioId, Long tagId) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.TAG_NOT_FOUND));

        PortfolioTag pt = portfolioTagRepository.findByPortfolioAndTag(portfolio, tag)
                .orElseThrow(() -> new CustomException(ExceptionStatus.TAG_NOT_FOUND));

        portfolioTagRepository.delete(pt);

        return ApiResponse.of(ResponseStatus.DELETED_SUCCESS.getHttpStatus(),
                ResponseStatus.DELETED_SUCCESS.getMessage());
    }
}
