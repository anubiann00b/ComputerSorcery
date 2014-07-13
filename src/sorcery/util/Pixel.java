package sorcery.util;

import java.awt.Color;

public class Pixel {
    
    private final int x;
    private final int y;
    private final Color c;
    
    public int getX() { return x; }
    public int getY() { return y; }
    public Color getColor() { return c; }
    
    public Pixel(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }    
}
