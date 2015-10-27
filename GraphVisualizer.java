import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphVisualizer{
	private JFrame visualizationWindow;

	public GraphVisualizer(SimulationGraph graph){
		this.visualizationWindow = new JFrame();

		this.visualizationWindow.setTitle(graph.getGraphName());
		this.visualizationWindow.setSize(graph.getGraphWidth(), graph.getGraphHeight());

		this.visualizationWindow.add(graph);
		this.visualizationWindow.setVisible(true);
		this.visualizationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}