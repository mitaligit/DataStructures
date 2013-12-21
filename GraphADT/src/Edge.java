public class Edge<V> implements Comparable< Edge<V> >{
    public V from, to;
    public int weight;

    public Edge(V from, V to, int weight) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("null");
        }
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int compareTo( Edge<V> e){
    	return (this.weight - e.weight);
    }

    public String toString() {
        return "<" + from + ", " + to + ", " + weight + ">";
    }
}