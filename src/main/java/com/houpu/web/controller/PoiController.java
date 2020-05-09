package com.houpu.web.controller;

import com.houpu.domain.Provider;
import com.houpu.domain.Result;
import com.houpu.domain.User;
import com.houpu.service.ProviderService;
import com.houpu.utils.DownloadUtil;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.houpu.web.Excel.PoiTest.getCellValue;

@Controller
@RequestMapping("/poi")
public class PoiController {
    @Autowired
    private ProviderService providerService;
    /* //百万导出excel数据
   @RequestMapping("/printProvider")
   public void printProvider(HttpServletResponse response) throws Exception{
       //从数据库拿所有信息
       List<Provider> providerList = providerService.findAllProvider();

       //1.创建工作薄
       SXSSFWorkbook workbook = new SXSSFWorkbook();
       //2.创建Sheet
       Sheet sheet = workbook.createSheet("供应商列表");
       //3.开始创建行
       int index=0;
       //3.1单元格合并
       Row row = sheet.createRow(index++);
       //firstRow:合并的首行索引；last:合并的尾行索引
       //firstCol:合并的首列索引；last:合并的尾列索引
       sheet.addMergedRegion(new CellRangeAddress(0,0,0,7));
       Cell cell = row.createCell(0);
       cell.setCellValue("供应商列表信息");
       cell.setCellStyle(bigTitle(workbook));

       //3.2表头
       row = sheet.createRow(index++);
       String [] headerNames = {"供应商编号","供应商名称","供应商描述","联系 人","联系电话","联系地址","传真","创建日期"};

       //循环数组 将标题直接赋值到小标题上
       for(int i = 0 ; i < headerNames.length ; i++){
            //每一个单元格
           cell = row.createCell(i);
           cell.setCellValue(headerNames[i]);//赋值内容
           cell.setCellStyle( title(workbook) ); //设置样式
            // 设置所有列宽
           sheet.setColumnWidth(i,20*256);
       }
       // 4.3 导入数据部分
          //遍历 index ==2
          //每一个Provider 表示一行数据
       for (Provider provider : providerList) {


           for (int i = 0; i <10000 ; i++) {
               row = sheet.createRow( index ++); //循环创建行对象
               // 编号
               cell = row.createCell(0);
               cell.setCellValue(provider.getProCode());

               // 名称
               cell = row.createCell(1);
               cell.setCellValue(provider.getProName());

               // 描述
               cell = row.createCell(2);
               cell.setCellValue(provider.getProDesc());

               // 联系人
               cell = row.createCell(3);
               cell.setCellValue(provider.getProContact());

               // 电话
               cell = row.createCell(4);
               cell.setCellValue(provider.getProPhone());
               // 地址
               cell = row.createCell(5);
               cell.setCellValue(provider.getProAddress());

               // 传真
               cell = row.createCell(6);
               cell.setCellValue(provider.getProFax());

               // 日期
               cell = row.createCell(7);
               cell.setCellValue(provider.getCreationDate());
           }
       }



       //Excel文件下载
       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
       workbook.write(byteArrayOutputStream);
       DownloadUtil.download(byteArrayOutputStream,response,"供应商列表.xlsx");
   }*/

