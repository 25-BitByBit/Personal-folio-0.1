package jam.personal_folio.portfolio.domain.career.entity;

import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import jam.personal_folio.global.enums.LabeledEnum;
import lombok.Getter;

@Getter
public enum RetirementReason implements LabeledEnum {
    업직종_전환(1, "업직종 전환"),
    근무조건(2, "근무조건"),
    경영악화(3, "경영악화"),
    계약만료(4, "계약 만료"),
    출산_육아(5, "출산/육아"),
    학업(6, "학업"),
    유학(7, "유학"),
    개인사정(8, "개인 사정"),
    직접입력(9, "직접 입력");

    private final int code;
    private final String label;

    RetirementReason(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public static RetirementReason fromCode(int code) {
        for (RetirementReason reason : values()) {
            if (reason.code == code) {
                return reason;
            }
        }
        throw new CustomException(ExceptionStatus.INVALID_RETIREMENT_REASON);
    }
}
