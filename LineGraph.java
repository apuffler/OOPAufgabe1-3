import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class LineGraph extends SimulationGraph{
	public void drawGraph(Graphics g){
		Graphics2D g2D = (Graphics2D)g;

		Pair<Double, Double> coordinates1 = this.scaledValues.get(0);

		for(int i = 0; i < this.scaledValues.size(); ++i){
			Pair<Double, Double> coordinates2;
			if(i + 1 < this.scaledValues.size())
				coordinates2 = this.scaledValues.get(i);
			else 
				coordinates2 = coordinates1;

			double x1 = coordinates1.getFirst();
			double y1 = coordinates1.getSecond();

			double x2 = coordinates2.getFirst();
			double y2 = coordinates2.getSecond();

			g2D.draw(new Line2D.Double(x1, y1, x2, y2));

			coordinates1 = coordinates2;	
		}
	}
}