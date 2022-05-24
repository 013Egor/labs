import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;

public class FormattedInput {

  Object[] scanf (String format) {
    String[] formatSymbols = format.split("[%]");
    if (formatSymbols.length == 0) {
      return new Object[0];
    }
    Object[] output = new Object[formatSymbols.length - 1];

    BufferedReader input = null;
    try {
        input = new BufferedReader(new InputStreamReader(System.in));
        boolean process = true;
        while (process) {
          process = false;
          System.out.print("Input: ");
          String[] line = input.readLine().split(" ");
          try {
            for (int i = 0, j = 1; i < line.length; i++) {
              if (line[i].isEmpty() == false && j < formatSymbols.length) {
                char curChar = formatSymbols[j].charAt(0);
                if (curChar == 'd') {
                  output[j - 1] = new Integer(line[i]);
                } else if (curChar == 'f'){
                  output[j - 1] = new Double(line[i]);
                } else if (curChar == 's') {
                  output[j - 1] = line[i];
                } else if (curChar == 'c') {
                  if (line[i].length() == 1) {
                    output[j - 1] = new Character(line[i].charAt(0));  
                  } else {
                    throw new Exception("You made mistake with char (your input: " + line[i] + ")");
                  }
                } else if (curChar == 'C') {
                  int amount = 0;
                  int size = formatSymbols[j].length() - 1;
                  for (int t = 1; t < size; t++) {
                    amount += (formatSymbols[j].charAt(t) - '0') * Math.pow(10, size - t - 1);
                  }
                  
                  Chars temp = new Chars(amount);
                  for (int t = 0; t < amount; t++, i++) {
                    if (line[i].length() == 1) {
                      temp.set(t, new Character(line[i].charAt(0)));
                    } else {
                      throw new Exception("You made mistake with array of chars (your input: " + line[i] + ")");
                    }
                  }
                  i--;
                  output[j - 1] = temp;
                } else {
                  throw new Exception("You made mistake. Try again:");
                }
                j++;
              } else if (line[i].isEmpty() == false && j > formatSymbols.length) {
                throw new Exception("There is a lot of input data");
              } 
            }
          } catch (Exception e) {
            System.out.println(e.getMessage());
            process = true;
          }
        }
    } catch (Exception e) {
          System.out.println(e.getMessage());
        /*} finally {
         try {
          if (input != null) { input.close(); }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }*/
    }

    return output;
  }

  Object[] sscanf (String format, String in) {
    String[] formatSymbols = format.split("[%]");
    if (formatSymbols.length == 0) {
      return new Object[0];
    }
    Object[] output = new Object[formatSymbols.length - 1];

    String[] line = in.split(" ");
    try {
      for (int i = 0, j = 1; i < line.length; i++) {
        if (line[i].isEmpty() == false && j < formatSymbols.length) {
          char curChar = formatSymbols[j].charAt(0);
          if (curChar == 'd') {
            output[j - 1] = new Integer(line[i]);
          } else if (curChar == 'f'){
            output[j - 1] = new Double(line[i]);
          } else if (curChar == 's') {
            output[j - 1] = line[i];
          } else if (curChar == 'c') {
            if (line[i].length() == 1) {
              output[j - 1] = new Character(line[i].charAt(0));  
            } else {
              throw new Exception("You made mistake with char (your input: " + line[i] + ")");
            }
          } else {
            throw new Exception("You made mistake. Try again:");
          }
          j++;
        } else if (line[i].isEmpty() == false && j >= formatSymbols.length) {
          throw new Exception("There is a lot of input data");
        } 
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return output;
  }
}
