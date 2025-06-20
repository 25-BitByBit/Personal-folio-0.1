package jam.personal_folio.portfolio.domain.project.controller;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.project.dto.ProjectRequestDto;
import jam.personal_folio.portfolio.domain.project.dto.ProjectResponseDto;
import jam.personal_folio.portfolio.domain.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/portfolios/{portfolioId}/projects")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ApiResponse<Void> addProject(@PathVariable Long portfolioId, @RequestBody ProjectRequestDto dto) {
        return projectService.addProject(portfolioId, dto);
    }

    @GetMapping
    public ApiResponse<List<ProjectResponseDto>> getProjectList(@PathVariable Long portfolioId) {
        return projectService.getProjectList(portfolioId);
    }

    @GetMapping("/{projectId}")
    public ApiResponse<ProjectResponseDto> getProject(@PathVariable Long projectId) {
        return projectService.getProject(projectId);
    }

    @PutMapping("/{projectId}")
    public ApiResponse<Void> updateProject(@PathVariable Long projectId, @RequestBody ProjectRequestDto dto) {
        return projectService.updateProject(projectId, dto);
    }

    @DeleteMapping("/{projectId}")
    public ApiResponse<Void> deleteProject(@PathVariable Long projectId) {
        return projectService.deleteProject(projectId);
    }
}
