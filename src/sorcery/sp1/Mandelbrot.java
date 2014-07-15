package sorcery.sp1;

import java.awt.Color;
import sorcery.util.ComplexNum;
import sorcery.util.PixelController;
import sorcery.util.PixelScreen;

public class Mandelbrot implements PixelController {
    
    public static void main(String[] args) {
        PixelScreen p = new PixelScreen(640,480,new Mandelbrot());
    }
    
    int x;
    
    @Override
    public Color[][] get() {
        Color[][] arr = new Color[640][480];
        
        double rcorner = -2.25;
        double icorner = -1.5;
        double side = 3;
        double rgap = side/640;
        double igap = side/480;
        
        for (int i=0;i<640;i++) {
            for (int j=0;j<480;j++) {
                ComplexNum c = new ComplexNum(i*rgap+rcorner,j*igap+icorner);
                ComplexNum z = new ComplexNum(0,0);
                int k;
                for (k=0;k<1000;k++) {
                    z = z.multiply(z).add(c);
                    if (z.i*z.i + z.r*z.r > 4)
                        break;
                }
                arr[i][j] = new Color(Math.min(k/50f,1),0,0);
            }
        }
        
        return arr;
    }
}
