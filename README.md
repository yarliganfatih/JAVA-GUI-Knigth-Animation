# JAVA-GUI-Knigth-Animation

Knigth Animation on ChessBoard

You are required to implement Knigth’s move animation in Chess table.

### Motion:

The Knigth may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically (with both forming the shape of an L). This way, a knight can have a maximum of 8 moves.

You must use and complete the provided code.

- override paintComponent to create graphics
  - draw chessboard (5 pts)
  - draw Knigth image ( 5pts)
  - draw Knigth image into the cell at mouse coordinate( 5pts)
- Use Thread to animate (20pts)
  - animation will start when mouse cliecked at starting position (any cell).
    - You should implement MouseMotionListener to listen mouse motion (10pts)
  - After each move colour of the visited position will be gray color (5pts).
- Add button to frame to send all move coordinates to a Server (assume you have server app, do not implement server app) (5pts)
- When user clicks button coordinates of all visited cells should be sent to a server. (i.e (1,1), (4,3),…..(do not implement server app)) (5pts)
  - You are free to use any method/format when sending coordinates.
  - You are free to use any hostname and port number for the server.

### ScreenShots

![image](https://user-images.githubusercontent.com/54783062/172060592-6f6dc8a0-1b9b-4708-9cf3-3f9a3a8e9f11.png)

## Code Structure

```java
public class KnigthAnimation extends JComponent {
    // possible Knigths moves
    int []movex = { -2, -1, 1, 2, -2, -1, 1, 2 };
    int []movey = { -1, -2, -2, -1, 1, 2, 2, 1 };
    int [][]chessboard = new int[8][8];
    Image image = ImageIO.read(new File("Knigth.png"));

    public static void main(String[] args) {
        JFrame frame = new JFrame("KNIGTH ANIMATION");






        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();


    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
```

### Chegg
https://www.chegg.com/homework-help/questions-and-answers/required-implement-knigth-s-move-animation-chess-table-motion-knigth-may-move-two-squares--q80508988