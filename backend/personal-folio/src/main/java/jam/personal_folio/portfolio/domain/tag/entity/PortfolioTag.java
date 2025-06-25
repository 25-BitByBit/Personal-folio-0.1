package jam.personal_folio.portfolio.domain.tag.entity;

import jakarta.persistence.*;
import jam.personal_folio.portfolio.entity.Portfolio;
import lombok.*;

@Entity
@Table(name = "portfolio_tags")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PortfolioTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioTagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public static PortfolioTag create(Portfolio portfolio, Tag tag) {
        PortfolioTag pt = new PortfolioTag();
        pt.setPortfolio(portfolio);
        pt.setTag(tag);
        tag.addPortfolioTag(pt);
        return pt;
    }
}
