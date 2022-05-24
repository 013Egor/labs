import java.util.HashMap;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Settings {
    HashMap<String, Integer> settings;

    public Settings() {
        settings = new HashMap<String, Integer>();
    }

    public void put(String key, int value) {
        settings.put(key, value);
    }

    public int get(String key) {
        return settings.get(key);
    }

    public void delete(String key) {
        settings.remove(key);
    }

    public void loadFromBinaryFile(String filename) {
        FileInputStream fin = null;
        try {
            File file = new File(filename);
            fin = new FileInputStream(file);

            byte[] input = new byte[(int)file.length()];
            fin.read(input);

            StringBuilder name = new StringBuilder();
            for (int i = 0; i < input.length; i++) {
                if ( i >= 1 && input[i - 1] == 32) {
                    int value = 0;
                    int temp;
                    for (int j = 0 ; j < 4; j++, i++) {
                        int shift = 24 - j * 8;
                        temp = ((int)input[i] & 0x000000FF) << shift; 
                        value = value | temp;
                    }
                    settings.put(name.toString(), value);
                    name = new StringBuilder();
                    i--;
                } else if (input[i] != 32) {
                    name.append((char)input[i]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fin.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void saveToBinaryFile(String filename) {
        FileOutputStream fout = null;
        try {
            File file = new File(filename);
            fout = new FileOutputStream(file);

            byte[] output;
            for (HashMap.Entry<String, Integer> item : settings.entrySet()) {
                output = (item.getKey() + " ").getBytes();
                fout.write(output);
                byte[] t = {
                    (byte)(item.getValue()>>24), 
                    (byte)(item.getValue()>>16), 
                    (byte)(item.getValue()>>8), 
                    (byte)(item.getValue()>>0)
                };
                fout.write(t);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fout.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void loadFromTextFile(String filename) {
        BufferedReader fin = null;
        try {
            fin = new BufferedReader(new FileReader(filename));
            String line;
            String[] splitedLine;
            int value;
            while ((line = fin.readLine())!= null) {
                splitedLine = line.split(" ");
                if (splitedLine.length != 2) {
                    throw new Exception("Wrong input file");
                }
                value = Integer.parseInt(splitedLine[1]);
                settings.put(splitedLine[0], value);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fin.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void saveToTextFile(String filename) {
        BufferedWriter fout = null;
        try {
            fout = new BufferedWriter(new FileWriter(filename));
            
            for (HashMap.Entry<String, Integer> item: settings.entrySet()) {
				fout.write(item.getKey() + " " + item.getValue() + "\n");
			}

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fout.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Settings) {
            Settings obj = (Settings) o;
            if (settings.equals(obj.settings)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (HashMap.Entry<String, Integer> item: settings.entrySet()) {
            str.append("key: " + item.getKey() + "; value: " + item.getValue() + "\n");
        }
        return str.toString();
    }
}