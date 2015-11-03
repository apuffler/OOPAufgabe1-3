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

	//ASSERT: Given Double-Values are expected to be greater than null
	public void addData(double x, double y){
		this.graphValues.add(new Pair<Double, Double>(x, y));
	}

	public int getGraphWidth(){
		return this.graphWidth;
	}

	//ASSERT: Given Integer is expected to be greater than zero 
	public void setGraphWidth(int graphWidth){
		this.graphWidth = graphWidth;
	}

	public int getGraphHeight(){
		return this.graphHeight;
	}

	//ASSERT: Given Integer is expected to be greaater than zero
	public void setGraphHeigth(int graphHeight){
		this.graphHeight = graphHeight;
	}

	public double getYAxisScale(){
		return this.yAxisScale;
	}

	//ASSERT: Given Double is expected not to be zero
	public void setYAxisScale(double yAxisScale){
		this.yAxisScale = yAxisScale;
	}

	public double getXAxisScale(){
		return this.xAxisScale;
	}

	//ASSERT: Given Double is expected not to be zero
	public void setXAxisScale(double xAxisScale){
		this.xAxisScale = xAxisScale;
	}

	public Color getBackgroundColor(){
		return this.graphBackgroundColor;
	}

	//ASSERT: Given Color is expected not to be null
	public void setBackgroundColor(Color backgroundColor){
		this.graphBackgroundColor = backgroundColor;
	}

	public Color getGraphColor(){
		return this.visualizationColor;
	}

	//ASSERT: Given  Color is expected not to be null
	public void setGraphColor(Color graphColor){
		this.visualizationColor = graphColor;
	}

	//scaleData erzeugt ein neues LinkedList-Objekt, welches die skalierten Datenwerte für den Graphen enthält
	private void scaleData(){
		LinkedList<Pair<Double, Double>> newValues = new LinkedList<Pair<Double, Double>>();
		for(int i = 0; i < this.graphValues.size(); ++i){
			Pair<Double, Double> data = this.graphValues.get(i);
			newValues.add(new Pair<Double, Double>(data.getFirst() * xAxisScale, data.getSecond() * yAxisScale));
		}
		this.scaledValues = newValues;
	}

	private void axisInformation(Graphics g){
		Graphics2D g2D = (Graphics2D)g;

		for(Pair<Double, Double> sValue : this.scaledValues){

			double scaledX = sValue.getFirst();
			double scaledY = sValue.getSecond();

			g2D.draw(new Line2D.Double(scaledX, -this.markerLineSize, scaledX, this.markerLineSize));
			g2D.draw(new Line2D.Double(-this.markerLineSize, scaledY, this.markerLineSize, scaledY));
		}
	}

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