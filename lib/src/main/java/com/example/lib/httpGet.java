import java.net.*;
import java.io.*;

public class httpGet {
    public static void voteRead(String[] args) throws Exception {
        URL url = new URL("http://workoutdev.org:5000/vote?item=" + args[0]);
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}
