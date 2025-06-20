package jam.personal_folio.global.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseStatus {
    RESPONSE_SUCCESS(200, "요청에 성공했습니다.", HttpStatus.OK),
    CREATED_SUCCESS(201, "요청에 성공되어 데이터가 생성되었습니다", HttpStatus.CREATED),
    UPDATED_SUCCESS(200, "요청에 성공되어 데이터가 변경되었습니다", HttpStatus.OK),
    DELETED_SUCCESS(204, "요청에 성공되어 데이터가 삭제되었습니다", HttpStatus.NO_CONTENT);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;
}
