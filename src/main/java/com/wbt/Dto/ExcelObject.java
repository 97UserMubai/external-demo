package com.wbt.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author wangbaitao
 * <h>ExcelObject</h>
 * @Date 2021/02/05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelObject {
    /**
     * 锚名称
     */
    private String anchorName;
    /**
     * Excel Stream
     */
    private Workbook workbook;
    /**
     * POI Excel
     */
    private Excel excel;

    public ExcelObject(String anchorName, Workbook workbook) {
        this.anchorName = anchorName;
        this.workbook = workbook;
        this.excel = new Excel(this.workbook);
    }
}