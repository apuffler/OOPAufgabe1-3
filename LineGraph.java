import java.awt.Graphics;

public class LineGraph extends SimulationGraph{
	public void paintComponent(Graphics g){
		g.drawLine(0, 0, 100, 100);
	}
}