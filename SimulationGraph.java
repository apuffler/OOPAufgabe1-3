import java.util.LinkedList;
import javax.swing.JPanel;	
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;

abstract class SimulationGraph extends JPanel{
	private final int markerLineSize = 2;

	protected LinkedList<Pair<Double, Double>> graphValues;	
	protected LinkedList<Pair<Double, Double>> scaledValues;

	protected String graphName;
	protected String xAxisName;
	protected String yAxisName; 

	protected int graphWidth = 600;
	protected int graphHeight = 600;

	protected double xAxisScale = 1;
	protected double yAxisScale = 1;

	protected Color graphBackgroundColor = Color.white;
	protected Color visualizationColor = Color.black;

	public SimulationGraph(){
		this.graphValues = new LinkedList<Pair<Double, Double>>();
		this.graphName = "[GRAPH]";
		this.xAxisName = "X-Axis";
		this.yAxisName = "Y-Axis";
	}

	public void setXAxisName(String xAxisName){
		this.xAxisName = xAxisName;
	}

	public void setYAxisName(String yAxisName){
		this.yAxisName = yAxisName;
	}

	public String getXAxisName(){
		return this.xAxisName;
	}

	public String getYAxisName(){
		return this.yAxisName;
	}

	public void setGraphName(String graphName){
		this.graphName = graphName;
	}

	public String getGraphName(){
		return this.graphName;
	}

	public LinkedList<Pair<Double, Double>> getGraphValues(){
		return this.graphValues;
	}

	/**
	 *Method used to add an Data-Entry intor the GraphList
	 *
	 *@param (x) Value for the X-Axis;
	 *@param (y) Value for the Y-Axis;
	 */
	public void addData(double x, double y){
		this.graphValues.add(new Pair<Double, Double>(x, y));
	}

	public int getGraphWidth(){
		return this.graphWidth;
	}

	/**
	 *Method used to set the width of the drawn graph
	 *
	 *@param (graphWidth) Value for the Graph-Width; Expected to be > 0;
	 */
	public void setGraphWidth(int graphWidth){
		this.graphWidth = graphWidth;
	}

	public int getGraphHeight(){
		return this.graphHeight;
	}

	/**
	 *Method used to set the height of the drawn graph
	 *
	 *@param (graphHeight) Value for the Graph-Height; Expected to be > 0;
	 */
	public void setGraphHeigth(int graphHeight){
		this.graphHeight = graphHeight;
	}

	public double getYAxisScale(){
		return this.yAxisScale;
	}

	/**
	 *Method used to set the scaling of the y-Axis
	 *
	 *@param (yAxisScale) Value for the y-Scaling; Expected to be > 0; If == 0 then all drawn values will have y = 0; If < 0 the graph is turned upside down
	 */
	public void setYAxisScale(double yAxisScale){
		this.yAxisScale = yAxisScale;
	}

	public double getXAxisScale(){
		return this.xAxisScale;
	}


	/**
	 *Method used to set the scaling of the x-Axis
	 *
	 *@param (xAxisScale) Value for the x-Scaling; Expected to be > 0; If == 0 then all drawn values will have x = 0; If < 0 the graph is flipped
	 */
	public void setXAxisScale(double xAxisScale){
		this.xAxisScale = xAxisScale;
	}

	public Color getBackgroundColor(){
		return this.graphBackgroundColor;
	}


	/**
	 *Method used to set the Background-Color of the Graph
	 *
	 *@param (backgroundColor) Expected to be != NULL;
	 */
	public void setBackgroundColor(Color backgroundColor){
		this.graphBackgroundColor = backgroundColor;
	}

	public Color getGraphColor(){
		return this.visualizationColor;
	}

	/**
	 *Method used to set the Color of Graph
	 *
	 *@param (graphColor) Expected to be != NULL, otherwise the paintComponent-Method would throw an exception
	 */
	public void setGraphColor(Color graphColor){
		this.visualizationColor = graphColor;
	}

	private void scaleData(){
		LinkedList<Pair<Double, Double>> newValues = new LinkedList<Pair<Double, Double>>();
		for(int i = 0; i < this.graphValues.size(); ++i){
			Pair<Double, Double> data = this.graphValues.get(i);
			newValues.add(new Pair<Double, Double>(data.getFirst() * xAxisScale, data.getSecond() * yAxisScale));
		}
		this.scaledValues = newValues;
	}

	//BAD: Graphics-Object needs to be passed, would be better if implemented in the paintComponent-Method
	/**
	 *Method used to draw markers on the x- and the y-axis
	 *
	 *@param (g) Expected to be != NULL, otherwise would throw exception;
	 */
	private void axisInformation(Graphics g){
		Graphics2D g2D = (Graphics2D)g;

		for(Pair<Double, Double> sValue : this.scaledValues){

			double scaledX = sValue.getFirst();
			double scaledY = sValue.getSecond();

			g2D.draw(new Line2D.Double(scaledX, -this.markerLineSize, scaledX, this.markerLineSize));
			g2D.draw(new Line2D.Double(-this.markerLineSize, scaledY, this.markerLineSize, scaledY));
		}
	}

	/**
	 *Method used to draw the Graph on a panel
	 *
	 *@param (g) Expected to be != NULL, otherwise would throw exception;
	 */
	public void paintComponent(Graphics g){
		this.scaleData();

		Graphics2D g2D = (Graphics2D)g;	

		g2D.drawString(this.graphName, this.graphWidth / 2, 20);
		g2D.drawString(this.xAxisName, this.graphWidth / 2, this.graphHeight - 24);
		g2D.drawString(this.yAxisName, 24, this.graphHeight / 2);

		g2D.translate(0, graphHeight);
		g2D.translate(20, -20);
		g2D.scale(1, -1);	

		g2D.draw(new Line2D.Double(0, 0, 0, graphHeight - 20));
		g2D.draw(new Line2D.Double(0, 0, graphWidth - 20, 0));

		g2D.draw(new Line2D.Double(0, graphHeight - 20, -7, graphHeight - 27));
		g2D.draw(new Line2D.Double(0, graphHeight - 20, 7, graphHeight - 27));

		g2D.draw(new Line2D.Double(graphWidth - 20, 0, graphWidth - 37, 7));
		g2D.draw(new Line2D.Double(graphWidth - 20, 0, graphWidth - 37, -7));


		this.axisInformation(g);
		g2D.setColor(this.visualizationColor);
		this.drawGraph(g);
	}

	public abstract void drawGraph(Graphics g);
}