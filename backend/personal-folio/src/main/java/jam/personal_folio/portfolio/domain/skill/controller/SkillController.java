package jam.personal_folio.portfolio.domain.skill.controller;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.skill.dto.SkillResponseDto;
import jam.personal_folio.portfolio.domain.skill.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;

    // 전체 스킬 조회
    @GetMapping
    public ApiResponse<List<SkillResponseDto>> getAllSkills() {
        return skillService.getAllSkills();
    }
}
