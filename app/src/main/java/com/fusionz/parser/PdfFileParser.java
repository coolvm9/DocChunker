package com.fusionz.parser;

import com.fusionz.util.FusionTokenizer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfFileParser implements FileParser{

    @Override
    public List<String> parse(File file, FusionTokenizer tokenizer) throws IOException {
        // Returns the text content of the PDF file
        try (PDDocument document = PDDocument.load(file)) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);

            // Tokenize the text into smaller chunks
            return tokenizer.tokenize(text, 10, 5);
        }
    }
}
