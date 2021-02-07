package com.wbt.Dto;

import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Sheet;

import java.awt.*;
import java.util.List;


/**
 * @author wangbaitao
 * <h>poi 图片 设置</h>
 * @Date 2021/02/05
 */
@Data
public class POIImage {
    protected Dimension dimension;
    protected byte[] bytes;
    protected ClientAnchor anchor;

    public POIImage getCellImage(Cell cell) {
        Sheet sheet = cell.getSheet();
        if (sheet instanceof HSSFSheet) {
            HSSFSheet hssfSheet = (HSSFSheet) sheet;
            if(hssfSheet.getDrawingPatriarch() == null) {
            	return this;
            }
            List<HSSFShape> shapes = hssfSheet.getDrawingPatriarch().getChildren();
            for (HSSFShape shape : shapes) {
                HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();
                if (shape instanceof HSSFPicture) {
                    HSSFPicture pic = (HSSFPicture) shape;
                    PictureData data = pic.getPictureData();
                    int row1 = anchor.getRow1();
                    int col1 = anchor.getCol1();
                    if(row1 == cell.getRowIndex() && col1 == cell.getColumnIndex()){
                        dimension = pic.getImageDimension();
                        this.anchor = anchor;
                        this.bytes = data.getData();
                    }
                }
            }
        }
        return this;
    }
}