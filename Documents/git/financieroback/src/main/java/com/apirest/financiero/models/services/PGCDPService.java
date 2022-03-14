package com.apirest.financiero.models.services;
import com.apirest.financiero.models.dao.PGCDPDao;
import com.apirest.financiero.models.entity.PgCdp;
import com.apirest.financiero.models.entity.PgCdpPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import javax.sql.DataSource;

import java.util.List;

@Service
public class PGCDPService {
    @Autowired
    private PGCDPDao pgcdpDao;

    @Autowired
    // private DataSource dataSource;

    public List<PgCdp> findAllDesc() {
        return pgcdpDao.findAllDesc();
    }

    public PgCdp findById(PgCdpPK pgCdpPK) {
		return pgcdpDao.findById(pgCdpPK).orElse(null);
	}

    public long getConsecutivo(short anoCod) {
		return pgcdpDao.getConsecutivo(anoCod);
	}

    public PgCdp save(PgCdp pgCdp) {
		return pgcdpDao.save(pgCdp);
  }

/*        public byte[] exportSolicitudCDP(final String vigencia, final String codigo)
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
  }  */
}
