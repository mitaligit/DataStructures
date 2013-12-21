import java.util.*;

public interface IGraph<V> {
    public void addVertex(V v);
    
    public void addEdge(V v1, V v2, int weight);
    
    public boolean hasEdge(V v1, V v2);
    
    public Edge<V> getEdge(V v1, V v2);
    
    public boolean hasPath(V v1, V v2);

    public List<V> getDFSPath(V v1, V v2);
    public List<V> getBFSPath(V v1, V v2) throws Exception; 
    
    public String toString();
    public List<V> minimumWeightPath(V v1, V v2) throws Exception;
}