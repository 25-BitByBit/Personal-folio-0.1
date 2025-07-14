package jam.personal_folio.portfolio.domain.file.controller;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.file.dto.FileResponseDto;
import jam.personal_folio.portfolio.domain.file.dto.FileSaveDto;
import jam.personal_folio.portfolio.domain.file.dto.UploadUrlRequestDto;
import jam.personal_folio.portfolio.domain.file.service.FileService;
import jam.personal_folio.portfolio.domain.file.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FileController {
    private final S3Service s3Service;
    private final FileService fileService;

    @PostMapping("/files/upload-url")
    public ApiResponse<String> getUploadUrl(@RequestBody UploadUrlRequestDto request) {
        return ApiResponse.ok(s3Service.generateUploadUrl(request.fileName()));
    }

    @PostMapping("/portfolios/{portfolioId}/files")
    public ApiResponse<Void> saveFile(@PathVariable Long portfolioId, @RequestBody FileSaveDto dto) {
        fileService.saveFileToPortfolio(portfolioId, dto);
        return ApiResponse.ok();
    }

    @GetMapping("/portfolios/{portfolioId}/files")
    public ApiResponse<List<FileResponseDto>> getFiles(@PathVariable Long portfolioId) {
        return fileService.getFiles(portfolioId);
    }

    @DeleteMapping("/portfolios/{portfolioId}/files/{fileId}")
    public ApiResponse<Void> deleteFile(@PathVariable Long portfolioId, @PathVariable Long fileId) {
        return fileService.deleteFileFromPortfolio(portfolioId, fileId);
    }
}
