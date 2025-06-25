package jam.personal_folio.follow.entity;

import jakarta.persistence.*;
import jam.personal_folio.user.entity.BaseUser;
import jam.personal_folio.global.common.FollowType;
import jam.personal_folio.global.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "follow")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follow extends BaseEntity {
    @EmbeddedId
    private FollowId id;

    @MapsId("followerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "follower_id", nullable = false)
    private BaseUser follower;

    @MapsId("followingId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "following_id", nullable = false)
    private BaseUser following;

    @Enumerated(EnumType.STRING)
    @Column(name = "follow_type", nullable = false, length = 20)
    private FollowType followType;

    @Column(name = "followed_at", nullable = false)
    private Instant followedAt;

    @Builder
    public Follow(BaseUser follower, BaseUser following, FollowType followType) {
        this.id = new FollowId(follower.getId(), following.getId());
        this.follower = follower;
        this.following = following;
        this.followType = followType;
        this.followedAt = Instant.now();
    }

    public static Follow createFollow(BaseUser follower, BaseUser following) {
        FollowType type;
        if (follower.getRole().isUser() && following.getRole().isUser()) {
            type = FollowType.USER_USER;
        } else if (follower.getRole().isUser() && following.getRole().isCompany()) {
            type = FollowType.USER_COMPANY;
        } else if (follower.getRole().isCompany() && following.getRole().isUser()) {
            type = FollowType.COMPANY_USER;
        } else {
            throw new IllegalArgumentException("Invalid follow relationship");
        }
        return Follow.builder()
                .follower(follower)
                .following(following)
                .followType(type)
                .build();
    }
}

