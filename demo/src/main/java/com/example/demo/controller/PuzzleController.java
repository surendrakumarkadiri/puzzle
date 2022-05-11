package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Person;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@Controller
public class PuzzleController {

	@RequestMapping("/")
	public String index(Model model) {

		model.addAttribute("person", new Person("", "", LocalDateTime.now().toString()));
		return "index";
	}

	@RequestMapping("/add")
	public String addTodo(@ModelAttribute Person person) throws InvalidFormatException, IOException {

		write(person);
		return "redirect:/";
	}

	private static final String FILE_NAME = "C:\\Users\\pankaj\\Desktop\\projectOutput\\blo.xlsx";

	// Method
	public static void write(Person ps) throws IOException, InvalidFormatException {
		FileInputStream file = null;
		try {

			File currDir = new File(".");
			String path = currDir.getAbsolutePath();
			String fileLocation = path.substring(0, path.length() - 1) + "Congratulation.xlsx";
			file = new FileInputStream(new File(fileLocation));
			Workbook workbook = new XSSFWorkbook(file);

			Sheet sheet = workbook.getSheet("Congratulation List");
			sheet.setColumnWidth(0, 9000);
			sheet.setColumnWidth(1, 10000);
			sheet.setColumnWidth(2, 6000);

			Row header = sheet.createRow(0);

			Cell headerCell = header.createCell(0);
			headerCell.setCellValue("Full Name");

			Cell headerCell2 = header.createCell(1);
			headerCell2.setCellValue("Email");

			Cell headerCell3 = header.createCell(2);
			headerCell3.setCellValue("Time");

			
			Row row2 = sheet.createRow(sheet.getPhysicalNumberOfRows());
			Cell cell = row2.createCell(0);
			cell.setCellValue(ps.getName());

			Cell cell2 = row2.createCell(1);
			cell2.setCellValue(ps.getEmail());

			Cell cell3 = row2.createCell(2);
			cell3.setCellValue(ps.getTime());

			FileOutputStream os = new FileOutputStream(fileLocation);
			workbook.write(os);
			workbook.close();
			os.close();
			workbook.close();
			file.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (file != null) {
				file.close();
			}
		}

	}
}
