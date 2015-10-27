public class GraphTester{
	public static void main(String[] args){
		ScatterGraph lineG = new ScatterGraph();
		for(int i = 0; i < 10; ++i){
			lineG.addData(i * 20, i * 20);
		}
		GraphVisualizer g1 = new GraphVisualizer(lineG);
	}
}