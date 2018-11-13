import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;

public class FractalTreePanel extends JPanel {

    private List<int[]> drawQueue = new ArrayList<>();

    public void drawTree(int x1, int y1, int angle, int depth) {
        int[] queuedTree = {x1, y1, angle, depth};
        drawQueue.add(queuedTree);
    }

    private void _drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return; //base case
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 5.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 5.0);
        g.drawLine(x1, y1, x2, y2);
        _drawTree(g, x2, y2, angle - 20, depth - 1);
        _drawTree(g, x2, y2, angle + 20, depth - 1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN.darker());
        for(int[] q: drawQueue) {
            _drawTree(g, q[0], q[1], (double)q[2], q[3]);
        }
    }
}
