package com.project.common.security.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.domain.Member;
import com.project.mapper.MemberMapper;

import lombok.extern.java.Log;

@Log
public class CustomUserDetailsService implements UserDetailsService {
   
	@Autowired
	private MemberMapper memberMapper;
	
	//사용자 정의 유저 상세 클래스 메서드 loadUserByUsername 의 Username 은 userId이다.
	@Override
	public UserDetails loadUserByUsername(String userId) throws
	UsernameNotFoundException {
		log.info("Load user By UserId :" + userId);
		Member member = memberMapper.readByUserId(userId);
		
		log.info("queried by member mapper:" + member);
		return member == null? null : new CustomUser(member);
	}
}
