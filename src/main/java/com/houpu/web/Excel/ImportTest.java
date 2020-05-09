package com.houpu.web.Excel;

import org.junit.Test;

public class ImportTest {
    @Test
    public void testImp() throws Exception{
        ExcelParse excelParse = new ExcelParse();
        excelParse.parse("D：\\供应商列表.xlsx");
    }
}
