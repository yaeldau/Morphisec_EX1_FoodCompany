import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Util {

    // valid arg is a string that represent natural number.
    public static boolean isValidInteger(String arg) {
        if (arg == null) {
            return false;
        }
        if (arg.isEmpty()) {
            return false;
        }
        for (int i=0; i < arg.length(); i++) {
            char c = arg.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static String generatePhone(){
        Random rnd = new Random();
        int tail = 1000000 + rnd.nextInt(9000000);
        return "050" + tail;
    }

    public static String generateDescription(){
        return "Lorem ipsum dolor sit amet consectetur ...";
    }

    public static String generateName (){
        return "Yael" ;
    }
}

