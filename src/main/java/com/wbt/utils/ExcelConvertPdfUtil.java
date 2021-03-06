package com.wbt.utils;

import com.itextpdf.text.RectangleReadOnly;
import com.wbt.Dto.Excel2Pdf;
import com.wbt.Dto.ExcelObject;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.OutputStream;

/**
 * excel转pdf工具类
 */
public class ExcelConvertPdfUtil {
    /**
     * excel转为pdf并导出
     */
    public static void convertPdf(Workbook workbook, OutputStream out, RectangleReadOnly pageSize) throws Exception {
        ExcelObject object = new ExcelObject(null, workbook);
        Excel2Pdf pdf = new Excel2Pdf(object, out, pageSize);
        pdf.convert();
    }
}
