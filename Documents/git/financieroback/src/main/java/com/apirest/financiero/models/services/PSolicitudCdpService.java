package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPSolicitudCdpDao;
import com.apirest.financiero.models.entity.PGSolicitudCDP;
import com.apirest.financiero.models.entity.PGSolicitudCDPPK;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.sf.jasperreports.engine.JRException;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Paths;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import java.util.List;

@Service
public class PSolicitudCdpService{
    @Autowired
    private IPSolicitudCdpDao iPSolicitudCdpDao;

    @Autowired
    private DataSource dataSource;

  public List<PGSolicitudCDP> findAllDesc() {
        return iPSolicitudCdpDao.findAllDesc();
    }

  public List<PGSolicitudCDP> findAll(){
      return iPSolicitudCdpDao.findAll();
  }

  public List<PGSolicitudCDP> findByAnoCod(short anoCod, long ScdpCod) {
      return iPSolicitudCdpDao.findByAnoCod(anoCod, ScdpCod);
  }

  public PGSolicitudCDP findById(PGSolicitudCDPPK pGSolicitudCDPPK) {
		return iPSolicitudCdpDao.findById(pGSolicitudCDPPK).orElse(null);
	}

  public List<JSONObject> findValores(short anoCod, long scdpCod){
    return iPSolicitudCdpDao.findValores(anoCod, scdpCod);
  }

  public long getConsecutivo(short anoCod) {
		return iPSolicitudCdpDao.getConsecutivo(anoCod);
	}

    public PGSolicitudCDP save(PGSolicitudCDP pGSolicitudCDP) {
		return iPSolicitudCdpDao.save(pGSolicitudCDP);
  }
  
     public byte[] exportSolicitudCDP(final String vigencia, final String codigo)
    throws JRException, FileNotFoundException, SQLException {
    try (Connection conn = dataSource.getConnection()) {
      final ByteArrayOutputStream pdfBuffer = new ByteArrayOutputStream();
      Path file = Paths
        .get("./resources/")
        .resolve("FI_SolicitudCDP.jrxml")
        .toAbsolutePath();
      System.out.println(file.toString());
      JasperReport jasperReport = JasperCompileManager.compileReport(
        file.toString()
      );
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("vigencia", vigencia);
      parameters.put("codigo", codigo);
      parameters.put("ruta", "./resources/");
      JasperPrint jasperPrint = JasperFillManager.fillReport(
        jasperReport,
        parameters,
        conn
      );
      JasperExportManager.exportReportToPdfStream(jasperPrint, pdfBuffer);
      return pdfBuffer.toByteArray();
    } catch (Exception e) {
      return null;
    }
  }   
}
