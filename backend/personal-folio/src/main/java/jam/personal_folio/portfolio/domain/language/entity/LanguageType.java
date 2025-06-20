package jam.personal_folio.portfolio.domain.language.entity;

import jam.personal_folio.global.enums.LabeledEnum;
import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import lombok.Getter;

@Getter
public enum LanguageType implements LabeledEnum {
    ENGLISH(1, "영어"),
    JAPANESE(2, "일본어"),
    CHINESE(3, "중국어"),
    GERMAN(4, "독일어"),
    FRENCH(5, "불어"),
    SPANISH(6, "스페인어"),
    RUSSIAN(7, "러시아어"),
    ITALIAN(8, "이탈리아어"),
    KOREAN(9, "한국어"),
    ETC(10, "기타");

    private final int code;
    private final String label;

    LanguageType(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public static LanguageType fromCode(int code) {
        for (LanguageType type : values()) {
            if (type.code == code) return type;
        }
        throw new CustomException(ExceptionStatus.INVALID_LANGUAGE_TYPE);
    }
}
