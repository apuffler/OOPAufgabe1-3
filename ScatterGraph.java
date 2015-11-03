import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class ScatterGraph extends SimulationGraph{
	protected double radius = 3;

	/**
	 *Method used set the radius of the scatter-points
	 *
	 *@param (radius) Expected to be > 0; If == 0 then all points would be invisible;
	 */
	public void setRadius(double radius){
		this.radius = radius;
	}

	public double getRadius(){
		return this.radius;
	}

	/**
	 *Method draw ScatterPlot
	 *
	 *@param (g) Expected to be != NULL, otherwise would throw exception;
	 */
	public void drawGraph(Graphics g){
		Graphics2D g2D = (Graphics2D)g;

		for(Pair<Double,Double> coordinates : this.scaledValues){
			double x = coordinates.getFirst() - this.radius;
			double y = coordinates.getSecond() - this.radius;

			g2D.draw(new Ellipse2D.Double(x, y, this.radius * 2, this.radius * 2));
		}
	}
}