package jam.personal_folio.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionStatus {
    // 공통
    EXCEPTION(50000, "예외가 발생하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR),

    // 포트폴리오 관련
    PORTFOLIO_NOT_FOUND(41000, "포트폴리오를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    // 파일
    FILE_UPLOAD_FAILED(50000, "파일 업로드에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_FILE_FORMAT(50000, "지원하지 않는 파일 형식입니다.", HttpStatus.BAD_REQUEST),

    // 수상
    AWARD_NOT_FOUND(41100, "수상 경력을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    // 경력
    CAREER_NOT_FOUND(41200, "경력을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_RETIREMENT_REASON(41201, "유효하지 않은 퇴사 사유입니다.", HttpStatus.BAD_REQUEST),

    // 자격증
    CERTIFICATE_NOT_FOUND(41300, "자격증을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_PASS_TYPE(41301, "유효하지 않은 합격 방식입니다.", HttpStatus.BAD_REQUEST),

    // 어학
    LANGUAGE_NOT_FOUND(41400, "어학을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_LANGUAGE_TYPE(41401, "유효하지 않은 어학 언어입니다.", HttpStatus.BAD_REQUEST),

    // 링크
    LINK_NOT_FOUND(41500, "링크를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_LINK_TYPE(41501, "유효하지 않은 링크 방식입니다.", HttpStatus.BAD_REQUEST),

    // 프로젝트
    PROJECT_NOT_FOUND(41600, "프로젝트를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    // 스킬
    SKILL_NOT_FOUND(41700, "스킬을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    SKILL_ALREADY_ADDED(41701, "이미 포트폴리오에 등록된 스킬입니다.", HttpStatus.BAD_REQUEST),
    SKILL_NOT_FOUND_IN_PORTFOLIO(41702, "포트폴리오에 등록된 스킬을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    // 태그
    TAG_NOT_FOUND(41800, "태그를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    TAG_ALREADY_EXISTS(41801, "이미 존재하는 태그명입니다.", HttpStatus.BAD_REQUEST),
    INVALID_TAG_NAME(41802, "유효하지 않은 태그명입니다.", HttpStatus.BAD_REQUEST),
    ;

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;
}
