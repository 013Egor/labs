

public class Main {

  public static void main (String[] argv) {
    SortedIntegerList listUnrepeatableI = new SortedIntegerList(false);
    SortedIntegerList listRepeatableI = new SortedIntegerList(true);
    int[] a = {1, 1, 0, 3, -10, -11};
    System.out.println("Входные данные:");
    for (int i = 0; i < 6; i++) {
      System.out.print(a[i] + " ");
      listRepeatableI.add(a[i]);
      listUnrepeatableI.add(a[i]);
    }
    System.out.println();
    System.out.println("С повторениями: " + listRepeatableI);
    System.out.println("Без повторений: " + listUnrepeatableI + '\n');
    System.out.println(listRepeatableI.equals(listUnrepeatableI));

    listRepeatableI.remove(12);
    System.out.println("Удаление числа 12 из первого списка:");
    System.out.println("С повторениями: " + listRepeatableI);
    System.out.println("Без повторений: " + listUnrepeatableI + '\n');
    System.out.println(listRepeatableI.equals(listUnrepeatableI));

    SortedColorList listUnrepeatable = new SortedColorList(false);
    SortedColorList listRepeatable = new SortedColorList(true);
    Colors[] color = {
      new Colors(100, 200, 100), new Colors(), new Colors(100, 200, 100)
    };
    for (int i = 0 ; i < 3; i++) {
      listRepeatable.add(color[i]);
      listUnrepeatable.add(color[2-i]);
    }

    System.out.println("С повторениями: " + listRepeatable);
    System.out.println("Без повторений: " + listUnrepeatable + '\n');
    System.out.println(listRepeatable.equals(listUnrepeatable));

    listRepeatable.remove(new Colors(255, 255, 255));
    System.out.println("Удаление [255, 255, 255] из первого списка:");
    System.out.println("С повторениями: " + listRepeatable);
    System.out.println("Без повторений: " + listUnrepeatable + '\n');
    System.out.println(listRepeatable.equals(listUnrepeatable));
  }

}
