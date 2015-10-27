import java.util.LinkedList;
import javax.swing.JPanel;	
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;

abstract class SimulationGraph extends JPanel{
	protected LinkedList<Pair<Double, Double>> graphValues;	

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

	public void addData(double x, double y){
		this.graphValues.add(new Pair<Double, Double>(x, y));
	}

	public int getGraphWidth(){
		return this.graphWidth;
	}

	public void setGraphWidth(int graphWidth){
		this.graphWidth = graphWidth;
	}

	public int getGraphHeight(){
		return this.graphHeight;
	}

	public void setGraphHeigth(int graphHeight){
		this.graphHeight = graphHeight;
	}

	public double getYAxisScale(){
		return this.yAxisScale;
	}

	public void setYAxisScale(double yAxisScale){
		this.yAxisScale = yAxisScale;
	}

	public double getXAxisScale(){
		return this.xAxisScale;
	}

	public void setXAxisScale(double xAxisScale){
		this.xAxisScale = xAxisScale;
	}

	public Color getBackgroundColor(){
		return this.graphBackgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor){
		this.graphBackgroundColor = backgroundColor;
	}

	public void paintComponent(Graphics g){
		Graphics2D g2D = (Graphics2D)g;

		g2D.translate(0, this.graphHeight);
		g2D.rotate(Math.toRadians(-90));

		g2D.translate(20, 20);


		this.drawGraph(g);
	}

	public abstract void drawGraph(Graphics g);
}