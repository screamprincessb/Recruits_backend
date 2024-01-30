package com.sense.service.util;

import com.sense.service.rest.report.response.ReportUtilResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import java.io.InputStream;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import org.apache.poi.ss.usermodel.*;

public class ReportUtil<T> {

    private JasperPrint jasperPrint;
    private String jasperRealPath;

    public static final String SEPARATOR = "/";
    public static final String PREFIX = ".jasper";
    public static final String PREFIX_PDF = ".pdf";
    public static final String PREFIX_XLS = ".xls";
    public static final String PREFIX_RTF = ".rtf";
    public static String CONTEXT_REAL_PATH = "";
    private static final String PREFIX_JASPER = ".jasper";
    public static final String LOGO_REPORT_PATH = "logo/logo_customs.png";
    public static final String TITLE = "title";
    public static final String SUB_TITLE1 = "subTitle1";
    public static final String SUB_TITLE2 = "subTitle2";
    public static final String SUB_TITLE3 = "subTitle3";
    public static final String SUB_TITLE4 = "subTitle4";
    public static final String REPORT_PATH = "reports";

    public ReportUtil() {
    }

    public void export(HttpServletResponse response, String exportType, String jasperName, String pdfCode, HashMap hashMap, Collection beanList) throws Exception {

        Connection conn = null;
        ReportUtilResponse rs = new ReportUtilResponse();

        try {

//            try {
//                conn = ConnDB.getConnection();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            InputStream inputStream = LoadConfig.class.getClassLoader().getResourceAsStream(REPORT_PATH.concat(SEPARATOR).concat(jasperName).concat(PREFIX));

            //   String xxx1 = LoadConfig.class.getClassLoader().getResource(LOGO_REPORT_PATH).toString();
            InputStream image = LoadConfig.class.getClassLoader().getResourceAsStream(LOGO_REPORT_PATH);

            hashMap.put("SUBREPORT_DIR", LoadConfig.class.getClassLoader().getResourceAsStream("").toString());
            hashMap.put("logo", image);

            String pdfName = pdfCode;

            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(beanList);
            jasperPrint = JasperFillManager.fillReport(inputStream, hashMap, beanCollectionDataSource);

            byte[] bytes = null;
            response.reset();
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "*");
            if ("xls".equals(exportType)) {

                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JRXlsxExporter excelExporter = new JRXlsxExporter();

                excelExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                excelExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
                excelExporter.exportReport();
                try {
                    bytes = baos.toByteArray();
                    rs.setContentType("application/xls");
                    response.setContentLength(bytes.length);
                    response.addHeader("Content-disposition", "attachment; inline; filename=" + pdfName + PREFIX_XLS);
                    response.getOutputStream().write(bytes, 0, bytes.length);
                    response.getOutputStream().flush();
                } finally {
                    response.getOutputStream().close();
                }
            } else if ("rtf".equals(exportType)) {

                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JRRtfExporter rtfExporter = new JRRtfExporter();
                rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                rtfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
                rtfExporter.exportReport();

                try {
                    bytes = baos.toByteArray();
                    rs.setContentType("application/rtf");
                    response.setContentLength(bytes.length);
                    response.addHeader("Content-disposition", "attachment; inline; filename=" + pdfName + PREFIX_RTF);
                    response.getOutputStream().write(bytes, 0, bytes.length);
                    response.getOutputStream().flush();
                } finally {
                    response.getOutputStream().close();
                }
            } else if ("pdf".equals(exportType)) {

                try {
                    bytes = JasperExportManager.exportReportToPdf(jasperPrint);
                    rs.setContentType("application/pdf");
                    response.setContentLength(bytes.length);
                    response.addHeader("Content-disposition", "attachment; inline; filename=" + pdfName + PREFIX_PDF);
                    response.getOutputStream().write(bytes, 0, bytes.length);
                    response.getOutputStream().flush();
                } finally {
                    response.getOutputStream().close();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
//            if (conn != null) {
//                ConnDB.closeConnection(conn);
//            }
        }
    }

    public JasperPrint exportMearge(String jasperName, String pdfCode, HashMap hashMap, List beanList) throws Exception {
        JasperPrint jasperPrintTmp = null;
        Connection conn = null;
        try {
//            try {
//                conn = ConnDB.getConnection();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            InputStream image = LoadConfig.class.getClassLoader().getResourceAsStream(LOGO_REPORT_PATH);
            hashMap.put("logo", image);

            //String xxx = LoadConfig.class.getClassLoader().getResource(jasperName.concat(PREFIX)).toString();
            InputStream inputStream = LoadConfig.class.getClassLoader().getResourceAsStream(REPORT_PATH.concat(SEPARATOR).concat(jasperName).concat(PREFIX));
            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(beanList);
            jasperPrintTmp = JasperFillManager.fillReport(inputStream, hashMap, beanCollectionDataSource);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (conn != null) {
                ConnDB.closeConnection(conn);
            }
        }
        return jasperPrintTmp;
    }

    public JasperPrint exportSubReportMearge(String[] jasperName, String pdfCode, HashMap hashMap, List beanList) throws Exception {
        JasperPrint jasperPrintTmp = null;
        Connection conn = null;
        try {
//            try {
//                conn = ConnDB.getConnection();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            InputStream inputStream = null;
            inputStream = LoadConfig.class.getClassLoader().getResourceAsStream(jasperName[0].concat(PREFIX));
            //   String xxx1 = LoadConfig.class.getClassLoader().getResource(LOGO_REPORT_PATH).toString();
            InputStream image = LoadConfig.class.getClassLoader().getResourceAsStream(LOGO_REPORT_PATH);

            hashMap.put("SUBREPORT_DIR", LoadConfig.class.getClassLoader().getResourceAsStream("").toString());
            hashMap.put("logo", image);
//            if (jasperName != null) {
//                for (int i = 1; i < jasperName.length; i++) {
//                    hashMap.put("SUBREPORT_DIR", LoadConfig.class.getClassLoader().getResource("").toString());
//                }
//            }
            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(beanList);
            jasperPrintTmp = JasperFillManager.fillReport(inputStream, hashMap, beanCollectionDataSource);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (conn != null) {
                ConnDB.closeConnection(conn);
            }
        }
        return jasperPrintTmp;
    }

    public void exportJasperPrintMearge(HttpServletResponse response, String exportType, String pdfName, List<JasperPrint> jasperPrintLst) throws Exception {

        Connection conn = null;
        ReportUtilResponse rs = new ReportUtilResponse();

        try {

//            try {
//                conn = ConnDB.getConnection();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            byte[] bytes = null;
            response.reset();
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "*");
            if ("xls".equals(exportType)) {

                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JRXlsExporter excelExporter = new JRXlsExporter();

                excelExporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintLst));
                excelExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
                excelExporter.exportReport();
                try {
                    bytes = baos.toByteArray();
                    rs.setContentType("application/xls");
                    response.setContentLength(bytes.length);
                    response.addHeader("Content-disposition", "attachment; inline; filename=" + pdfName + PREFIX_XLS);
                    response.getOutputStream().write(bytes, 0, bytes.length);
                    response.getOutputStream().flush();
                } finally {
                    response.getOutputStream().close();
                }
            } else if ("rtf".equals(exportType)) {

                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JRRtfExporter rtfExporter = new JRRtfExporter();
                rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrintLst);
                rtfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
                rtfExporter.exportReport();

