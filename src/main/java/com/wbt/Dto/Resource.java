package com.wbt.Dto;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFFont;

/**
 * @author wangbaitao
 * <h>设置字体资源</h>
 * @Date 2021/02/05
 */
@Slf4j
public class Resource {
    /**
     * 中文字体支持
     */
    protected static BaseFont BASE_FONT_CHINESE;

    static {
        try {
            BASE_FONT_CHINESE = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            //进行系统资源注册
            FontFactory.registerDirectories();
        } catch (Exception e) {
            log.error("iText系统资源注册失败", e);
        }
    }

    /**
     * 进行iText字体转换
     *
     * @param font excel font
     * @return Font
     */
    public static Font getFont(XSSFFont font) {
        try {
            return FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED,
                    font.getFontHeightInPoints());
        } catch (Exception e) {
            log.error("iText字体转换失败", e);
        }
        return null;
    }
}