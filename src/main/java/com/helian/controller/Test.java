package com.helian.controller;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.helian.bean.User;

public class Test {
	
    public void testExcelExport() throws Exception {

        // 创建excel
		HSSFWorkbook wb = new HSSFWorkbook();

        // 创建sheet
        HSSFSheet sheet = wb.createSheet("报表数据");

        // 创建一行
        HSSFRow rowTitle = sheet.createRow(0);

        // 创建标题栏样式
        HSSFCellStyle styleTitle = wb.createCellStyle();
        styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 居中
        HSSFFont fontTitle = wb.createFont();
        // 宋体加粗
        fontTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        fontTitle.setFontName("宋体");
        fontTitle.setFontHeight((short) 200);
        styleTitle.setFont(fontTitle);

        // 在行上创建1列
        HSSFCell cellTitle = rowTitle.createCell(0);

        // 列标题及样式
        cellTitle.setCellValue("用户姓名");
        cellTitle.setCellStyle(styleTitle);

        // 在行上创建2列
        cellTitle = rowTitle.createCell(1);
        cellTitle.setCellValue("年龄");
        cellTitle.setCellStyle(styleTitle);
        
     // 在行上创建3列
        cellTitle = rowTitle.createCell(2);
        cellTitle.setCellValue("注册日期");
        cellTitle.setCellStyle(styleTitle);

        HSSFCellStyle styleCenter = wb.createCellStyle();
        styleCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 居中

        // 取数据----->造数据
        User user1= new User("zhangsan",18,new Date());
        Thread.sleep(1000);
        User user2= new User("lisi",22,new Date());
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);

        for (int i = 0; i < list.size(); i++) {

        	User user = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(user.getName());
            cell.setCellStyle(styleCenter);

            cell = row.createCell(1);
            cell.setCellValue(user.getAge());
            cell.setCellStyle(styleCenter);
            
            cell = row.createCell(2);
            cell.setCellValue(user.getTime());
            cell.setCellStyle(styleCenter);
        }

        FileOutputStream fout = new FileOutputStream("C:/Users/An/Desktop/awb.xls");
        wb.write(fout);
        fout.close();
       // wb.close();

        System.out.println("导出完成！");
    }
}
