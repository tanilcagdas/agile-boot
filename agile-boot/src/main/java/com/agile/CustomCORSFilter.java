package com.agile;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CustomCORSFilter extends OncePerRequestFilter {

	private static final String ORIGIN = "Origin";

	public CustomCORSFilter() {
	}

	public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;

		if (req.getHeader(ORIGIN) != null) {

			response.setHeader("Access-Control-Allow-Origin", req.getHeaders("origin").nextElement().toString());

			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");

			String reqHead = req.getHeader("Access-Control-Request-Headers");

			// if (!StringUtils.isEmpty(reqHead)) {
			if (reqHead != null && reqHead.trim().length() > 0) {
				response.addHeader("Access-Control-Allow-Headers", reqHead);
			}
		}

		if (req.getMethod().equals("OPTIONS")) {
			try {
				response.getWriter().print("OK");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			chain.doFilter(req, response);
		}
	}

	public void destroy() {
	}

}
