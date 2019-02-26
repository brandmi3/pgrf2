package rasterOperation.ui;

import rasterOperation.VisibilityZBuffer;
import rasterOperation.render.Renderer;
import transforms.Col;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import java.util.Timer;
import java.util.TimerTask;

public class PgrfFrame extends JFrame implements MouseMotionListener {
    private BufferedImage img;
    private VisibilityZBuffer visibilityZBuffer;
    private static int Bwidth = 500;
    private static int Bheight = 500;
    private JPanel jPanel = new JPanel();
    private Timer timer = new Timer();
    private Renderer renderer;
    private int X1,X2;
    private int Y1,Y2;
    private boolean firstClick = true;
    public static void main(String[] args) {
        PgrfFrame pgrfFrame = new PgrfFrame();
        pgrfFrame.img = new BufferedImage(Bwidth,Bheight,BufferedImage.TYPE_INT_ARGB);
        pgrfFrame.init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(500,500));
        setVisible(true);
        setTitle("Grafika 2");
        setLocationRelativeTo(null);

        add(jPanel, BorderLayout.CENTER);
        visibilityZBuffer = new VisibilityZBuffer(Bwidth,Bheight);
        visibilityZBuffer.init(Color.GREEN.getRGB());
        renderer = new Renderer(visibilityZBuffer.getBufferedImage());

        jPanel.addMouseMotionListener(this);
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (firstClick){
                    System.out.println(e.getX());
                    X1 = e.getX();
                    Y1 = e.getY();
                    X2 = e.getX();
                    Y2 = e.getY();
                    firstClick = !firstClick;
                }else{
                    System.out.println(e.getY());
                    X2 = e.getX();
                    Y2=e.getY();
                    firstClick = !firstClick;
                }
            }
        });
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                draw();

            }
        }, 100, (1000/30));
    }

    private void draw() {
     //   img.getGraphics().fillRect(0,0,Bwidth,Bheight);
        visibilityZBuffer.getBufferedImage().getGraphics().fillRect(0,0,Bwidth,Bheight);

        renderer.lineDDA(X1,Y1,X2,Y2,Color.BLACK.getRGB());

        jPanel.getGraphics().drawImage(visibilityZBuffer.getBufferedImage(),0,0,null);
        jPanel.paintComponents(getGraphics());
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (!firstClick){
            X2 = e.getX();
            Y2 = e.getY();
        }
    }
}
