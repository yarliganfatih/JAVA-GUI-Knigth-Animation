import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class KnigthAnimation  extends JComponent  {
    // possible Knigths moves
    int []movex = { -2, -1, 1, 2, -2, -1, 1, 2 };
    int []movey = { -1, -2, -2, -1, 1, 2, 2, 1 };
    int [][]chessboard = new int[8][8];

    int []position = {2, 2};
    //Image image = ImageIO.read(new File("Knigth.png")); //Error
    private BufferedImage image;

    public KnigthAnimation(){
        try {
            image = ImageIO.read(new FileImageInputStream(new File("assets/knight.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                chessboard[i][j] = 0;
            }
        }
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                    int x = (int)e.getX()/100;
                    int y = (int)e.getY()/100;
                    System.out.println(x+", "+y);
                    
        for(int i=0;i<8;i++){
            if(x==position[0]+movex[i]){
                if(y==position[1]+movey[i]){
                    if(chessboard[x][y]==0){
                        position[0] = x;
                        position[1] = y;
                        repaint();
                    }
                    chessboard[x][y]=1;
                    }
                    
                }
                
            }
        }
        });
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("KNIGTH ANIMATION");
        frame.add(new KnigthAnimation());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
		frame.setSize(810, 837);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((i+j)%2==0){
                    g2d.setColor(Color.BLACK);
                    if(chessboard[i][j]==1){
                        g2d.setColor(Color.GRAY);
                    }
                }else{
                    g2d.setColor(Color.WHITE);
                }
                g2d.fillRect(100*i, 100*j, 100, 100);
            }
        }
        g2d.drawImage(image, position[0]*100, position[1]*100, 100, 100, this);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
    
    }

}