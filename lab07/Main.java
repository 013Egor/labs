public class Main {

    static String filename = "Library";
    static String binFile = "binFile";
    static String textFile = "textFile";
    public static void main(String[] argv) {
        Library library = new Library();

        library.load(filename);
        System.out.println(library);

        System.out.println("Books after 2010:");
        System.out.println(library.find(2010));

        System.out.println("Alice in Wonderworld:");
        System.out.println(library.find("Alice in Wonderworld"));
        System.out.println("-----------------------------------------");

        Settings settings = new Settings();

        settings.put("negative", -12355);
        settings.put("bigPos", 1000000);
        settings.put("last", 1);

        settings.saveToBinaryFile(binFile);
        settings.saveToTextFile(textFile);

        Settings settingsLoadBin = new Settings();
        Settings settingsLoadText = new Settings();

        settingsLoadBin.loadFromBinaryFile(binFile);
        settingsLoadText.loadFromTextFile(textFile);

        System.out.println("Bin file:\n" + settingsLoadBin);

        System.out.println("Text file:\n" + settingsLoadText);
    }
}