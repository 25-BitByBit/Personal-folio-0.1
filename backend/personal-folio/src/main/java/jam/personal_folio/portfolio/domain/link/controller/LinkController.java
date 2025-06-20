package jam.personal_folio.portfolio.domain.link.controller;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.link.dto.LinkRequestDto;
import jam.personal_folio.portfolio.domain.link.dto.LinkResponseDto;
import jam.personal_folio.portfolio.domain.link.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios/{portfolioId}/links")
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping
    public ApiResponse<Void> addLink(@PathVariable Long portfolioId, @RequestBody LinkRequestDto dto) {
        return linkService.addLink(portfolioId, dto);
    }

    @GetMapping
    public ApiResponse<List<LinkResponseDto>> getLinkList(@PathVariable Long portfolioId) {
        return linkService.getLinkList(portfolioId);
    }

    @GetMapping("/{linkId}")
    public ApiResponse<LinkResponseDto> getLink(@PathVariable Long linkId) {
        return linkService.getLink(linkId);
    }

    @PutMapping("/{linkId}")
    public ApiResponse<Void> updateLink(@PathVariable Long linkId, @RequestBody LinkRequestDto dto) {
        return linkService.updateLink(linkId, dto);
    }

    @DeleteMapping("/{linkId}")
    public ApiResponse<Void> deleteLink(@PathVariable Long linkId) {
        return linkService.deleteLink(linkId);
    }
}
