import processing.core.PApplet;

public class Textbox extends PApplet {

    public int X = 0, Y = 0, H = 35, W = 200;
    public int textsize = 24;

    // Initialize and declare colors
//    public color background = color(140,140,140);
//    public color foreground = color(0,0,0);
//    public color backgroundSelected = color(160,160,160);
//   public color border = color(30,30,30);

    public boolean BorderEnable = false;
    public int BorderWeight = 1;

    public String Text = "";
    public int TextLength = 0;

    private boolean selected = false;

    Textbox() {
        // CREATE OBJECT DEFAULT TEXTBOX
    }

    void Textbox(int x, int y, int w, int h) {
        X = x; Y = y; W = w; H = h;
    }

    void DRAW() {
        // DRAWING THE BACKGROUND
        if (selected) {
//            fill(backgroundSelected);
            fill(160,160,160);
        } else {
//            fill(background);
            fill(140,140,140);
        }

        if (BorderEnable) {
            strokeWeight(BorderWeight);
//            stroke(border);
            stroke(30,30,30);
        } else {
            noStroke();
        }

        rect(X, Y, W, H);

        // DRAWING THE TEXT ITSELF
//        fill(foreground);
        fill(0,0,0);
        textSize(textsize);
        text(Text, X + (textWidth("a") / 2), Y + textsize);
    }

    // IF THE KEYCODE IS ENTER RETURN 1
    // ELSE RETURN 0
    boolean KEYPRESSED(char KEY, int KEYCODE) {
        if (selected) {
            if (KEYCODE == (int)BACKSPACE) {
                BACKSPACE();
            } else if (KEYCODE == 32) {
                // SPACE
                addText(' ');
            } else if (KEYCODE == (int)ENTER) {
                return true;
            } else {
                // CHECK IF THE KEY IS A LETTER OR A NUMBER
                boolean isKeyCapitalLetter = (KEY >= 'A' && KEY <= 'Z');
                boolean isKeySmallLetter = (KEY >= 'a' && KEY <= 'z');
                boolean isKeyNumber = (KEY >= '0' && KEY <= '9');

                if (isKeyCapitalLetter || isKeySmallLetter || isKeyNumber) {
                    addText(KEY);
                }
            }
        }

        return false;
    }

    private void addText(char text) {
        // IF THE TEXT WIDHT IS IN BOUNDARIES OF THE TEXTBOX
        if (textWidth(Text + text) < W) {
            Text += text;
            TextLength++;
        }
    }

    private void BACKSPACE() {
        if (TextLength - 1 >= 0) {
            Text = Text.substring(0, TextLength - 1);
            TextLength--;
        }
    }

    // FUNCTION FOR TESTING IS THE POINT
    // OVER THE TEXTBOX
    private boolean overBox(int x, int y) {
        if (x >= X && x <= X + W) {
            if (y >= Y && y <= Y + H) {
                return true;
            }
        }

        return false;
    }

    void PRESSED(int x, int y) {
        if (overBox(x, y)) {
            selected = true;
        } else {
            selected = false;
        }
    }
}
