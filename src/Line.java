import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

public class Line extends JComponent implements MouseInputListener {

	private Line2D line = null;

	public Line() {
		setForeground(Color.RED);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(300, 300));
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(getForeground());
		if (line != null)
			((Graphics2D) g).draw(line);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (line == null)
			line = new Line2D.Double(x, y, x, y);
		else
			line.setLine(x, y, x, y);
		repaint();
	}

	private void setEndLine(MouseEvent e) {
		line.setLine(line.getX1(), line.getY1(), e.getX(), e.getY());
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		setEndLine(e);
	}

	public void mouseDragged(MouseEvent e) {
		setEndLine(e);
	}

	public void mouseMoved(MouseEvent e) {
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Line");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Line());
		frame.pack();
		frame.setVisible(true);
	}
}