                try {
                    bytes = baos.toByteArray();
                    rs.setContentType("application/rtf");
                    response.setContentLength(bytes.length);
                    response.addHeader("Content-disposition", "attachment; inline; filename=" + pdfName + PREFIX_RTF);
                    response.getOutputStream().write(bytes, 0, bytes.length);
                    response.getOutputStream().flush();
                } finally {
                    response.getOutputStream().close();
                }
            } else if ("pdf".equals(exportType)) {

                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JRPdfExporter exporter = new JRPdfExporter();

                exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintLst));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
                exporter.exportReport();

                try {
                    bytes = baos.toByteArray();
                    rs.setContentType("application/pdf");
                    response.setContentLength(bytes.length);
                    response.addHeader("Content-disposition", "attachment; inline; filename=" + pdfName + PREFIX_PDF);
                    response.getOutputStream().write(bytes, 0, bytes.length);
                    response.getOutputStream().flush();
                } finally {
                    response.getOutputStream().close();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (conn != null) {
                ConnDB.closeConnection(conn);
            }
        }
    }

    public void exportMulti(HttpServletResponse response, String exportType, String[] jasperNameLst, String pdfCode, HashMap hashMap, String reportPath) throws Exception {

        Connection conn = null;
        ReportUtilResponse rs = new ReportUtilResponse();

        try {

//            try {
//                conn = ConnDB.getConnection();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            List<JasperPrint> jasperPrintLst = new ArrayList<JasperPrint>();

            String path = new File(".").getCanonicalPath();
//            String pdfName = pdfCode.concat("-").concat(BackEndDateTimeUtil.dateToString(BackEndDateTimeUtil.getSystemDate(), "yyyyMMddHHmmss"));
            String pdfName = pdfCode;

            String jasperName = "";
            for (int i = 0; i < jasperNameLst.length; i++) {
                jasperName = jasperNameLst[i];
                jasperRealPath = path + reportPath + SEPARATOR + jasperName + PREFIX;
                jasperPrint = JasperFillManager.fillReport(jasperRealPath, hashMap, conn);
                jasperPrintLst.add(jasperPrint);
            }

            byte[] bytes = null;
            response.reset();
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "*");
            if ("xls".equals(exportType)) {

                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JRXlsxExporter excelExporter = new JRXlsxExporter();

                excelExporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintLst));
                excelExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
                excelExporter.exportReport();
                try {
                    bytes = baos.toByteArray();
                    rs.setContentType("application/xlsx");
                    response.setContentLength(bytes.length);
                    response.addHeader("Content-disposition", "attachment; inline; filename=" + pdfName + PREFIX_XLS);
                    response.getOutputStream().write(bytes, 0, bytes.length);
                    response.getOutputStream().flush();
                } finally {
                    response.getOutputStream().close();
                }
            } else if ("rtf".equals(exportType)) {

                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JRRtfExporter rtfExporter = new JRRtfExporter();
                rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrintLst);
                rtfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
                rtfExporter.exportReport();

                try {
                    bytes = baos.toByteArray();
                    rs.setContentType("application/rtf");
                    response.setContentLength(bytes.length);
                    response.addHeader("Content-disposition", "attachment; inline; filename=" + pdfName + PREFIX_RTF);
                    response.getOutputStream().write(bytes, 0, bytes.length);
                    response.getOutputStream().flush();
                } finally {
                    response.getOutputStream().close();
                }
            } else if ("pdf".equals(exportType)) {

                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JRPdfExporter exporter = new JRPdfExporter();

                exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintLst));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
                exporter.exportReport();

                try {
                    bytes = baos.toByteArray();
                    rs.setContentType("application/pdf");
                    response.setContentLength(bytes.length);
                    response.addHeader("Content-disposition", "attachment; inline; filename=" + pdfName + PREFIX_PDF);
                    response.getOutputStream().write(bytes, 0, bytes.length);
                    response.getOutputStream().flush();
                } finally {
                    response.getOutputStream().close();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (conn != null) {
                ConnDB.closeConnection(conn);
            }
        }
    }

    public void exportJRDataSource(String exportType, String jasperName, String exportName, HashMap hashMap,
            Collection collectionList, HttpServletResponse response, String reportPath) throws Exception {
        byte[] bytes = null;
        try {

            //Load report : .jasper file
            CONTEXT_REAL_PATH = new File(".").getCanonicalPath();
            String jasperRealPath = reportPath + File.separator + jasperName + PREFIX_JASPER;

            System.out.println("jasperRealPath :" + jasperRealPath);

            //JasperPrint :-
            JRBeanCollectionDataSource resultCollectionDataSource = new JRBeanCollectionDataSource(collectionList);
            JasperPrint jp = JasperFillManager.fillReport(jasperRealPath, hashMap, resultCollectionDataSource);

            response.reset();
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "*");

            bytes = null;
            if (exportType.equals("xls")) {

                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JRXlsxExporter excelExporter = new JRXlsxExporter();
                excelExporter.setExporterInput(new SimpleExporterInput(jp));
                excelExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
                excelExporter.exportReport();

                bytes = baos.toByteArray();

            } else if (exportType.equals("docx")) {
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JRDocxExporter docxExporter = new JRDocxExporter();
                docxExporter.setExporterInput(new SimpleExporterInput(jp));
                docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
                docxExporter.exportReport();

                bytes = baos.toByteArray();

            } else if (exportType.equals("pdf")) {

                bytes = JasperExportManager.exportReportToPdf(jp);
            }

            //export :-
            try {
                response.setContentType("application/" + exportType);
                response.setContentLength(bytes.length);
                response.addHeader("Content-disposition", "attachment; inline; filename=" + exportName + "." + exportType);
                response.getOutputStream().write(bytes, 0, bytes.length);
                response.getOutputStream().flush();
            } finally {
                response.getOutputStream().close();
            }

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            throw e;
        }

    }

    public String subTitle1(String deptNm) {
        return "หน่วยงาน ".concat("(").concat(deptNm).concat(")");
    }

    public String subCriDate(Date dateFrom, Date dateTo) {
        return "ตั้งแต่ วันที่ ".concat(DateTimeUtil.dateToStringReport(dateFrom)).concat(" ถึง วันที่ ").concat(DateTimeUtil.dateToStringReport(dateTo));
    }

    public String subCriMonthYearDate(Date dateFrom, Date dateTo) {
        return "ตั้งแต่ เดือน ".concat(DateTimeUtil.dateToStringReportMonthYear(dateFrom)).concat(" ถึง เดือน ").concat(DateTimeUtil.dateToStringReportMonthYear(dateTo));
    }

    public String subCriMonthYear(String monthFrom, String yearFrom, String monthTo, String yearTo) {
        return DateTimeUtil.converReportTitle(yearFrom, yearTo, monthFrom, monthTo);
    }

    public String subCriYear(String year) {
        return "ประจำปี ".concat(String.valueOf(Integer.valueOf(year) + 543));
    }

    public String subFiscalYear(String year) {
        return "ปีงบประมาณ ".concat(String.valueOf(Integer.valueOf(year) + 543));
    }

    public String footerDt(String userName) {
        return "พิมพ์เอกสาร วันที่ ".concat(DateTimeUtil.dateToString(DateTimeUtil.getSystemDate(), "dd/MM/yyyy HH:mm", new Locale("th", "TH"))).concat(" ผู้พิมพ์เอกสาร ").concat(userName);
    }

    public String footer(String userName) {
        return " ผู้พิมพ์เอกสาร ".concat(userName);
    }

    public String getLogo(String reportPath) throws Exception {
        try {
            CONTEXT_REAL_PATH = new File(".").getCanonicalPath();
            String logoPath = reportPath + File.separator + LOGO_REPORT_PATH;
            System.out.println("logoPath>>>>" + logoPath);
            return logoPath;
        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
