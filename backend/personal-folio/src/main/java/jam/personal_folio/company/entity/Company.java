// jam/personal_folio/company/entity/Company.java
package jam.personal_folio.company.entity;

import jakarta.persistence.*;
import jam.personal_folio.follow.entity.Follow;
import jam.personal_folio.global.common.Role;
import jam.personal_folio.user.entity.BaseUser;
import jam.personal_folio.user.entity.Followers;
import jam.personal_folio.user.entity.Followings;
import jam.personal_folio.user.vo.Email;
import jam.personal_folio.user.vo.Password;
import jam.personal_folio.user.vo.PhoneNumber;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company extends BaseUser {
    @Embedded
    private Followings followings = new Followings();

    @Embedded
    private Followers followers  = new Followers();

    @Column(name = "representative", length = 30)
    private String representative;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "industry", length = 100)
    private String industry;

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "founded_year")
    private Integer foundedYear;

    @Column(name = "employee_count")
    private Integer employeeCount;

    @Column(name = "website", length = 100)
    private String website;

    @Column(name = "tag", length = 100)
    private String tag;

    @Column(name = "recruiting", nullable = false)
    private boolean recruiting;

    @Builder
    public Company(Email email,
                   boolean emailVerified,
                   Password password,
                   String name,
                   PhoneNumber phoneNumber,
                   boolean phoneNumberVerified,
                   String representative,
                   String description,
                   String industry,
                   String location,
                   Integer foundedYear,
                   Integer employeeCount,
                   String website,
                   String tag,
                   boolean recruiting) {
        super(email, emailVerified, password, name, phoneNumber, phoneNumberVerified, Role.COMPANY);
        this.representative = representative;
        this.description    = description;
        this.industry       = industry;
        this.location       = location;
        this.foundedYear    = foundedYear;
        this.employeeCount  = employeeCount;
        this.website        = website;
        this.tag            = tag;
        this.recruiting     = recruiting;
    }
}