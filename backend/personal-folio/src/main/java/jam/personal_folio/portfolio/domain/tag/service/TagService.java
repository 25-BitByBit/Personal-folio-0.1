package jam.personal_folio.portfolio.domain.tag.service;


import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.global.response.ResponseStatus;
import jam.personal_folio.portfolio.domain.tag.dto.TagRequestDto;
import jam.personal_folio.portfolio.domain.tag.dto.TagResponseDto;
import jam.personal_folio.portfolio.domain.tag.entity.Tag;
import jam.personal_folio.portfolio.domain.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TagService{

    private final TagRepository tagRepository;

    public ApiResponse<Void> addTag(TagRequestDto dto) {
        if (tagRepository.existsByName(dto.getName())) {
            throw new CustomException(ExceptionStatus.TAG_ALREADY_EXISTS);
        }
        Tag tag = dto.toEntity();
        tagRepository.save(tag);
        return ApiResponse.of(ResponseStatus.CREATED_SUCCESS.getHttpStatus(),
                ResponseStatus.CREATED_SUCCESS.getMessage());
    }

    @Transactional(readOnly = true)
    public ApiResponse<List<TagResponseDto>> getAllTags() {
        List<TagResponseDto> tags = tagRepository.findAll()
                .stream()
                .map(TagResponseDto::from)
                .collect(Collectors.toList());
        return ApiResponse.ok(tags);
    }

    public ApiResponse<Void> updateTag(Long tagId, TagRequestDto dto) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.TAG_NOT_FOUND));
        tag.updateName(dto.getName());
        return ApiResponse.of(ResponseStatus.UPDATED_SUCCESS.getHttpStatus(),
                ResponseStatus.UPDATED_SUCCESS.getMessage());
    }

    public ApiResponse<Void> deleteTag(Long tagId) {
        if (!tagRepository.existsById(tagId)) {
            throw new CustomException(ExceptionStatus.TAG_NOT_FOUND);
        }
        tagRepository.deleteById(tagId);
        return ApiResponse.of(ResponseStatus.DELETED_SUCCESS.getHttpStatus(),
                ResponseStatus.DELETED_SUCCESS.getMessage());
    }
}
