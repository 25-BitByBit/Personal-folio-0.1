package jam.personal_folio.portfolio.entity;

public enum PortfolioType {
    DEFAULT(1),
    GENERAL(0);

    private final int code;

    PortfolioType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static PortfolioType fromCode(int code) {
        for (PortfolioType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid PortfolioType code: " + code);
    }
}