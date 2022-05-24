import java.io.*;

public class EncodingConverter {
  public static void main(String[] argv) {

    if (argv.length == 4) {
      Reader reader = null;
      Writer writer = null;
      try {
        reader = new InputStreamReader(new FileInputStream (argv[0]) , argv[2]);
        writer = new OutputStreamWriter(new FileOutputStream (argv[1]) , argv[3]);
        int c = 0;
        while(( c = reader.read ()) >= 0) {
          writer.write(c);
        }
      } catch (IOException e) {
        System.out.println(e.getMessage());
      } finally {
        try {
         if (reader != null) { reader.close(); }
         if (writer != null) { writer.close(); }
       } catch (IOException e) {
         System.out.println(e.getMessage());
       }
      }
    }
  }
}
