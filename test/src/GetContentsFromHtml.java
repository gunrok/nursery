
import java.io.IOException;

import nurseryinfo.CodeMaster;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Example program to list links from a URL.
 */
public class GetContentsFromHtml {
    public static void main(String[] args) throws IOException {
        //Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        String url = CodeMaster.URLForce4+"11350000180";
        print("Fetching %s...", url);

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");
        Elements table = doc.select("td");
        Elements tbody = doc.select("tbody");
        Elements td = doc.select2("td");
        
        Element xx=doc.prepend("<p>abc</p>");
        
        int i=0 ;
        print("\nMedia: (%d)", table.size());
        for ( Element src : table ) {
        	
//        	System.out.println("1:"+ src.tagName()+"2:"+ src.val()+"3:"+ src.getAllElements());
        	System.out.println("ID : " +i++ + "\t value: " + src.ownText() +" | " + src.html());
        	
        	
        }
        
       
        
        
//        print("\nMedia: (%d)", tbody.size());
//        for (Element src : tbody) {
//        	print(" * %s: <%s>", src.tagName(), src.val());
//        }
//        print("\nMedia: (%d)", td.size());
//        for (Element src : td) {
//        	print(" * %s: <%s>", src.tagName(), src.attr("td"));
//        }
        
//        
//        for (Element src : media) {
//            if (src.tagName().equals("img"))
//                print(" * %s: <%s> %sx%s (%s)",
//                        src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
//                        trim(src.attr("alt"), 20));
//            else
//                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
//        }
//
//        print("\nImports: (%d)", imports.size());
//        for (Element link : imports) {
//            print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
//        }
//
//        print("\nLinks: (%d)", links.size());
//        for (Element link : links) {
//            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
//        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}