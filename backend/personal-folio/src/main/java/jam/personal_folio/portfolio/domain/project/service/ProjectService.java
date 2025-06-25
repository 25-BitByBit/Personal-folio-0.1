package jam.personal_folio.portfolio.domain.project.service;

import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.global.response.ResponseStatus;
import jam.personal_folio.portfolio.domain.project.dto.ProjectRequestDto;
import jam.personal_folio.portfolio.domain.project.dto.ProjectResponseDto;
import jam.personal_folio.portfolio.domain.project.entity.Project;
import jam.personal_folio.portfolio.domain.project.repository.ProjectRepository;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {
    private final PortfolioRepository portfolioRepository;
    private final ProjectRepository projectRepository;

    public ApiResponse<Void> addProject(Long portfolioId, ProjectRequestDto dto) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        Project project = dto.toEntity(portfolio);
        projectRepository.save(project);

        return ApiResponse.of(ResponseStatus.CREATED_SUCCESS.getHttpStatus(),
                ResponseStatus.CREATED_SUCCESS.getMessage());
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<ProjectResponseDto>> getProjectList(Long portfolioId) {
        List<Project> projects = projectRepository.findByPortfolioId(portfolioId);
        List<ProjectResponseDto> result = projects.stream()
                .map(ProjectResponseDto::from)
                .toList();

        return ApiResponse.ok(result);
    }

    @Transactional(readOnly = true)
    public ApiResponse<ProjectResponseDto> getProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PROJECT_NOT_FOUND));
        return ApiResponse.ok(ProjectResponseDto.from(project));
    }

    public ApiResponse<Void> updateProject(Long projectId, ProjectRequestDto dto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PROJECT_NOT_FOUND));

        project.update(dto.toEntity(project.getPortfolio()));

        return ApiResponse.of(ResponseStatus.UPDATED_SUCCESS.getHttpStatus(),
                ResponseStatus.UPDATED_SUCCESS.getMessage());
    }

    public ApiResponse<Void> deleteProject(Long projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new CustomException(ExceptionStatus.PROJECT_NOT_FOUND);
        }
        projectRepository.deleteById(projectId);

        return ApiResponse.of(ResponseStatus.DELETED_SUCCESS.getHttpStatus(),
                ResponseStatus.DELETED_SUCCESS.getMessage());
    }
}
