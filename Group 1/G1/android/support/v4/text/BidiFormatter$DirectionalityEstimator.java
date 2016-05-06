package android.support.v4.text;

private static class DirectionalityEstimator
{
    private static final byte[] DIR_TYPE_CACHE;
    private static final int DIR_TYPE_CACHE_SIZE = 1792;
    private int charIndex;
    private final boolean isHtml;
    private char lastChar;
    private final int length;
    private final String text;
    
    static {
        DIR_TYPE_CACHE = new byte[1792];
        for (int i = 0; i < 1792; ++i) {
            DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
        }
    }
    
    DirectionalityEstimator(final String text, final boolean isHtml) {
        super();
        this.text = text;
        this.isHtml = isHtml;
        this.length = text.length();
    }
    
    private static byte getCachedDirectionality(final char c) {
        if (c < '\u0700') {
            return DIR_TYPE_CACHE[c];
        }
        return Character.getDirectionality(c);
    }
    
    private byte skipEntityBackward() {
        final int charIndex = this.charIndex;
        while (this.charIndex > 0) {
            final String text = this.text;
            final int charIndex2 = -1 + this.charIndex;
            this.charIndex = charIndex2;
            lastChar = text.charAt(charIndex2);
            if (lastChar == '&') {
                return 12;
            }
            if (lastChar == ';') {
                break;
            }
        }
        this.charIndex = charIndex;
        lastChar = ';';
        return 13;
    }
    
    private byte skipEntityForward() {
        while (charIndex < length && (lastChar = text.charAt(charIndex++)) != ';') {}
        return 12;
    }
    
    private byte skipTagBackward() {
        final int charIndex = this.charIndex;
        while (this.charIndex > 0) {
            final String text = this.text;
            final int charIndex2 = -1 + this.charIndex;
            this.charIndex = charIndex2;
            lastChar = text.charAt(charIndex2);
            if (lastChar == '<') {
                return 12;
            }
            if (lastChar == '>') {
                break;
            }
            if (lastChar != '\"' && lastChar != '\'') {
                continue;
            }
            final char lastChar = this.lastChar;
            while (this.charIndex > 0) {
                final String text2 = this.text;
                final int charIndex3 = -1 + this.charIndex;
                this.charIndex = charIndex3;
                if ((this.lastChar = text2.charAt(charIndex3)) != lastChar) {
                    continue;
                }
                break;
            }
        }
        this.charIndex = charIndex;
        lastChar = '>';
        return 13;
    }
    
    private byte skipTagForward() {
        final int charIndex = this.charIndex;
        while (this.charIndex < length) {
            lastChar = text.charAt(this.charIndex++);
            if (lastChar == '>') {
                return 12;
            }
            if (lastChar != '\"' && lastChar != '\'') {
                continue;
            }
            final char lastChar = this.lastChar;
            while (this.charIndex < length && (this.lastChar = text.charAt(this.charIndex++)) != lastChar) {}
        }
        this.charIndex = charIndex;
        lastChar = '<';
        return 13;
    }
    
    byte dirTypeBackward() {
        lastChar = text.charAt(-1 + charIndex);
        byte b;
        if (Character.isLowSurrogate(lastChar)) {
            final int codePointBefore = Character.codePointBefore(text, charIndex);
            charIndex -= Character.charCount(codePointBefore);
            b = Character.getDirectionality(codePointBefore);
        }
        else {
            --charIndex;
            b = getCachedDirectionality(lastChar);
            if (isHtml) {
                if (lastChar == '>') {
                    return this.skipTagBackward();
                }
                if (lastChar == ';') {
                    return this.skipEntityBackward();
                }
            }
        }
        return b;
    }
    
    byte dirTypeForward() {
        lastChar = text.charAt(charIndex);
        byte b;
        if (Character.isHighSurrogate(lastChar)) {
            final int codePoint = Character.codePointAt(text, charIndex);
            charIndex += Character.charCount(codePoint);
            b = Character.getDirectionality(codePoint);
        }
        else {
            ++charIndex;
            b = getCachedDirectionality(lastChar);
            if (isHtml) {
                if (lastChar == '<') {
                    return this.skipTagForward();
                }
                if (lastChar == '&') {
                    return this.skipEntityForward();
                }
            }
        }
        return b;
    }
    
    int getEntryDir() {
        charIndex = 0;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        while (charIndex < length && n3 == 0) {
            switch (this.dirTypeForward()) {
                case 18:
                    --n;
                    n2 = 0;
                    continue;
                case 16:
                case 17:
                    ++n;
                    n2 = 1;
                    continue;
                case 14:
                case 15:
                    ++n;
                    n2 = -1;
                case 9:
                    continue;
                default:
                    n3 = n;
                    continue;
                case 0:
                    if (n == 0) {
                        n2 = -1;
                        return n2;
                    }
                    n3 = n;
                    continue;
                case 1:
                case 2:
                    if (n == 0) {
                        return 1;
                    }
                    n3 = n;
                    continue;
            }
        }
        if (n3 == 0) {
            return 0;
        }
        if (n2 == 0) {
            while (charIndex > 0) {
                switch (this.dirTypeBackward()) {
                    default:
                        continue;
                    case 14:
                    case 15:
                        if (n3 == n) {
                            return -1;
                        }
                        --n;
                        continue;
                    case 16:
                    case 17:
                        if (n3 == n) {
                            return 1;
                        }
                        --n;
                        continue;
                    case 18:
                        ++n;
                        continue;
                }
            }
            return 0;
        }
        return n2;
    }
    
    int getExitDir() {
        charIndex = length;
        int n = 0;
        int n2 = 0;
        while (charIndex > 0) {
            switch (this.dirTypeBackward()) {
                case 18:
                    ++n;
                case 9:
                    continue;
                default:
                    if (n2 == 0) {
                        n2 = n;
                        continue;
                    }
                    continue;
                case 0:
                    if (n == 0) {
                        break;
                    }
                    if (n2 == 0) {
                        n2 = n;
                        continue;
                    }
                    continue;
                case 14:
                case 15:
                    if (n2 != n) {
                        --n;
                        continue;
                    }
                    break;
                case 1:
                case 2:
                    if (n == 0) {
                        return 1;
                    }
                    if (n2 == 0) {
                        n2 = n;
                        continue;
                    }
                    continue;
                case 16:
                case 17:
                    if (n2 == n) {
                        return 1;
                    }
                    --n;
                    continue;
            }
            return -1;
        }
        return 0;
    }
}
