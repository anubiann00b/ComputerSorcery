package sorcery.sp1;

import java.awt.Color;
import sorcery.util.Pixel;
import sorcery.util.PixelController;
import sorcery.util.PixelScreen;

public class Mandelbrot implements PixelController {
    
    public static void main(String[] args) {
        PixelScreen p = new PixelScreen(640,480,new Mandelbrot());
    }
    
    int x;
    
    @Override
    public Pixel getNext() {
        return new Pixel((x++)%640,x/640,new Color(x%255,128,128));
    }
}
