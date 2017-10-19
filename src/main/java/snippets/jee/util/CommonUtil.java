package snippets.jee.util;

import java.awt.image.BufferedImage;

public final class CommonUtil {

    private static String string = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private CommonUtil() {
    }

    public static String generateCode (int len) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            stringBuilder.append(string.charAt((int)(string.length() * Math.random())));
        }
        return stringBuilder.toString();
    }

    public static BufferedImage generatedCodeImage (String code, int width, int height) {
        return null;
    }

    public int randomInt (int start, int end) {
        return (int) (start + Math.random() * end);
    }
}
