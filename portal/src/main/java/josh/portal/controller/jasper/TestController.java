package josh.portal.controller.jasper;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import josh.portal.dao.jasper.JasperDao;
import josh.portal.entity.jasper.Jasper;
import josh.portal.service.Impl.JasperServiceImpl;
import josh.portal.service.JasperService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
public class TestController {

  @Autowired
  JasperService jasperService;
@Autowired
JasperDao jasperDao;


    @RequestMapping (value = "/pdf1")
    public void pdf(Map<String,Object> parameters, HttpServletResponse response) {
        jasperService.pdf1(parameters,response);
    }


}
