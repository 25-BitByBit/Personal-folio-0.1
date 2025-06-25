package jam.personal_folio.portfolio.domain.skill.service;

import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.global.response.ResponseStatus;
import jam.personal_folio.portfolio.domain.skill.dto.SkillResponseDto;
import jam.personal_folio.portfolio.domain.skill.entity.PortfolioSkill;
import jam.personal_folio.portfolio.domain.skill.entity.Skill;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.domain.skill.repository.PortfolioSkillRepository;
import jam.personal_folio.portfolio.domain.skill.repository.SkillRepository;
import jam.personal_folio.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PortfolioSkillService {
    private final PortfolioRepository portfolioRepository;
    private final SkillRepository skillRepository;
    private final PortfolioSkillRepository portfolioSkillRepository;

    @Transactional(readOnly = true)
    public ApiResponse<List<SkillResponseDto>> getSkillsByPortfolio(Long portfolioId) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        List<SkillResponseDto> skills = portfolioSkillRepository.findByPortfolio(portfolio)
                .stream()
                .map(ps -> SkillResponseDto.from(ps.getSkill()))
                .collect(Collectors.toList());

        return ApiResponse.ok(skills);
    }

    public ApiResponse<Void> addSkillToPortfolio(Long portfolioId, Long skillId) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.SKILL_NOT_FOUND));

        boolean exists = portfolioSkillRepository.existsByPortfolioAndSkill(portfolio, skill);
        if (exists) {
            throw new CustomException(ExceptionStatus.SKILL_ALREADY_ADDED);
        }

        PortfolioSkill ps = PortfolioSkill.create(portfolio, skill);
        portfolioSkillRepository.save(ps);

        return ApiResponse.of(ResponseStatus.CREATED_SUCCESS.getHttpStatus(),
                ResponseStatus.CREATED_SUCCESS.getMessage());
    }

    public ApiResponse<Void> removeSkillFromPortfolio(Long portfolioId, Long skillId) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.PORTFOLIO_NOT_FOUND));

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.SKILL_NOT_FOUND));

        PortfolioSkill ps = portfolioSkillRepository.findByPortfolioAndSkill(portfolio, skill)
                .orElseThrow(() -> new CustomException(ExceptionStatus.SKILL_NOT_FOUND_IN_PORTFOLIO));

        portfolioSkillRepository.delete(ps);

        return ApiResponse.of(ResponseStatus.DELETED_SUCCESS.getHttpStatus(),
                ResponseStatus.DELETED_SUCCESS.getMessage());
    }
}
