import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class ScatterGraph extends SimulationGraph{
	protected double radius = 3;

	public void setRadius(double radius){
		this.radius = radius;
	}

	public double getRadius(){
		return this.radius;
	}

	public void drawGraph(Graphics g){
		Graphics2D g2D = (Graphics2D)g;

		for(Pair<Double,Double> coordinates : this.scaledValues){
			double x = coordinates.getFirst() - this.radius;
			double y = coordinates.getSecond() - this.radius;

			g2D.draw(new Ellipse2D.Double(x, y, this.radius * 2, this.radius * 2));
		}
	}
}