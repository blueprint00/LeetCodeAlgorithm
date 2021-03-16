package Mar.Week3;
import java.util.*;
public class EncodeAndDecodeTinyURL {
    public static void main(String[] args){
        String url = "https://leetcode.com/problems/design-tinyurl";
        Codec codec = new Codec();
        System.out.println(codec.decode(codec.encode(url)));
    }
}
class Codec {
    Map<String, String> m = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String s = Long.toString(new Date().getTime(), 36);
        m.put(s, longUrl);
        return "http://tinyurl.com/" + s;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String su = shortUrl.substring(shortUrl.lastIndexOf("com/") + 4);
        String lu = m.get(su);
        return lu;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));