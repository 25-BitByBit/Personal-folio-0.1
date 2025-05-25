package jam.personal_folio.user.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import jam.personal_folio.follow.entity.Follow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Embeddable
public class Followings {
    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Follow> items = new ArrayList<>();

    public void add(Follow f) { items.add(f); }
    public void remove(Follow f) { items.remove(f); }
    public List<Follow> asList() { return Collections.unmodifiableList(items); }
}
