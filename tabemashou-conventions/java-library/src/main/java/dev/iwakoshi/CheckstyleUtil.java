package dev.iwakoshi;

import java.io.*;

import static java.nio.charset.StandardCharsets.*;

/**
 * Utility class for extracting the checkstyle.xml used by other plugins
 */
public abstract class CheckstyleUtil {
    public static String getCheckstyleConfig(String resourcePath) throws IOException {
        InputStream in = CheckstyleUtil.class.getResourceAsStream(resourcePath);
        if (in == null) {
            throw new FileNotFoundException(resourcePath);
        }

        StringBuilder sb = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader(in, UTF_8))) {
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }
        }
        return sb.toString();
    }
}
