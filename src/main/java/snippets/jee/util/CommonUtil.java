package snippets.jee.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public final class CommonUtil {

    private static final String CHARS = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int LEN = CHARS.length();

    private CommonUtil() {
    }

    public static String generateCode (int len) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            int index = randomInt(0, LEN);
            stringBuilder.append(CHARS.charAt(index));
        }
        return stringBuilder.toString();
    }

    public static BufferedImage generatedCodeImage (String code, int width, int height) {
        BufferedImage codeImage = new BufferedImage(width, height, 1);
        Graphics2D g = (Graphics2D) codeImage.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLUE);
        int size = (width - 10) / code.length();
        g.setFont(new Font("Arial", Font.BOLD, size));
        for (int i = 0; i < code.length(); ++i) {
            String currentChar = code.substring(i, i + 1);
            g.drawString(currentChar, 5 + size * i, height / 2);
        }
        return codeImage;
    }

    /**
     * 生成指定范围的随机整数
     */
    public static int randomInt (int start, int end) {
        return (int) (start + Math.random() * (end - start));
    }
}
