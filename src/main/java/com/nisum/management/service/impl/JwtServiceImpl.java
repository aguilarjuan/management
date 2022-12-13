package com.nisum.management.service.impl;

import com.nisum.management.service.JwtService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@Service
public class JwtServiceImpl implements JwtService {

    public static final String ID = "issuer-key";
    public static final int EXPIRES_IN_MILLISECOND = 3600000;
    public static final String SECRET_KEY = "secret-key";
    public static final String AUTHORITIES = "authorities";
    public static final String ROLES = "ROLE_USER";

    @Override
    public String create(String username) {

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(ROLES);

        return Jwts
                .builder()
                .setId(ID)
                .setSubject(username)
                .claim(AUTHORITIES,
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRES_IN_MILLISECOND))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY.getBytes()).compact();
    }
}
