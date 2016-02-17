package dash;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by isaac on 2/16/16.
 */
public class _ {

    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static boolean isEmpty(Object o) {
        if (o == null) return true;

        if (o instanceof String) {
            return ((String) o).isEmpty();
        }

        if (o instanceof Map) {
            return ((Map) o).isEmpty();
        }

        if (o instanceof Collection) {
            return ((Collection) o).isEmpty();
        }

        throw new IllegalArgumentException("isEmpty not support " + o);
    }

    public static <T> T notEmpty(T o) {
        if (isEmpty(o)) return null;
        return o;
    }

    public static String[] reFind(String re, String s) {
        return reFind(Pattern.compile(re), s);
    }

    public static String[] reFind(Pattern p, String s) {
        return reFind(p.matcher(s));
    }

    public static String[] reFind(Matcher m) {
        int cnt = m.groupCount();
        if (!m.find())
            return null;

        String[] rets = new String[cnt + 1];
        for (int i = 0; i < cnt + 1; i++)
            rets[i] = m.group(i);

        return rets;
    }

    public static String[] reOptFind(String re, String s) {
        return reOptFind(Pattern.compile(re), s);
    }

    public static String[] reOptFind(Pattern p, String s) {
        return reOptFind(p.matcher(s));
    }

    public static String[] reOptFind(Matcher m) {
        int cnt = m.groupCount();

        String[] rets = new String[cnt + 1];
        if (!m.find()) {
            for (int i = 0; i < cnt + 1; i++)
                rets[i] = "";
        } else {
            for (int i = 0; i < cnt + 1; i++)
                rets[i] = m.group(i);
        }
        return rets;
    }

    public static List<String[]> reFindAll(String re, String s) {
        return reFindAll(Pattern.compile(re), s);
    }

    private static List<String[]> reFindAll(Pattern p, String s) {
        return reFindAll(p.matcher(s));
    }

    private static List<String[]> reFindAll(Matcher m) {
        List<String[]> rets = new ArrayList<String[]>();
        int cnt = m.groupCount();
        while (m.find()) {
            String[] ms = new String[cnt + 1];
            for (int i = 0; i < cnt + 1; i++)
                ms[i] = m.group(i);
            rets.add(ms);
        }

        return rets;
    }

    public static String urlencode(String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url, "UTF-8");
    }

    public static String urldecode(String s) throws UnsupportedEncodingException {
        return URLDecoder.decode(s, "UTF-8");
    }
}