    /* //导出excel数据
   @RequestMapping("/printProvider")
   public void printProvider(HttpServletResponse response) throws Exception{
       //从数据库拿所有信息
       List<Provider> providerList = providerService.findAllProvider();

       //1.创建工作薄
       XSSFWorkbook workbook = new XSSFWorkbook();
       //2.创建Sheet
       XSSFSheet sheet = workbook.createSheet("供应商列表");
       //3.开始创建行
       int index=0;
       //3.1单元格合并
       XSSFRow row = sheet.createRow(index++);
       //firstRow:合并的首行索引；last:合并的尾行索引
       //firstCol:合并的首列索引；last:合并的尾列索引
       sheet.addMergedRegion(new CellRangeAddress(0,0,0,7));
       XSSFCell cell = row.createCell(0);
       cell.setCellValue("供应商列表信息");
       cell.setCellStyle(bigTitle(workbook));

       //3.2表头
       row = sheet.createRow(index++);
       String [] headerNames = {"供应商编号","供应商名称","供应商描述","联系 人","联系电话","联系地址","传真","创建日期"};

       //循环数组 将标题直接赋值到小标题上
       for(int i = 0 ; i < headerNames.length ; i++){
            //每一个单元格
           cell = row.createCell(i);
           cell.setCellValue(headerNames[i]);//赋值内容
           cell.setCellStyle( title(workbook) ); //设置样式
            // 设置所有列宽
           sheet.setColumnWidth(i,20*256);
       }
       // 4.3 导入数据部分
          //遍历 index ==2
          //每一个Provider 表示一行数据
       for (Provider provider : providerList) {
           row = sheet.createRow( index ++); //循环创建行对象
           // 编号
           cell = row.createCell(0);
           cell.setCellValue(provider.getProCode());
           cell.setCellStyle(text(workbook));
           // 名称
           cell = row.createCell(1);
           cell.setCellValue(provider.getProName());
           cell.setCellStyle(text(workbook));
           // 描述
           cell = row.createCell(2);
           cell.setCellValue(provider.getProDesc());
           cell.setCellStyle(text(workbook));
            // 联系人
           cell = row.createCell(3);
           cell.setCellValue(provider.getProContact());
           cell.setCellStyle(text(workbook));
           // 电话
           cell = row.createCell(4);
           cell.setCellValue(provider.getProPhone());
           // 地址
           cell = row.createCell(5);
           cell.setCellValue(provider.getProAddress());
           cell.setCellStyle(text(workbook));
           // 传真
           cell = row.createCell(6);
           cell.setCellValue(provider.getProFax());
           cell.setCellStyle(text(workbook));
           // 日期
           cell = row.createCell(7);
           cell.setCellValue(provider.getCreationDate());
           cell.setCellStyle(text(workbook));
       }



       //Excel文件下载
       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
       workbook.write(byteArrayOutputStream);
       DownloadUtil.download(byteArrayOutputStream,response,"供应商列表.xlsx");
   }*/
    //模板导出excel数据
    @RequestMapping("/printProvider")
    public void printProvider(HttpServletResponse response) throws Exception {
        // 从数据库拿所有供应商信息
        List<Provider> providerList = providerService.findAllProvider();
        // 1、获取模板工作簿
        XSSFWorkbook workbook = new XSSFWorkbook("D:\\tOUTPRODUCT.xlsx");
        // 2、获取sheet
        XSSFSheet sheet = workbook.getSheetAt(0);
        // 3、开始获取行
        int index = 0;
        // 3.1 大标题，涉及到单元格合并
        XSSFRow row = sheet.getRow(index++);
        XSSFCell cell = row.getCell(0);
        // 3.2 表头
        row = sheet.getRow(index++);
        String[] headerNames = {"供应商编号", "供应商名称", "供应商描述", "联系 人", "联系电话", "联系地址", "传真", "创建日期"};
        for (int i = 0; i < headerNames.length; i++) {
            cell = row.getCell(i);
            cell.setCellValue(headerNames[i]);
        }
        // 加一步：添加一个临时样式数组，存储第一行有样式的数据样式
        row = sheet.getRow(index);
        CellStyle[] styles = new CellStyle[row.getLastCellNum()];
        for (int i = 0; i < styles.length; i++) {
            styles[i] = row.getCell(i).getCellStyle();
        }
        // 3.3 数据,每一个provider对应一行数据
        for (Provider provider : providerList) {
            row = sheet.createRow(index++);
            // 编号
            cell = row.createCell(0);
            cell.setCellValue(provider.getProCode());
            cell.setCellStyle(styles[0]);
            // 名称
            cell = row.createCell(1);
            cell.setCellValue(provider.getProName());
            cell.setCellStyle(styles[1]);
            // 描述
            cell = row.createCell(2);
            cell.setCellValue(provider.getProDesc());
            cell.setCellStyle(styles[2]);
            // 联系人
            cell = row.createCell(3);
            cell.setCellValue(provider.getProContact());
            cell.setCellStyle(styles[3]);
            // 电话
            cell = row.createCell(4);
            cell.setCellValue(provider.getProPhone());
            cell.setCellStyle(styles[4]);
            // 地址
            cell = row.createCell(5);
            cell.setCellValue(provider.getProAddress());
            cell.setCellStyle(styles[5]);
            // 传真
            cell = row.createCell(6);
            cell.setCellValue(provider.getProFax());
            cell.setCellStyle(styles[6]);
            // 日期
            cell = row.createCell(7);
            cell.setCellValue(provider.getCreationDate());
            cell.setCellStyle(styles[7]);
        }
        // excel文件下载
        ByteArrayOutputStream byteArrayOutputStream = new
                ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        DownloadUtil.download(byteArrayOutputStream, response, "供应商列 表.xlsx");


    }

