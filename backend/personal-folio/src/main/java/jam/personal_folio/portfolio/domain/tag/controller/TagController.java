package jam.personal_folio.portfolio.domain.tag.controller;

import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.tag.dto.TagRequestDto;
import jam.personal_folio.portfolio.domain.tag.dto.TagResponseDto;
import jam.personal_folio.portfolio.domain.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping
    public ApiResponse<Void> addTag(@RequestBody TagRequestDto dto) {
        return tagService.addTag(dto);
    }

    @GetMapping
    public ApiResponse<List<TagResponseDto>> getAllTags() {
        return tagService.getAllTags();
    }

    @PutMapping("/{tagId}")
    public ApiResponse<Void> updateTag(@PathVariable Long tagId, @RequestBody TagRequestDto dto) {
        return tagService.updateTag(tagId, dto);
    }

    @DeleteMapping("/{tagId}")
    public ApiResponse<Void> deleteTag(@PathVariable Long tagId) {
        return tagService.deleteTag(tagId);
    }
}
