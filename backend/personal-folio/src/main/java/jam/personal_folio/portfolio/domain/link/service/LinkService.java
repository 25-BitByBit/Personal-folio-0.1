package jam.personal_folio.portfolio.domain.link.service;

import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.global.response.ResponseStatus;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.domain.link.dto.LinkRequestDto;
import jam.personal_folio.portfolio.domain.link.dto.LinkResponseDto;
import jam.personal_folio.portfolio.domain.link.entity.Link;
import jam.personal_folio.portfolio.domain.link.repository.LinkRepository;
import jam.personal_folio.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LinkService {
    private final PortfolioRepository portfolioRepository;
    private final LinkRepository linkRepository;

    public ApiResponse<Void> addLink(Long portfolioId, LinkRequestDto dto) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        Link link = dto.toEntity(portfolio);
        linkRepository.save(link);

        return ApiResponse.of(ResponseStatus.CREATED_SUCCESS.getHttpStatus(),
                ResponseStatus.CREATED_SUCCESS.getMessage());
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<LinkResponseDto>> getLinkList(Long portfolioId) {
        List<Link> links = linkRepository.findByPortfolioId(portfolioId);
        List<LinkResponseDto> result = links.stream()
                .map(LinkResponseDto::from)
                .toList();
        return ApiResponse.ok(result);
    }

    @Transactional(readOnly = true)
    public ApiResponse<LinkResponseDto> getLink(Long linkId) {
        Link link = linkRepository.findById(linkId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.LINK_NOT_FOUND));
        return ApiResponse.ok(LinkResponseDto.from(link));
    }

    public ApiResponse<Void> updateLink(Long linkId, LinkRequestDto dto) {
        Link link = linkRepository.findById(linkId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.LINK_NOT_FOUND));

        link.update(dto);

        return ApiResponse.of(ResponseStatus.UPDATED_SUCCESS.getHttpStatus(),
                ResponseStatus.UPDATED_SUCCESS.getMessage());
    }

    public ApiResponse<Void> deleteLink(Long linkId) {
        if (!linkRepository.existsById(linkId)) {
            throw new CustomException(ExceptionStatus.LINK_NOT_FOUND);
        }
        linkRepository.deleteById(linkId);

        return ApiResponse.of(ResponseStatus.DELETED_SUCCESS.getHttpStatus(),
                ResponseStatus.DELETED_SUCCESS.getMessage());
    }
}
