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
                if (k<8)
                    arr[i][j] = new Color(0,k/8f,0);
                else if (k<16)
                    arr[i][j] = new Color(0,0,(k-8)/8f);
                else if (k<64)
                    arr[i][j] = new Color(0,(k-16)/48f,(k-16)/48f);
                else if (k<400)
                    arr[i][j] = new Color(255,255,0);
                else
                    arr[i][j] = new Color(255,255,255);
            }
        }
        
        return arr;
    }
}
