package jam.personal_folio.portfolio.domain.certificate.service;

import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.certificate.dto.CertificateRequestDto;
import jam.personal_folio.portfolio.domain.certificate.dto.CertificateResponseDto;
import jam.personal_folio.portfolio.domain.certificate.entity.Certificate;
import jam.personal_folio.portfolio.domain.certificate.repository.CertificateRepository;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CertificateService {

    private final CertificateRepository certificateRepository;
    private final PortfolioRepository portfolioRepository;

    public ApiResponse<Void> addCertificate(Long portfolioId, CertificateRequestDto dto) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        Certificate certificate = dto.toEntity(portfolio);
        certificateRepository.save(certificate);
        return ApiResponse.ok();
    }

    public ApiResponse<List<CertificateResponseDto>> getCertificateList(Long portfolioId) {
        List<CertificateResponseDto> list = certificateRepository.findByPortfolioId(portfolioId).stream()
                .map(CertificateResponseDto::from)
                .toList();
        return ApiResponse.ok(list);
    }

    public ApiResponse<CertificateResponseDto> getCertificate(Long certificateId) {
        Certificate certificate = certificateRepository.findById(certificateId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.CERTIFICATE_NOT_FOUND));
        return ApiResponse.ok(CertificateResponseDto.from(certificate));
    }

    public ApiResponse<Void> updateCertificate(Long certificateId, CertificateRequestDto dto) {
        Certificate certificate = certificateRepository.findById(certificateId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.CERTIFICATE_NOT_FOUND));
        certificate.update(dto);
        return ApiResponse.ok();
    }

    public ApiResponse<Void> deleteCertificate(Long certificateId) {
        Certificate certificate = certificateRepository.findById(certificateId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.CERTIFICATE_NOT_FOUND));
        certificateRepository.delete(certificate);
        return ApiResponse.ok();
    }
}
