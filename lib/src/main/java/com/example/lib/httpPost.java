import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class httpPost {
  
    public static void writeVote(String[] args) throws Exception {
      URL website = new URL("http://workoutdev.org:5000/vote");
      URLConnection yc = website.openConnection();
	    HttpURLConnection http = (HttpURLConnection)yc;
	    http.setRequestMethod("POST");
	    http.setDoOutput(true);
	    byte[] out = ("{\"name\":\"" + args[0] + "\",\"value\":\"" + args[1] + "\"}").getBytes(StandardCharsets.UTF_8);
	    byte[] out1 = "{\"name\":\"Food\",\"value\":\"1\"}".getBytes(StandardCharsets.UTF_8);
    	int length = out.length;

	    http.setFixedLengthStreamingMode(length);
	    http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	    http.connect();
	    try(OutputStream os = http.getOutputStream()) {
    		    os.write(out);
	    }	
	/*	
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
 	    in.close();
	    */
    }
}
