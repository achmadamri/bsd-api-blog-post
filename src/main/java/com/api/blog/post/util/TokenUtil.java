package com.api.blog.post.util;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.api.blog.post.exception.ForbiddenException;
import com.api.blog.post.model.RequestModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class TokenUtil {

	public static HashMap<String, String> keyMap = new HashMap<String, String>();

	public void store(String email, String salt) {
		keyMap.put(email, salt);
	}

	public Claims claims(RequestModel requestModel) throws Exception {
		try {
			return Jwts.parser().setSigningKey(keyMap.get(requestModel.getEmail())).parseClaimsJws(requestModel.getToken()).getBody();
		} catch (Exception ex) {
			throw new ForbiddenException();
		}
	}
}
