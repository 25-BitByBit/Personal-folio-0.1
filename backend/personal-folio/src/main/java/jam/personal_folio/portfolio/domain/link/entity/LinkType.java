package jam.personal_folio.portfolio.domain.link.entity;

import jam.personal_folio.global.enums.LabeledEnum;
import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import lombok.Getter;

@Getter
public enum LinkType implements LabeledEnum {
    YOUTUBE(1, "유튜브"),
    GITHUB(2, "깃허브"),
    BLOG(3, "블로그"),
    WEBSITE(4, "웹사이트"),
    OTHER(5, "기타");

    private final int code;
    private final String label;

    LinkType(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public static LinkType fromCode(int code) {
        for (LinkType linkType : values()) {
            if (linkType.code == code) {
                return linkType;
            }
        }
        throw new CustomException(ExceptionStatus.INVALID_LINK_TYPE);
    }
}
