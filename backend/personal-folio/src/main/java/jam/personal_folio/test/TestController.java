package jam.personal_folio.test;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "TmpController", description = "임시 컨트롤러")
@RestController
public class TestController {

    @GetMapping("/tmp")
    @Operation(summary = "임시 API", description = "임시 API입니다.")
    @ApiResponse(responseCode = "200", description = "임시 API 성공")
    public String tmp() {
        return "tmp";
    }
}
