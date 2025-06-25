package jam.personal_folio.follow.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record FollowId(Long followerId, Long followingId) implements Serializable {
    public FollowId { }
}
