package com.fusionz.util;

import java.util.List;

public class TokenizerWrapper implements FusionTokenizer {
    private FusionTokenizer tokenizer;

    public TokenizerWrapper(FusionTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public List<String> tokenize(String text, int tokenSize, int overlap) {
        return tokenizer.tokenize(text, tokenSize, overlap);
    }

}
