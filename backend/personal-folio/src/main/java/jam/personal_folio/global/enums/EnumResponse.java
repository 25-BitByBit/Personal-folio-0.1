package jam.personal_folio.global.enums;

import java.util.Arrays;
import java.util.List;

public record EnumResponse(int code, String label) {
    public static <T extends LabeledEnum> List<EnumResponse> listFromEnum(T[] values) {
        return Arrays.stream(values)
                .map(e -> new EnumResponse(e.getCode(), e.getLabel()))
                .toList();
    }
}
