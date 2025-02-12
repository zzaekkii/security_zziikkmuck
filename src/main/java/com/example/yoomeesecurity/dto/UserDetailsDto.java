package com.example.yoomeesecurity.dto;

import com.example.yoomeesecurity.domains.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class UserDetailsDto implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        /**
         * 스프링 시큐리티에서는 ROLE_ 접두사를 요구하기 때문에
         * enum으로는 깔끔하게 명사로만 관리하고 dto에서 붙여주는 방식 선택.
         */
        collection.add(() -> "ROLE_" + user.getRole().name());

        /**
         * 아래 코드와 위의 코드는 의미가 같음. 람다 표현식이 더 깔끔하기 때문에 람다 선택.
         */
//        collection.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return "ROLE_" + user.getRole().name();
//            }
//        });


        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
//        return UserDetails.super.isEnabled();
        return true;
    }
}
