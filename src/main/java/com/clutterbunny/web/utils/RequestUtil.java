package com.clutterbunny.web.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.NamedThreadLocal;

import com.clutterbunny.dao.UserDAO;
import com.clutterbunny.domain.User;

public class RequestUtil {
	private static String ROOT_URL = null;
	public static String CTX_PATH = null;
	private static String DOMAIN_SUFFIX = null; 
	public static UserDAO userDAO;
	
	
	private static final ThreadLocal<HttpServletRequest> requestHolder =  new NamedThreadLocal<HttpServletRequest>("Request attributes");

	public static String getRootURL(HttpServletRequest request) {
		if (ROOT_URL == null) {
			final StringBuffer buffer = new StringBuffer();
			buffer.append(request.getScheme());
			buffer.append("://");
			buffer.append(normalizeHostName(request.getServerName().trim()));
			int port = request.getServerPort();
			if (port != 80) {
				buffer.append(":");
				buffer.append(port);
			}
			CTX_PATH = request.getContextPath();
			buffer.append(CTX_PATH);
			ROOT_URL = buffer.toString();
 			
		}
		return ROOT_URL;
	}
	
	public static String getRootURL() {
		return ROOT_URL;
	}
	
	public static String normalizeHostName(String hostName){
		if(hostName.equalsIgnoreCase("localhost") || hostName.equalsIgnoreCase("127.0.0.1")){
			try {
				return InetAddress.getLocalHost().getCanonicalHostName();
			} catch (UnknownHostException e) {
				return hostName;
			}
		} else {
			return hostName;
		}
	}
	
	public static void setRequest(HttpServletRequest request) {
		requestHolder.set(request);
		if(ROOT_URL == null) {
			getRootURL(request);
		}
	}
	
	public static HttpServletRequest getRequest() {
		return requestHolder.get();
	}
	
	
	public static HttpSession getCurrentSession() throws IllegalStateException {
		return getRequest().getSession(true);
	}
	
	public static void setLoggedInUser(User loggedInUser, HttpServletResponse resp) throws IllegalStateException {
		HttpSession session = getCurrentSession();
		session.setAttribute(Constants.USER_KEY_IN_SESSION, loggedInUser);
	}
	
	public static User getLoggedInUser() throws IllegalStateException  {
		HttpSession session = getCurrentSession();
		User user =  (User)session.getAttribute(Constants.USER_KEY_IN_SESSION);
		if(user == null) {
			String cookieUser = getLoggedInUserCookie(getRequest());
			if(cookieUser != null && userDAO != null) {
				user = userDAO.findById(User.class, cookieUser);
			}
		}
		return user;
	}
	
	public static boolean isLoggedIn() {
		return getLoggedInUser() != null;
	}
	
	public static void setLoggedInUserCookie(String loggedInUser, HttpServletResponse resp) {
		if(loggedInUser != null) {
			Cookie userCookie = new Cookie("mid", loggedInUser);
			if(DOMAIN_SUFFIX != null) {
				userCookie.setDomain(DOMAIN_SUFFIX);
			}
			resp.addCookie(userCookie);
		}
	}
	
	public static String getLoggedInUserCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("mid")) {
					return c.getValue();
				}
			}
		}
		return null;
	}
}
