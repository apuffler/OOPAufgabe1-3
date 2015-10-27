public class Pair<S,T>{
	private S first;
	private T second;

	public Pair(S first, T second){
		this.first = first;
		this.second = second;
	}

	public void setFirst(S first){
		this.first = first;
	}

	public S getFirst(){
		return this.first;
	}

	public void setSecond(T second){
		this.second = second;
	}

	public T getSecond(){
		return this.second;
	}
}