    //导入Excel
    @RequestMapping("/importFle")
    @ResponseBody
    public Result importFle(@RequestParam("file") MultipartFile file, HttpSession session) throws IOException, ParseException {
        //2.解析文件对象 拿到工作薄 将文件数据输入到工作薄中
        InputStream is = file.getInputStream();
        //2.1 工作薄对象
        Workbook wb = new XSSFWorkbook(is);
        //2.2 获得表
        Sheet sheet = wb.getSheetAt(0);
        //2.3 获得行
        int lastRowNum = sheet.getLastRowNum(); //表示索引
        Row row = null;
        //通过第一行获得最后一列 因为中间需要循环
        row = sheet.getRow(1);
        short lastCellNum = row.getLastCellNum();//获得最后一列 但是不是索引 表示个数
        Cell cell = null;
        List<Provider> providerList = new ArrayList<>();
        Object[] excelData = new Object[8];// 临时存储excel的数据 一个数组是一个Provider对象
        for (int i = 2; i <= lastRowNum; i++) {
            row = sheet.getRow(i); //获得行
            //获得每一个单元格
            for (int j = 0; j < lastCellNum; j++) {
                cell = row.getCell(j);//获得每一个单元格
                Object cellVal = getCellValue(cell);//传入cell 返回Object的值
                excelData[j] = cellVal; //将解析的每一个数据放入数组中
            }
            //将数组转换成货物对象
            Provider provider = new Provider(excelData);
            // 被当前登录用户所创建
            User login_user = (User) session.getAttribute("login_user");
            provider.setCreatedBy(login_user.getId());
            providerList.add(provider);
        }
        //3.批量保存 在service层中编写 因为service层有事务控制
        providerService.saveList(providerList);
        // 4、json结果相应
        Result result = new Result();
        result.setCode(0);
        result.setMsg("ok");
        return result;
    }


    //int firstRow, int lastRow, int firstCol, int lastCol
    //sheet.addMergedRegion(new CellRangeAddress(0 , 0 , 1 , 8));
    //大标题的样式
    public CellStyle bigTitle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);//字体加粗
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);                //横向居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);        //纵向居中
        return style;
    }

    //小标题的样式
    public CellStyle title(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 12);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);                //横向居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);        //纵向居中
        style.setBorderTop(BorderStyle.THIN);                        //上细线
        style.setBorderBottom(BorderStyle.THIN);                    //下细线
        style.setBorderLeft(BorderStyle.THIN);                        //左细线
        style.setBorderRight(BorderStyle.THIN);                        //右细线
        return style;
    }

    //文字样式
    public CellStyle text(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short) 10);

        style.setFont(font);

        style.setAlignment(HorizontalAlignment.LEFT);                //横向居左
        style.setVerticalAlignment(VerticalAlignment.CENTER);        //纵向居中
        style.setBorderTop(BorderStyle.THIN);                        //上细线
        style.setBorderBottom(BorderStyle.THIN);                    //下细线
        style.setBorderLeft(BorderStyle.THIN);                        //左细线
        style.setBorderRight(BorderStyle.THIN);                        //右细线

        return style;
    }
}
