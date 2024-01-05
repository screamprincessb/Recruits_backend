package com.sense.service.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    private static final String FONT = "Tahoma";

    public static String getCellValue(Row row, int cellNo) {
        DataFormatter formatter = new DataFormatter();
        formatter.setUseCachedValuesForFormulaCells(true);
        Cell cell = row.getCell(cellNo);
        return formatter.formatCellValue(cell);
    }

    public static XSSFSheet ReadExcelNew(File ExcelFile) throws IOException, InvalidFormatException {

        XSSFWorkbook workBook = new XSSFWorkbook(ExcelFile);
        XSSFSheet worksheet = workBook.getSheetAt(0);

        return worksheet;
    }

    public static HSSFSheet ReadExcelOld(File ExcelFile) throws IOException, InvalidFormatException {

        FileInputStream fis = new FileInputStream(ExcelFile);
        HSSFWorkbook workBook = new HSSFWorkbook(fis);
        HSSFSheet worksheet = workBook.getSheetAt(0);

        return worksheet;
    }

    public static HSSFCellStyle getFontStyleByResult(HSSFWorkbook wb, String value) {

        HSSFCellStyle redStyle = getDStyle(wb);
        HSSFFont rFont = redStyle.getFont(wb);
        rFont.setColor(IndexedColors.RED.getIndex());
        redStyle.setAlignment(HorizontalAlignment.CENTER);
        redStyle.setFont(rFont);

        if (value == null) {
            return redStyle;
        }

        if (value.equals("Y")) {
            HSSFCellStyle blueStyle = getDStyle(wb);
            HSSFFont bFont = blueStyle.getFont(wb);
            bFont.setColor(IndexedColors.BLUE.getIndex());
            blueStyle.setAlignment(HorizontalAlignment.CENTER);
            blueStyle.setFont(bFont);
            return blueStyle;
        }

        return redStyle;

    }

    public static HSSFCellStyle getCStyle(HSSFWorkbook wb) {
        Font font = wb.createFont();
        font.setFontName(FONT);
        font.setFontHeightInPoints((short) 9);
        Font fontError = wb.createFont();
        fontError.setFontName(FONT);
        fontError.setFontHeightInPoints((short) 9);
        fontError.setColor(IndexedColors.WHITE.getIndex());

        HSSFFont cFont = wb.createFont();
        cFont.setFontName(FONT);
        cFont.setFontHeightInPoints((short) 9);
        cFont.setColor(IndexedColors.BLACK.getIndex());
        cFont.setBold(true);
        HSSFCellStyle cStyle = wb.createCellStyle();
        cStyle.setFont(cFont);
        cStyle.setAlignment(HorizontalAlignment.LEFT);
        cStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//                cStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
//                cStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cStyle.setBorderTop(BorderStyle.THIN);
        cStyle.setBorderLeft(BorderStyle.THIN);
        cStyle.setBorderRight(BorderStyle.THIN);
        cStyle.setBorderBottom(BorderStyle.THIN);
        return cStyle;
    }

    public static HSSFCellStyle getDStyle(HSSFWorkbook wb) {
        HSSFCellStyle dStyle = wb.createCellStyle();
        HSSFFont dFont = wb.createFont();
        dFont.setFontName(FONT);
        dStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dFont.setFontHeightInPoints((short) 9);
        dStyle.setFont(dFont);

        dStyle.setBorderTop(BorderStyle.THIN);
        dStyle.setBorderLeft(BorderStyle.THIN);
        dStyle.setBorderRight(BorderStyle.THIN);
        dStyle.setBorderBottom(BorderStyle.THIN);
        return dStyle;
    }

    public static HSSFCellStyle getLightGreenDStyle(HSSFWorkbook wb) {
        HSSFCellStyle dStyle = wb.createCellStyle();
        HSSFFont dFont = wb.createFont();
        dFont.setFontName(FONT);
        dStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dFont.setFontHeightInPoints((short) 9);
        dStyle.setFont(dFont);

        dStyle.setBorderTop(BorderStyle.THIN);
        dStyle.setBorderLeft(BorderStyle.THIN);
        dStyle.setBorderRight(BorderStyle.THIN);
        dStyle.setBorderBottom(BorderStyle.THIN);

        HSSFPalette palette = wb.getCustomPalette();
        palette.setColorAtIndex(HSSFColor.HSSFColorPredefined.LIGHT_GREEN.getIndex(), (byte) 197, (byte) 224, (byte) 190);
        dStyle.setFillForegroundColor(palette.getColor(HSSFColor.HSSFColorPredefined.LIGHT_GREEN.getIndex()).getIndex());
        dStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        dStyle.setWrapText(true);

        return dStyle;
    }

    public static HSSFCellStyle getBlueDStyle(HSSFWorkbook wb) {
        HSSFCellStyle dStyle = wb.createCellStyle();
        HSSFFont dFont = wb.createFont();
        dFont.setFontName(FONT);
        dStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dFont.setFontHeightInPoints((short) 9);
        dFont.setColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
        dStyle.setFont(dFont);

        dStyle.setBorderTop(BorderStyle.THIN);
        dStyle.setBorderLeft(BorderStyle.THIN);
        dStyle.setBorderRight(BorderStyle.THIN);
        dStyle.setBorderBottom(BorderStyle.THIN);
        return dStyle;
    }

    public static HSSFCellStyle getRedDStyle(HSSFWorkbook wb) {
        HSSFCellStyle dStyle = wb.createCellStyle();
        HSSFFont dFont = wb.createFont();
        dFont.setFontName(FONT);
        dStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dFont.setFontHeightInPoints((short) 9);
        dFont.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
        dStyle.setFont(dFont);

        dStyle.setBorderTop(BorderStyle.THIN);
        dStyle.setBorderLeft(BorderStyle.THIN);
        dStyle.setBorderRight(BorderStyle.THIN);
        dStyle.setBorderBottom(BorderStyle.THIN);
        return dStyle;
    }

    public static HSSFCellStyle getDSGreenBoldtyle(HSSFWorkbook wb) {
        HSSFCellStyle dStyle = wb.createCellStyle();
        HSSFFont dFont = wb.createFont();
        dFont.setFontName(FONT);
        dStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dFont.setFontHeightInPoints((short) 9);
        dFont.setBold(true);
        dFont.setColor(HSSFColor.HSSFColorPredefined.GREEN.getIndex());

        dStyle.setFont(dFont);

        dStyle.setBorderTop(BorderStyle.THIN);
        dStyle.setBorderLeft(BorderStyle.THIN);
        dStyle.setBorderRight(BorderStyle.THIN);
        dStyle.setBorderBottom(BorderStyle.THIN);

        return dStyle;
    }

    public static HSSFCellStyle getDSBlueBoldtyle(HSSFWorkbook wb) {
        HSSFCellStyle dStyle = wb.createCellStyle();
        HSSFFont dFont = wb.createFont();
        dFont.setFontName(FONT);
        dStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dFont.setFontHeightInPoints((short) 9);
        dFont.setBold(true);
        dFont.setColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());

        dStyle.setFont(dFont);

        dStyle.setBorderTop(BorderStyle.THIN);
        dStyle.setBorderLeft(BorderStyle.THIN);
        dStyle.setBorderRight(BorderStyle.THIN);
        dStyle.setBorderBottom(BorderStyle.THIN);

        return dStyle;
    }

    public static HSSFCellStyle getDSRedBoldtyle(HSSFWorkbook wb) {
        HSSFCellStyle dStyle = wb.createCellStyle();
        HSSFFont dFont = wb.createFont();
        dFont.setFontName(FONT);
        dStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dFont.setFontHeightInPoints((short) 9);
        dFont.setBold(true);
        dFont.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());

        dStyle.setFont(dFont);

        dStyle.setBorderTop(BorderStyle.THIN);
        dStyle.setBorderLeft(BorderStyle.THIN);
        dStyle.setBorderRight(BorderStyle.THIN);
        dStyle.setBorderBottom(BorderStyle.THIN);

        return dStyle;
    }

    public static HSSFCellStyle getDSBoldtyle(HSSFWorkbook wb) {
        HSSFCellStyle dStyle = wb.createCellStyle();
        HSSFFont dFont = wb.createFont();
        dFont.setFontName(FONT);
        dStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dFont.setFontHeightInPoints((short) 9);
        dFont.setBold(true);

        dStyle.setFont(dFont);

        dStyle.setBorderTop(BorderStyle.THIN);
        dStyle.setBorderLeft(BorderStyle.THIN);
        dStyle.setBorderRight(BorderStyle.THIN);
        dStyle.setBorderBottom(BorderStyle.THIN);

        return dStyle;
    }

    // WrapText
    public static HSSFCellStyle getWrapTextStyle(HSSFWorkbook wb) {
        HSSFCellStyle dStyle = wb.createCellStyle();
        HSSFFont dFont = wb.createFont();
        dFont.setFontName(FONT);
        dStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dFont.setFontHeightInPoints((short) 9);
        dStyle.setFont(dFont);
        dStyle.setWrapText(true);

        dStyle.setBorderTop(BorderStyle.THIN);
        dStyle.setBorderLeft(BorderStyle.THIN);
        dStyle.setBorderRight(BorderStyle.THIN);
        dStyle.setBorderBottom(BorderStyle.THIN);
        return dStyle;
    }

    //DarkGray Background Color
    public static HSSFCellStyle getDarkBGStyle(HSSFWorkbook wb) {
        HSSFCellStyle xStyle = wb.createCellStyle();
        xStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_40_PERCENT.getIndex());
        xStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        return xStyle;
    }

    //Red Background Color
    public static HSSFCellStyle getRedBGStyle(HSSFWorkbook wb) {
        HSSFCellStyle xStyle = wb.createCellStyle();
        HSSFFont xFont = wb.createFont();
        xFont.setFontName(FONT);
        xFont.setFontHeightInPoints((short) 9);
        xStyle.setFont(xFont);

        xStyle.setAlignment(HorizontalAlignment.CENTER);
        xStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        xStyle.setBorderTop(BorderStyle.THIN);
        xStyle.setBorderLeft(BorderStyle.THIN);
        xStyle.setBorderRight(BorderStyle.THIN);
        xStyle.setBorderBottom(BorderStyle.THIN);

        xStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
        xStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        return xStyle;
    }

    //Green Background Color
    public static HSSFCellStyle getGreenBGStyle(HSSFWorkbook wb) {
        HSSFCellStyle xStyle = wb.createCellStyle();
        HSSFFont xFont = wb.createFont();
        xFont.setFontName(FONT);
        xFont.setFontHeightInPoints((short) 9);
        xStyle.setFont(xFont);

        xStyle.setAlignment(HorizontalAlignment.CENTER);
        xStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        xStyle.setBorderTop(BorderStyle.THIN);
        xStyle.setBorderLeft(BorderStyle.THIN);
        xStyle.setBorderRight(BorderStyle.THIN);
        xStyle.setBorderBottom(BorderStyle.THIN);

        HSSFPalette palette = wb.getCustomPalette();
        palette.setColorAtIndex(HSSFColor.HSSFColorPredefined.LIGHT_GREEN.getIndex(), (byte) 146, (byte) 208, (byte) 80);
        xStyle.setFillForegroundColor(palette.getColor(HSSFColor.HSSFColorPredefined.LIGHT_GREEN.getIndex()).getIndex());
        xStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        return xStyle;
    }

    //Pink Background Color
    public static HSSFCellStyle getPinkBGStyle(HSSFWorkbook wb) {
        HSSFCellStyle xStyle = wb.createCellStyle();
        HSSFFont xFont = wb.createFont();
        xFont.setFontName(FONT);
        xFont.setBold(true);
        xFont.setFontHeightInPoints((short) 9);
        xStyle.setFont(xFont);

        xStyle.setAlignment(HorizontalAlignment.CENTER);
        xStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        xStyle.setBorderTop(BorderStyle.THIN);
        xStyle.setBorderLeft(BorderStyle.THIN);
        xStyle.setBorderRight(BorderStyle.THIN);
        xStyle.setBorderBottom(BorderStyle.THIN);

        HSSFPalette palette = wb.getCustomPalette();
        palette.setColorAtIndex(HSSFColor.HSSFColorPredefined.PINK.getIndex(), (byte) 230, (byte) 185, (byte) 184);
        xStyle.setFillForegroundColor(palette.getColor(HSSFColor.HSSFColorPredefined.PINK.getIndex()).getIndex());
        xStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        xStyle.setWrapText(true);

        return xStyle;
    }
    
    
        //Green Background Color
    public static HSSFCellStyle getBlueBGStyle(HSSFWorkbook wb) {
        HSSFCellStyle xStyle = wb.createCellStyle();
        HSSFFont xFont = wb.createFont();
        xFont.setFontName(FONT);
        xFont.setFontHeightInPoints((short) 9);
        xStyle.setFont(xFont);
        xFont.setBold(true);

        xStyle.setAlignment(HorizontalAlignment.CENTER);
        xStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        xStyle.setBorderTop(BorderStyle.THIN);
        xStyle.setBorderLeft(BorderStyle.THIN);
        xStyle.setBorderRight(BorderStyle.THIN);
        xStyle.setBorderBottom(BorderStyle.THIN);

        HSSFPalette palette = wb.getCustomPalette();
        palette.setColorAtIndex(HSSFColor.HSSFColorPredefined.LIGHT_BLUE.getIndex(), (byte) 153, (byte) 204, (byte) 255);
        xStyle.setFillForegroundColor(palette.getColor(HSSFColor.HSSFColorPredefined.LIGHT_BLUE.getIndex()).getIndex());
        xStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        return xStyle;
    }
    
        public static HSSFCellStyle getLightCornflowerBGStyle(HSSFWorkbook wb) {
        HSSFCellStyle xStyle = wb.createCellStyle();
        HSSFFont xFont = wb.createFont();
        xFont.setFontName(FONT);
        xFont.setFontHeightInPoints((short) 9);
        xStyle.setFont(xFont);
        xFont.setBold(true);

        xStyle.setAlignment(HorizontalAlignment.CENTER);
        xStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        xStyle.setBorderTop(BorderStyle.THIN);
        xStyle.setBorderLeft(BorderStyle.THIN);
        xStyle.setBorderRight(BorderStyle.THIN);
        xStyle.setBorderBottom(BorderStyle.THIN);

        HSSFPalette palette = wb.getCustomPalette();
        palette.setColorAtIndex(HSSFColor.HSSFColorPredefined.LIGHT_CORNFLOWER_BLUE.getIndex(), (byte) 204, (byte) 204, (byte) 255);
        xStyle.setFillForegroundColor(palette.getColor(HSSFColor.HSSFColorPredefined.LIGHT_CORNFLOWER_BLUE.getIndex()).getIndex());
        xStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        return xStyle;
    }
    
    

    public static void generateCell(HSSFCell cell, Object rowData, String defaultIfNull) {
        if (rowData == null) {
            cell.setCellType(CellType.BLANK);
            cell.setCellValue(defaultIfNull);
        } else if (rowData instanceof Double) {
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue((Double) rowData);
        } else if (rowData instanceof Integer) {
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue((Integer) rowData);
        } else if (rowData instanceof BigDecimal) {
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue(((Number) rowData).doubleValue());
        } else if (rowData instanceof Boolean) {
            cell.setCellType(CellType.BOOLEAN);
            cell.setCellValue((Boolean) rowData);
        } else if (rowData instanceof String) {
            cell.setCellType(CellType.STRING);
//            cell.setCellStyle(stringStyle);
            cell.setCellValue(String.valueOf(rowData));
//            System.out.println("-" + String.valueOf(rowData));
        } else {
            cell.setCellType(CellType.STRING);
            cell.setCellValue(String.valueOf(rowData));
        }
    }

    public static String formatCell(HSSFCell cell) {

        if (cell == null) {
            return "";
        }

        if (cell.getCellType() == CellType.FORMULA) {
            return cell.getCellFormula();
        }

        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        }

        if (cell.getCellType() == CellType.NUMERIC) {
            DecimalFormat fomtt = new DecimalFormat("###");
            return fomtt.format(cell.getNumericCellValue());
        }

        return "";

    }

    public String excelFormatString(String formatString) {
        return "NotNum" + formatString;
    }

    public String excelFormatNumber(String formatNumber) {
        return "Number" + formatNumber;
    }

    public static HSSFCellStyle getLightGreenDStyleLR003H(HSSFWorkbook wb) {
        HSSFCellStyle dStyle = wb.createCellStyle();
        HSSFFont dFont = wb.createFont();
        dFont.setFontName(FONT);
        dStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dFont.setFontHeightInPoints((short) 9);
        dStyle.setFont(dFont);
        dFont.setBold(true);

        dStyle.setBorderTop(BorderStyle.THIN);
        dStyle.setBorderLeft(BorderStyle.THIN);
        dStyle.setBorderRight(BorderStyle.THIN);
        dStyle.setBorderBottom(BorderStyle.THIN);

        HSSFPalette palette = wb.getCustomPalette();
        palette.setColorAtIndex(HSSFColor.HSSFColorPredefined.LIGHT_GREEN.getIndex(), (byte) 121, (byte) 238, (byte) 201);
        dStyle.setFillForegroundColor(palette.getColor(HSSFColor.HSSFColorPredefined.LIGHT_GREEN.getIndex()).getIndex());
        dStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        dStyle.setWrapText(true);

        return dStyle;
    }

    public static HSSFCellStyle getLightGreenDStyleLR003T(HSSFWorkbook wb) {
        HSSFCellStyle dStyle = wb.createCellStyle();
        HSSFFont dFont = wb.createFont();
        dFont.setFontName(FONT);
        dStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dFont.setFontHeightInPoints((short) 9);
        dStyle.setFont(dFont);

        dStyle.setBorderTop(BorderStyle.THIN);
        dStyle.setBorderLeft(BorderStyle.THIN);
        dStyle.setBorderRight(BorderStyle.THIN);
        dStyle.setBorderBottom(BorderStyle.THIN);

        HSSFPalette palette = wb.getCustomPalette();
        palette.setColorAtIndex(HSSFColor.HSSFColorPredefined.GREEN.getIndex(), (byte) 126, (byte) 248, (byte) 11);
        dStyle.setFillForegroundColor(palette.getColor(HSSFColor.HSSFColorPredefined.GREEN.getIndex()).getIndex());
        dStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        dStyle.setWrapText(true);

        return dStyle;
    }

    public static HSSFCellStyle getDStyleLR007(HSSFWorkbook wb, Integer hssfCellFontType) {


        HSSFFont hFont01 = wb.createFont();
        hFont01.setFontName(FONT);//ชนิดอักษร Tahoma
        hFont01.setFontHeightInPoints((short) 9);//ขนาดอักษร 9


        switch (hssfCellFontType) {
            case 1:
                //รูปแบบที่  1 ช่องไม่มีเส้น ตัวอักษรตรงกลาง หนา 
                HSSFCellStyle hStylePatten01 = wb.createCellStyle();
                hFont01.setBold(true);//ลักษณะอักษรธรรมดา
                hStylePatten01.setFont(hFont01);
                hStylePatten01.setBorderTop(BorderStyle.NONE);//ขอบบนไม่มีเส้น
                hStylePatten01.setBorderBottom(BorderStyle.NONE);//ขอบล่างไม่มีเส้น
                hStylePatten01.setBorderLeft(BorderStyle.NONE);//ขอบซ้ายไม่มีเส้น
                hStylePatten01.setBorderRight(BorderStyle.NONE);//ขอบขวาไม่มีเส้น
                hStylePatten01.setAlignment(HorizontalAlignment.CENTER);
                hStylePatten01.setVerticalAlignment(VerticalAlignment.CENTER);
                return hStylePatten01;

            case 2:
                //รูปแบบที่  2 ช่องไม่มีเส้น ตัวอักษรตรงกลาง บาง
                HSSFCellStyle hStylePatten02 = wb.createCellStyle();
                hStylePatten02.setFont(hFont01);
                hStylePatten02.setBorderTop(BorderStyle.NONE);//ขอบบนไม่มีเส้น
                hStylePatten02.setBorderBottom(BorderStyle.NONE);//ขอบล่างไม่มีเส้น
                hStylePatten02.setBorderLeft(BorderStyle.NONE);//ขอบซ้ายไม่มีเส้น
                hStylePatten02.setBorderRight(BorderStyle.NONE);//ขอบขวาไม่มีเส้น
                hStylePatten02.setAlignment(HorizontalAlignment.CENTER);
                hStylePatten02.setVerticalAlignment(VerticalAlignment.CENTER);
                return hStylePatten02;

            case 3:
                //รูปแบบที่  3 ช่องไม่มีเส้น ตัวอักษรชิดซ้าย หนา
                HSSFCellStyle hStylePatten03 = wb.createCellStyle();
                hFont01.setBold(true);//ลักษณะอักษรธรรมดา
                hStylePatten03.setFont(hFont01);
                hStylePatten03.setBorderTop(BorderStyle.NONE);//ขอบบนไม่มีเส้น
                hStylePatten03.setBorderBottom(BorderStyle.NONE);//ขอบล่างไม่มีเส้น
                hStylePatten03.setBorderLeft(BorderStyle.NONE);//ขอบซ้ายไม่มีเส้น
                hStylePatten03.setBorderRight(BorderStyle.NONE);//ขอบขวาไม่มีเส้น
                hStylePatten03.setAlignment(HorizontalAlignment.LEFT);
                hStylePatten03.setVerticalAlignment(VerticalAlignment.CENTER);
                return hStylePatten03;

            case 4:
                //รูปแบบที่  4 ช่องไม่มีเส้น ตัวอักษรชิดซ้าย บาง
                HSSFCellStyle hStylePatten04 = wb.createCellStyle();
                hStylePatten04.setFont(hFont01);
                hStylePatten04.setBorderTop(BorderStyle.NONE);//ขอบบนไม่มีเส้น
                hStylePatten04.setBorderBottom(BorderStyle.NONE);//ขอบล่างไม่มีเส้น
                hStylePatten04.setBorderLeft(BorderStyle.NONE);//ขอบซ้ายไม่มีเส้น
                hStylePatten04.setBorderRight(BorderStyle.NONE);//ขอบขวาไม่มีเส้น
                hStylePatten04.setAlignment(HorizontalAlignment.LEFT);
                hStylePatten04.setVerticalAlignment(VerticalAlignment.CENTER);
                return hStylePatten04;

            case 5:
                //รูปแบบที่  5 ช่องไม่มีเส้น ตัวอักษรชิดขวา หนา
                HSSFCellStyle hStylePatten05 = wb.createCellStyle();
                hFont01.setBold(true);//ลักษณะอักษรธรรมดา
                hStylePatten05.setFont(hFont01);
                hStylePatten05.setBorderTop(BorderStyle.NONE);//ขอบบนไม่มีเส้น
                hStylePatten05.setBorderBottom(BorderStyle.NONE);//ขอบล่างไม่มีเส้น
                hStylePatten05.setBorderLeft(BorderStyle.NONE);//ขอบซ้ายไม่มีเส้น
                hStylePatten05.setBorderRight(BorderStyle.NONE);//ขอบขวาไม่มีเส้น
                hStylePatten05.setAlignment(HorizontalAlignment.RIGHT);
                hStylePatten05.setVerticalAlignment(VerticalAlignment.CENTER);
                return hStylePatten05;

            case 6:
                //รูปแบบที่  6 ช่องไม่มีเส้น ตัวอักษรชิดขวา บาง
                HSSFCellStyle hStylePatten06 = wb.createCellStyle();
                hStylePatten06.setFont(hFont01);
                hStylePatten06.setBorderTop(BorderStyle.NONE);//ขอบบนไม่มีเส้น
                hStylePatten06.setBorderBottom(BorderStyle.NONE);//ขอบล่างไม่มีเส้น
                hStylePatten06.setBorderLeft(BorderStyle.NONE);//ขอบซ้ายไม่มีเส้น
                hStylePatten06.setBorderRight(BorderStyle.NONE);//ขอบขวาไม่มีเส้น
                hStylePatten06.setAlignment(HorizontalAlignment.RIGHT);
                hStylePatten06.setVerticalAlignment(VerticalAlignment.CENTER);
                return hStylePatten06;

            case 7:

                //รูปแบบที่  7 ช่องมีเส้น ตัวอักษรตรงกลาง หนา 
                HSSFCellStyle hStylePatten07 = wb.createCellStyle();
                hFont01.setBold(true);//ลักษณะอักษรธรรมดา
                hStylePatten07.setFont(hFont01);
                hStylePatten07.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten07.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten07.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten07.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten07.setAlignment(HorizontalAlignment.CENTER);
                hStylePatten07.setVerticalAlignment(VerticalAlignment.CENTER);
                return hStylePatten07;

            case 8:
                //รูปแบบที่  8 ช่องมีเส้น ตัวอักษรตรงกลาง บาง
                HSSFCellStyle hStylePatten08 = wb.createCellStyle();
                hStylePatten08.setFont(hFont01);
                hStylePatten08.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten08.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten08.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten08.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten08.setAlignment(HorizontalAlignment.CENTER);
                hStylePatten08.setVerticalAlignment(VerticalAlignment.CENTER);
                return hStylePatten08;

            case 9:
                //รูปแบบที่  9 ช่องมีเส้น ตัวอักษรชิดซ้าย หนา
                HSSFCellStyle hStylePatten09 = wb.createCellStyle();
                hFont01.setBold(true);//ลักษณะอักษรธรรมดา
                hStylePatten09.setFont(hFont01);
                hStylePatten09.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten09.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten09.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten09.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten09.setAlignment(HorizontalAlignment.LEFT);
                hStylePatten09.setVerticalAlignment(VerticalAlignment.CENTER);
                return hStylePatten09;

            case 10:
                //รูปแบบที่ 10 ช่องมีเส้น ตัวอักษรชิดซ้าย บาง
                HSSFCellStyle hStylePatten10 = wb.createCellStyle();
                hStylePatten10.setFont(hFont01);
                hStylePatten10.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten10.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten10.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten10.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten10.setAlignment(HorizontalAlignment.LEFT);
                hStylePatten10.setVerticalAlignment(VerticalAlignment.CENTER);
                return hStylePatten10;

            case 11:
                //รูปแบบที่ 11 ช่องมีเส้น ตัวอักษรชิดขวา หนา
                HSSFCellStyle hStylePatten11 = wb.createCellStyle();
                hFont01.setBold(true);//ลักษณะอักษรธรรมดา
                hStylePatten11.setFont(hFont01);
                hStylePatten11.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten11.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten11.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten11.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten11.setAlignment(HorizontalAlignment.RIGHT);
                hStylePatten11.setVerticalAlignment(VerticalAlignment.CENTER);
                return hStylePatten11;

            case 12:
                //รูปแบบที่ 12 ช่องมีเส้น ตัวอักษรชิดขวา บาง
                HSSFCellStyle hStylePatten12 = wb.createCellStyle();
                hStylePatten12.setFont(hFont01);
                hStylePatten12.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten12.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten12.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten12.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten12.setAlignment(HorizontalAlignment.RIGHT);
                hStylePatten12.setVerticalAlignment(VerticalAlignment.CENTER);
                return hStylePatten12;

            case 13:
                //รูปแบบที่ 13 ช่องมีเส้น ตัวอักษรกลาง บาง พื้นสีเทา
                HSSFCellStyle hStylePatten13 = wb.createCellStyle();
                hStylePatten13.setFont(hFont01);
                hStylePatten13.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten13.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten13.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten13.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten13.setAlignment(HorizontalAlignment.CENTER);
                hStylePatten13.setVerticalAlignment(VerticalAlignment.CENTER);
                hStylePatten13.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                hStylePatten13.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//                hStylePatten13.setWrapText(true);
                return hStylePatten13;

            case 14:
                //รูปแบบที่ 14 ช่องมีเส้น ตัวอักษรซ้าย บาง พื้นสีเทา
                HSSFCellStyle hStylePatten14 = wb.createCellStyle();
                hStylePatten14.setFont(hFont01);
                hStylePatten14.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten14.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten14.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten14.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten14.setAlignment(HorizontalAlignment.LEFT);
                hStylePatten14.setVerticalAlignment(VerticalAlignment.CENTER);
                hStylePatten14.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                hStylePatten14.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//                hStylePatten14.setWrapText(true);
                return hStylePatten14;

            case 15:
                //รูปแบบที่ 15 ช่องมีเส้น ตัวอักษรชิดขวา บาง พื้นสีเทา
                HSSFCellStyle hStylePatten15 = wb.createCellStyle();
                hStylePatten15.setFont(hFont01);
                hStylePatten15.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten15.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten15.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten15.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten15.setAlignment(HorizontalAlignment.RIGHT);
                hStylePatten15.setVerticalAlignment(VerticalAlignment.CENTER);
                hStylePatten15.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                hStylePatten15.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//                hStylePatten15.setWrapText(true);
                return hStylePatten15;

            case 16:
                //รูปแบบที่ 16 ช่องมีเส้น ตัวอักษรชิดขวา บาง พื้นสีเทา
                HSSFCellStyle hStylePatten16 = wb.createCellStyle();
                hStylePatten16.setFont(hFont01);
                hStylePatten16.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten16.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten16.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten16.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten16.setAlignment(HorizontalAlignment.CENTER);
                hStylePatten16.setVerticalAlignment(VerticalAlignment.CENTER);
                hStylePatten16.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
                hStylePatten16.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//                hStylePatten16.setWrapText(true);
                return hStylePatten16;

            case 17:
                //รูปแบบที่ 17 ช่องมีเส้น ตัวอักษรกลาง หนา พื้นสีเทา
                HSSFCellStyle hStylePatten17 = wb.createCellStyle();
                hFont01.setBold(true);//ลักษณะอักษรธรรมดา
                hStylePatten17.setFont(hFont01);
                hStylePatten17.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten17.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten17.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten17.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten17.setAlignment(HorizontalAlignment.CENTER);
                hStylePatten17.setVerticalAlignment(VerticalAlignment.CENTER);
                hStylePatten17.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                hStylePatten17.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//                hStylePatten17.setWrapText(true);
                return hStylePatten17;

            case 18:
                //รูปแบบที่  18 ช่องมีเส้น ตัวอักษรตรงกลาง บาง
                HSSFCellStyle hStylePatten18 = wb.createCellStyle();
                hStylePatten18.setFont(hFont01);
                hStylePatten18.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten18.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten18.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten18.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten18.setAlignment(HorizontalAlignment.CENTER);
                hStylePatten18.setVerticalAlignment(VerticalAlignment.TOP);
                return hStylePatten18;

            case 19:
                //รูปแบบที่ 19 ช่องมีเส้น ตัวอักษรขวา บาง 
                HSSFCellStyle hStylePatten19 = wb.createCellStyle();
                hStylePatten19.setFont(hFont01);
                hStylePatten19.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten19.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten19.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten19.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten19.setAlignment(HorizontalAlignment.RIGHT);
                hStylePatten19.setVerticalAlignment(VerticalAlignment.CENTER);
//            hStylePatten19.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
//            hStylePatten19.setFillPattern(CellStyle.SOLID_FOREGROUND);
//                hStylePatten19.setWrapText(true);
                return hStylePatten19;

            case 20:
                //รูปแบบที่ 20 ช่องมีเส้น ตัวอักษรกลาง บาง 
                HSSFCellStyle hStylePatten20 = wb.createCellStyle();
                hStylePatten20.setFont(hFont01);
                hStylePatten20.setBorderTop(BorderStyle.THIN);//ขอบบนไม่มีเส้น
                hStylePatten20.setBorderBottom(BorderStyle.THIN);//ขอบล่างไม่มีเส้น
                hStylePatten20.setBorderLeft(BorderStyle.THIN);//ขอบซ้ายไม่มีเส้น
                hStylePatten20.setBorderRight(BorderStyle.THIN);//ขอบขวาไม่มีเส้น
                hStylePatten20.setAlignment(HorizontalAlignment.CENTER);
                hStylePatten20.setVerticalAlignment(VerticalAlignment.CENTER);
//            hStylePatten19.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
//            hStylePatten19.setFillPattern(CellStyle.SOLID_FOREGROUND);
//                hStylePatten20.setWrapText(true);
                return hStylePatten20;

            default:
                return null;

        }

    }

    public static boolean sheach_number(int sheach, int[] indexpoint) {
        int i = 0;
        boolean sh = false;
        while ((!sh) && (i < indexpoint.length)) {
            if (indexpoint[i] == sheach) {
                sh = true;
                i = indexpoint.length;
            } else {
                sh = false;
            }
            i += 1;
        }
        return sh;
    }
}
