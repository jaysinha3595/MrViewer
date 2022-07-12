package com.example.system.service;

import java.awt.Color;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.example.admin.service.UserService;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class AdminReportService implements IAdminReportService {

//	@Autowired
	private UserService userService = new UserService();

	private void writeHeader(PdfPTable table, String... cells) {

		PdfPCell cell = new PdfPCell(new Phrase("Mr.Viewer- List of users."));
		cell.setColspan(cells.length);
		cell.setHorizontalAlignment(1);
		table.addCell(cell);
		table.setHeaderRows(1);

		cell.setBackgroundColor(Color.GRAY);
		cell.setPadding(5);

		for (String k : cells) {
			table.addCell(new Phrase(k));
		}
	}

	private void writeData(PdfPTable table) {

		userService.getAllUsers().stream().forEach(u -> {
			table.addCell(String.valueOf(1));
			table.addCell(String.valueOf(u.id));
			table.addCell(String.valueOf(u.username));
			table.addCell(String.valueOf(u.email));
			table.addCell(String.valueOf(u.phoneNumber));
			table.addCell(String.valueOf(u.gender));
			table.addCell(String.valueOf(u.active));
		});

		PdfPCell cell = new PdfPCell(new Phrase("Total Count: "+userService.getAllUsers().size()));
		cell.setColspan(7);
		table.addCell(cell);

	}

	@Override
	public String generateMovieReport(HttpServletResponse response) {

		return null;
	}

	@Override
	public String generateUserReport(HttpServletResponse response) {

		Document document = new Document(PageSize.A4);
//		document.setHeader(new HeaderFooter(new Phrase("Mr.Viewer"), new Phrase(LocalDateTime.now().toString())));


		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setSize(14);
		font.setColor(Color.DARK_GRAY);



		try {
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();

			Paragraph paragraph = new Paragraph("Mr.Viewer Report "+LocalDateTime.now().toString());

			document.add(paragraph);


			float[] width = new float[] {1f,1.5f,3f,5f,4f,3f,2f};

			PdfPTable table = new PdfPTable(7);
			table.setWidths(width);
			table.setWidthPercentage(100);
			writeHeader(table, "S.No", "UserId", "Username", "Email", "Mobile Number", "Gender", "Active");


			writeData(table);
			document.add(table);

		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();
		return "pdf created";
	}

	@Override
	public String generateLocaleReport(HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
