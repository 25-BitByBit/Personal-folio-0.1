package jam.personal_folio.portfolio.domain.tag.entity;

import jakarta.persistence.*;
import jam.personal_folio.global.exception.CustomException;
import jam.personal_folio.global.exception.ExceptionStatus;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "tags")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<PortfolioTag> portfolioTags = new ArrayList<>();

    public void addPortfolioTag(PortfolioTag portfolioTag) {
        portfolioTags.add(portfolioTag);
        portfolioTag.setTag(this);
    }

    public void removePortfolioTag(PortfolioTag portfolioTag) {
        portfolioTags.remove(portfolioTag);
        portfolioTag.setTag(null);
    }

    public void updateName(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new CustomException(ExceptionStatus.INVALID_TAG_NAME);
        }
        this.name = newName;
    }
}
