package com.fusionz.util;

import java.util.List;

public interface FusionTokenizer {
    List<String> tokenize(String text, int tokenSize, int overlap);
}
