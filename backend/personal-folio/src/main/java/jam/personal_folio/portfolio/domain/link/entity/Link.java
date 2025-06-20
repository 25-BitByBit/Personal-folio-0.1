package jam.personal_folio.portfolio.domain.link.entity;

import jakarta.persistence.*;
import jam.personal_folio.portfolio.entity.Portfolio;
import jam.personal_folio.portfolio.domain.link.dto.LinkRequestDto;
import lombok.*;

@Entity
@Table(name = "links")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LinkType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void update(LinkRequestDto dto) {
        this.url = dto.getUrl();
        this.type = LinkType.fromCode(dto.getType());
    }
}
