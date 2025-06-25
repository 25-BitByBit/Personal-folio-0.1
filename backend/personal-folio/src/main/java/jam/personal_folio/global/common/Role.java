package jam.personal_folio.global.common;

public enum Role {
    USER,
    COMPANY,
    ADMIN;

    public boolean isUser() {
        return this == USER;
    }

    public boolean isCompany() {
        return this == COMPANY;
    }

    public boolean isAdmin() {
        return this == ADMIN;
    }
}
