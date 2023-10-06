package nohasslepdf.com.github.wildsource.core.converters.strategies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;

import nohasslepdf.com.github.wildsource.core.converters.ConverterStrategy;

public class ConvertPngStrategy implements ConverterStrategy {

	@Override
	public void convert(String filePath) {
		// step 1: creation of a document-object
		Document document = new Document();
		System.out.println("Document object created");

		try {
			// step 2: we create a writer that listens to the document
			// and directs a PDF-stream to a file
			PdfWriter.getInstance(document, new FileOutputStream(filePath.replace(".png", ".pdf")));
			System.out.println("pdf stream setup to file");

			// step 3: we open the document
			document.open();
			System.out.println("Document opened");

			// step 4: resize image to fit pdf document
			BufferedImage bufferedImage = ImageIO.read(new File(filePath));
			System.out.println("Image opened in buffer");

			int docWidth = (int) document	.getPageSize()
											.getBorderWidth();
			int docHeight = (int) document	.getPageSize()
											.getHeight();

			java.awt.Image resizedImage = bufferedImage.getScaledInstance(docWidth, docHeight,
					java.awt.Image.SCALE_DEFAULT);

			com.lowagie.text.Image png = com.lowagie.text.Image.getInstance(resizedImage, null);

			System.out.println("Resised image to fit pdf document");

			// step 5: write image to pdf
			document.add(png);
			System.out.println("added to the pdf stream to file");

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		// step 6: we close the document
		document.close();
		System.out.println("document stream closed");
	}

}
