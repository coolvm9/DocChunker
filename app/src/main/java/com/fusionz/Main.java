package com.fusionz;

import com.fusionz.bean.CsvBean;
import com.fusionz.parser.FileParser;
import com.fusionz.parser.PdfFileParser;
import com.fusionz.util.FileUtil;
import com.fusionz.util.FusionTokenizer;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Main {

    // This is the main method that is executed, when the program is run
    // Given a directory, iterates over all the files in the directory, call the parse method of the FileParser interface
    // and writes to csv file
    public static void main(String[] args) {
        String directoryPath = "path/to/your/directory";
        String csvFilePath = "path/to/your/csvfile.csv";
        List<String> mimeTypes = Arrays.asList("application/pdf");
        try {
            List<File> files = FileUtil.getFilesFromDirectory(directoryPath, mimeTypes);
            File csvFile = new File(csvFilePath);
            FileWriter writer = new FileWriter(csvFile);
            FusionTokenizer tokenizer = null;
            StatefulBeanToCsv<CsvBean> beanToCsv = new StatefulBeanToCsvBuilder<CsvBean>(writer).build();
            for (File file : files) {
                String mimeType = Files.probeContentType(file.toPath());
                if ("application/pdf".equals(mimeType)) {
                    FileParser fileParser = new PdfFileParser();
                    List<String> chunks = fileParser.parse(file,tokenizer);
                    for (String content : chunks) {
                        // Create a new CsvBean object and set the filename and chunkText (content of the file chunk
                        CsvBean csvBean = new CsvBean();
                        csvBean.setFilename(file.getName());
                        csvBean.setChunkText(content);
                        beanToCsv.write(csvBean);
                    }
                }
            }
            writer.close();
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }
}

