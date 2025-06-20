package jam.personal_folio.portfolio.domain.certificate.entity;

import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.enums.LabeledEnum;
import lombok.Getter;

@Getter
public enum PassType implements LabeledEnum {
    FIRST(1, "1차합격"),
    SECOND(2, "2차합격"),
    WRITTEN(3, "필기합격"),
    PRACTICAL(4, "실기합격"),
    FINAL(5, "최종합격");

    private final int code;
    private final String label;

    PassType(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public static PassType fromCode(int code) {
        for (PassType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new CustomException(ExceptionStatus.INVALID_PASS_TYPE);
    }
}
