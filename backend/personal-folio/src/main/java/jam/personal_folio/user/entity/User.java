package jam.personal_folio.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jam.personal_folio.global.common.Role;
import jam.personal_folio.user.vo.Email;
import jam.personal_folio.user.vo.Password;
import jam.personal_folio.user.vo.PhoneNumber;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseUser {
    @Embedded
    private Followings followings = new Followings();

    @Embedded
    private Followers  followers  = new Followers();

    @Column(name = "career_year")
    private Integer careerYear;

    @Builder
    public User(Email email,
                boolean emailVerified,
                Password password,
                String name,
                PhoneNumber phoneNumber,
                boolean phoneNumberVerified,
                Integer careerYear) {
        super(email, emailVerified, password, name, phoneNumber, phoneNumberVerified, Role.USER);
        this.careerYear = careerYear;
    }
}