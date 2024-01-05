package com.sense.backend.hb.bean.excel;

import lombok.Data;

@Data
public class ExcelBean {

    private String type;
    private Integer row;
    private Integer col;
    private String dataValue;
    private String dataType;
    private String mergeCell = "0";

    private int hssfCellFontType = 1;
    //ตัวแปรสำหรับบอกชนิดของข้อมูล  0 = String, 1 = NUMBERIC
    private int hssfCellType = 0;

    public ExcelBean() {
    }

    public ExcelBean(Integer row, Integer col, String dataValue, String dataType) {
        this.row = row;
        this.col = col;
        this.dataValue = dataValue;
        this.dataType = dataType;
    }

    public ExcelBean(Integer row, Integer col, String dataValue, String mergecell, int fonttype, int datatype) {
        this.row = row;
        this.col = col;
        this.dataValue = dataValue;
        this.mergeCell = mergecell;
        this.hssfCellType = datatype;
        this.hssfCellFontType = fonttype;
    }

}
