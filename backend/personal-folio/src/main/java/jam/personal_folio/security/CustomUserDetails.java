package jam.personal_folio.security;

import jam.personal_folio.user.entity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // 권한은 필요 시 여기에 추가
    }

    @Override
    public String getPassword() {
        return user.getPassword().toString(); // Password 객체 → 문자열로
    }

    @Override
    public String getUsername() {
        return user.getEmail().toString(); // Email 객체 → 문자열로
    }

    @Override public boolean isAccountNonExpired()     { return true; }
    @Override public boolean isAccountNonLocked()      { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled()               { return true; }
}
