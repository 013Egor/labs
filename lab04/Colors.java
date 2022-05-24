public class Colors {
  int r;
  int g;
  int b;

  public Colors() {
    r = 255;
    g = 255;
    b = 255;
  }

  public Colors(int red, int green, int blue) {
    r = red;
    g = green;
    b = blue;
  }

  public double getYFactor() {
    double coefBlue = 0.144;
    double coefRed = 0.299;
    double coefGreen = 1 - coefRed - coefBlue;

    return coefRed * r + coefGreen * g + coefBlue * b;
  }

  public boolean equals(Colors temp){
    return r == temp.r && g == temp.g && b == temp.b;
  }

  public String toString() {
    return "[ " + r + "; " + g + "; " + b + "]";
  }
}
