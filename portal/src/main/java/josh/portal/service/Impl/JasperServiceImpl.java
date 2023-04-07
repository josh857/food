package josh.portal.service.Impl;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import josh.portal.dao.jasper.JasperDao;
import josh.portal.entity.jasper.Jasper;
import josh.portal.service.JasperService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
@Service
public class JasperServiceImpl implements JasperService {

   @Autowired
    JasperDao jasperDao;


    public void pdf1(Map<String,Object> parameters, HttpServletResponse response)  {
        ServletOutputStream os= null;
        try{
            os = response.getOutputStream();

            List<Jasper> list =jasperDao.findAll();

            list.forEach(jasper -> System.out.println(jasper));

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);

            ClassPathResource resource = new ClassPathResource("jasper/myDemo.jasper");

            response.setContentType("application/pdf");

            InputStream in = resource.getInputStream();

            JasperPrint jasperPrint = JasperFillManager.fillReport(in,parameters,dataSource);

            JasperExportManager.exportReportToPdfStream(jasperPrint,os);
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

