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
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.export.*;
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


    @RequestMapping(value = "/pdf1")
    public void pdf(Map<String, Object> parameters, HttpServletResponse response) {
        jasperService.pdf1(parameters, response);
    }

    @RequestMapping(value = "/xml1")
    public void exportToExcel(HttpServletResponse response, Map<String, Object> parameters) throws Exception {
        try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=UTF8");
            ClassPathResource resource = new ClassPathResource("jasper/myDemo.jasper");
            List<Jasper> list = jasperDao.findAll();
            list.forEach(jasper -> System.out.println(jasper));
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
            InputStream in = resource.getInputStream();
            JasperPrint jasperPrint = JasperFillManager.fillReport(in, parameters, dataSource);
            SimpleXlsExporterConfiguration con = new SimpleXlsExporterConfiguration();

            JRXlsExporter jrXlsExporter = new JRXlsExporter();
            jrXlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            // 設定輸出流
            jrXlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
            jrXlsExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            jrXlsExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF8");
            jrXlsExporter.exportReport();
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
