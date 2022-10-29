package com.dungtran.bookstore.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.dungtran.bookstore.entities.Authorities;
import com.dungtran.bookstore.entities.NguoiDung;
import com.dungtran.bookstore.services.NguoiDungService;

@Component
public class DemoAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
    private NguoiDungService ns;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    //DaoAuthenticationProvider sẽ gọi
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        List<NguoiDung> nguoiDung = ns.findByEmail(username);
        if (nguoiDung.size() > 0) {
            if (passwordEncoder.matches(pwd, nguoiDung.get(0).getPassword())) {
                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(nguoiDung.get(0).getVaiTro()));
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        }else {
            throw new BadCredentialsException("No user registered with this details!");
        }
		
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(Set<Authorities> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authorities authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getVaiTro()));
        }
        return grantedAuthorities;
    }
	
	//Được gọi đầu tiên
	@Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}



/*
1.AbstractSecurityInterceptor -->  DefaultLoginPageGeneratingFilter -->  Enter username and pw 
2.UsernamePasswordAuthenticationFilter extract username and pw from request object and 
UsernamePasswordAuthenticationToken(implementation of Authentication interface)  
3.With the object created from 2 it invokes authenticate() method of ProviderManager
4.Return Authentication object to ProviderManager with the details of authentication success or not
5.ProviderManager checks, if not success -> try with other AuthenticationProvider.
Otherwise,it return the authentication details to the filters
6.Authentication object is stored in the SecurityContext object by filter and response return to user.
*/
