package jam.personal_folio.portfolio.domain.skill.service;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.skill.dto.SkillResponseDto;
import jam.personal_folio.portfolio.domain.skill.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SkillService{

    private final SkillRepository skillRepository;

    @Transactional(readOnly = true)
    public ApiResponse<List<SkillResponseDto>> getAllSkills() {
        List<SkillResponseDto> skills = skillRepository.findAll()
                .stream()
                .map(SkillResponseDto::from)
                .collect(Collectors.toList());
        return ApiResponse.ok(skills);
    }
}
