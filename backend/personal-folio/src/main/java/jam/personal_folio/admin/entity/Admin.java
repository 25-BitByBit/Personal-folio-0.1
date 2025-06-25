package jam.personal_folio.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jam.personal_folio.user.entity.BaseUser;
import jam.personal_folio.user.vo.Email;
import jam.personal_folio.user.vo.Password;
import jam.personal_folio.user.vo.PhoneNumber;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jam.personal_folio.global.common.Role;

@Entity
@Table(name = "admin")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin extends BaseUser {
    @Builder
    public Admin(Email email,
                 boolean emailVerified,
                 Password password,
                 String name,
                 PhoneNumber phoneNumber,
                 boolean phoneNumberVerified) {
        super(email, emailVerified, password, name, phoneNumber, phoneNumberVerified, Role.ADMIN);
    }
}
