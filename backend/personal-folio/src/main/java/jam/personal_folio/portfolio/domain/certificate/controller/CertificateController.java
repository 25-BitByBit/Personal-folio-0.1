package jam.personal_folio.portfolio.domain.certificate.controller;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.certificate.dto.CertificateRequestDto;
import jam.personal_folio.portfolio.domain.certificate.dto.CertificateResponseDto;
import jam.personal_folio.portfolio.domain.certificate.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios/{portfolioId}/certificates")
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService certificateService;

    @PostMapping
    public ApiResponse<Void> addCertificate(@PathVariable Long portfolioId, @RequestBody CertificateRequestDto dto) {
        return certificateService.addCertificate(portfolioId, dto);
    }

    @GetMapping
    public ApiResponse<List<CertificateResponseDto>> getCertificateList(@PathVariable Long portfolioId) {
        return certificateService.getCertificateList(portfolioId);
    }

    @GetMapping("/{certificateId}")
    public ApiResponse<CertificateResponseDto> getCertificate(@PathVariable Long certificateId) {
        return certificateService.getCertificate(certificateId);
    }

    @PutMapping("/{certificateId}")
    public ApiResponse<Void> updateCertificate(@PathVariable Long certificateId, @RequestBody CertificateRequestDto dto) {
        return certificateService.updateCertificate(certificateId, dto);
    }

    @DeleteMapping("/{certificateId}")
    public ApiResponse<Void> deleteCertificate(@PathVariable Long certificateId) {
        return certificateService.deleteCertificate(certificateId);
    }
}
