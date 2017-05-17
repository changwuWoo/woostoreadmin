package org.edge.woostore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO
 * @author Administrator 
 * @date 2017年3月3日 下午8:25:10 
 *  
 */
public class CORSFilter implements Filter {
	 public CORSFilter() {
	 }


	 public void doFilter(ServletRequest request, ServletResponse response,
	 FilterChain chain) throws IOException, ServletException {


	 HttpServletResponse httpServletResponse = (HttpServletResponse) response;


	 httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:10608");


	 httpServletResponse
	 .setHeader(
	 "Access-Control-Allow-Headers",
	 "User-Agent,Origin,Cache-Control,Content-type,Date,Server,withCredentials,AccessTokenValidate");


	 httpServletResponse.setHeader("Access-Control-Allow-Credentials",
	 "true");


	 httpServletResponse.setHeader("Access-Control-Allow-Methods",
	 "GET, POST, PUT, DELETE, OPTIONS, HEAD");


	 httpServletResponse.setHeader("Access-Control-Max-Age", "1209600");


	 httpServletResponse.setHeader("Access-Control-Expose-Headers",
	 "accesstoken");


	 httpServletResponse.setHeader("Access-Control-Request-Headers",
	 "accesstoken");


	 httpServletResponse.setHeader("Expires", "-1");


	 httpServletResponse.setHeader("Cache-Control", "no-cache");


	 httpServletResponse.setHeader("pragma", "no-cache");


	 chain.doFilter(request, response);


	 }


	 public void init(FilterConfig fConfig) throws ServletException {

	 }


	 public void destroy() {
	 }


	}
