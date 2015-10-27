import java.util.LinkedList;
import javax.swing.JPanel;	
import java.awt.Graphics;
import java.awt.Color;

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
		g.translate(20, this.graphHeight - 20);
		//g.rotate(Math.PI);	
		//g.setBackground(this.graphBackgroundColor);
		//g.setColor(this.visualizationColor);

		this.drawGraph(g);
	}

	public abstract void drawGraph(Graphics g);
}