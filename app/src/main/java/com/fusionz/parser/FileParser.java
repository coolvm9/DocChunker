package com.fusionz.parser;

import com.fusionz.util.FusionTokenizer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileParser {

//   String parse(File file) throws IOException;
   List<String> parse(File file, FusionTokenizer tokenizer) throws IOException;
}
