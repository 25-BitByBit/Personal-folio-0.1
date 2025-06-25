package jam.personal_folio.global.enums.controller;

import jam.personal_folio.global.enums.EnumResponse;
import jam.personal_folio.global.response.ApiResponse;
import jam.personal_folio.portfolio.domain.career.entity.RetirementReason;
import jam.personal_folio.portfolio.domain.certificate.entity.PassType;
import jam.personal_folio.portfolio.domain.language.entity.LanguageType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enums")
public class EnumController {
    //enum으로 된거 드랍다운으로 가져오기

    @GetMapping("/pass-types")
    public ApiResponse<List<EnumResponse>> getPassTypes() {
        return ApiResponse.ok(EnumResponse.listFromEnum(PassType.values()));
    }

    @GetMapping("/retirement-reasons")
    public ApiResponse<List<EnumResponse>> getRetirementReasons() {
        return ApiResponse.ok(EnumResponse.listFromEnum(RetirementReason.values()));
    }

    @GetMapping("/languages")
    public ApiResponse<List<EnumResponse>> getLanguages() {
        return ApiResponse.ok(EnumResponse.listFromEnum(LanguageType.values()));
    }
}
