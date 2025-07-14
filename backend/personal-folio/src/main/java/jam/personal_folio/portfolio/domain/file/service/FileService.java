package jam.personal_folio.portfolio.domain.file.service;

import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.global.response.ResponseStatus;
import jam.personal_folio.portfolio.domain.file.dto.FileResponseDto;
import jam.personal_folio.portfolio.domain.file.dto.FileSaveDto;
import jam.personal_folio.portfolio.domain.file.entity.File;
import jam.personal_folio.portfolio.domain.file.repository.FileRepository;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;
    private final PortfolioRepository portfolioRepository;
    private final S3Client s3Client;

    public void saveFileToPortfolio(Long portfolioId, FileSaveDto dto) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        File file = File.builder()
                .fileName(dto.fileName())
                .s3Key(dto.s3Key())
                .fileUrl(dto.fileUrl())
                .build();

        portfolio.addFile(file);
        portfolioRepository.save(portfolio);
    }

    public ApiResponse<List<FileResponseDto>> getFiles(Long portfolioId) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        List<FileResponseDto> result = portfolio.getFiles().stream()
                .map(file -> new FileResponseDto(
                        file.getId(),
                        file.getFileName(),
                        file.getS3Key(),
                        file.getFileUrl()
                ))
                .toList();

        return ApiResponse.ok(result);
    }

    public ApiResponse<Void> deleteFileFromPortfolio(Long portfolioId, Long fileId) {
        File file = fileRepository.findById(fileId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.FILE_NOT_FOUND));

        s3Client.deleteObject(DeleteObjectRequest.builder()
                .bucket("teamjambucket")
                .key(file.getS3Key())
                .build());

        fileRepository.delete(file);
        return ApiResponse.of(ResponseStatus.DELETED_SUCCESS.getHttpStatus(), ResponseStatus.DELETED_SUCCESS.getMessage());
    }
}
