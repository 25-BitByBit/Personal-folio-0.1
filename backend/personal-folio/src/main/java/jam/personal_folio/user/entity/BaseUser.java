package jam.personal_folio.user.entity;

import jakarta.persistence.*;
import jam.personal_folio.global.common.BaseEntity;
import jam.personal_folio.global.common.Role;
import jam.personal_folio.user.vo.Email;
import jam.personal_folio.user.vo.Password;
import jam.personal_folio.user.vo.PhoneNumber;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "base_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Email email;

    @Column(name = "email_verified", nullable = false)
    private boolean emailVerified;

    @Embedded
    private Password password;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Embedded
    private PhoneNumber phoneNumber;

    @Column(name = "phone_verified", nullable = false)
    private boolean phoneNumberVerified;

    @Column(name = "role", nullable = false, length = 20)
    private Role role;

    protected BaseUser(Email email,
                       boolean emailVerified,
                       Password password,
                       String name,
                       PhoneNumber phoneNumber,
                       boolean phoneNumberVerified,
                       Role role) {
        this.email = email;
        this.emailVerified = emailVerified;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.phoneNumberVerified = phoneNumberVerified;
        this.role = role;
    }
}