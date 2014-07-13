package sorcery.util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class PixelScreen extends JFrame implements MouseListener, KeyListener {
    
    public int SCREEN_WIDTH = 640;
    public int SCREEN_HEIGHT = 480;
    private BufferedImage offscreen = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
    
    private PixelController pc;
    
    public PixelScreen(int w, int h, PixelController p) {
        SCREEN_WIDTH = w;
        SCREEN_HEIGHT = h;
        pc = p;
        setVisible(true);
        setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Game");
        addKeyListener(this);
        addMouseListener(this);
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics s = offscreen.getGraphics();
        
        Pixel p = pc.getNext();
        s.setColor(p.getColor());
        s.fillRect(p.getX(),p.getY(),1,1);
        
        g.drawImage(offscreen, 0, 0, this);
        
        repaint();
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
