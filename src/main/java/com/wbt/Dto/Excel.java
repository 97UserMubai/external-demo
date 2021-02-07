package com.wbt.Dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author wangbaitao
 * <h>excel数据实体</h>
 * @Date 2021/02/05
 */
@Slf4j
@Data
public class Excel {

    protected Workbook wb;
    protected Sheet sheet;

    public Excel(Workbook wb) {
        try {
            this.wb = wb;
            this.sheet = wb.getSheetAt(wb.getActiveSheetIndex());
        } catch (Exception ex) {
            log.error("Excel实体初始化失败", ex);
        }
    }
}
