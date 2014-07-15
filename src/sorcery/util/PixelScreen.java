package sorcery.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class PixelScreen extends JFrame implements MouseListener, KeyListener {
    
    public int width = 640;
    public int height = 480;
    private BufferedImage offscreen = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    
    private PixelController pc;
    
    public PixelScreen(int w, int h, PixelController p) {
        width = w;
        height = h;
        pc = p;
        setVisible(true);
        setSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Game");
        addKeyListener(this);
        addMouseListener(this);
    }
    
    boolean done = true;
    
    @Override
    public void paint(Graphics g) {
        Graphics s = offscreen.getGraphics();
        Color[][] c = pc.get();
        
        for (int i=0;i<width;i++) {
            for (int j=0;j<height;j++) {
                s.setColor(c[i][j]);
                s.fillRect(i,j,1,1);
            }
        }
        
        g.drawImage(offscreen, 0, 0, this);
        
        if (done) {
            try {
                File outputfile = new File("saved.png");
                ImageIO.write(offscreen, "png", outputfile);
            } catch (IOException e) {
                System.out.println(e);
            }
            done = false;
        }
    }
    
    @Override public void keyPressed(KeyEvent e) {  }
    @Override public void keyReleased(KeyEvent e) {  }
    @Override public void keyTyped(KeyEvent e) { }
    
    @Override public void mouseClicked(MouseEvent e) { }
    @Override public void mousePressed(MouseEvent e) { }
    @Override public void mouseReleased(MouseEvent e) { }
    @Override public void mouseEntered(MouseEvent e) { }
    @Override public void mouseExited(MouseEvent e) { }
}
