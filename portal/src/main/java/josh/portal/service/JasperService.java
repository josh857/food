package josh.portal.service;

import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public interface JasperService {
    public void pdf1(Map<String,Object> parameters, HttpServletResponse response);
}
