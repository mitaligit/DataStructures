/**
 * CSE 373, Winter 2011, Jessica Miller
 * A class for a directed graph.  
 * Implemented by an adjacency list representation of a graph.
 */
import java.util.*;

public class Graph<V> implements IGraph<V> {
    private Map<V, List<Edge<V>>> adjacencyList;  // [vertices] -> [edge]
    private Map<V, VertexInfo<V>> vertexInfo;     // [vertex] -> [info]
    
    public Graph() {
        this.adjacencyList = new HashMap<V, List<Edge<V>>>();
        this.vertexInfo = new HashMap<V, VertexInfo<V>>();
    }
    
    public void addVertex(V v) {
        if (v == null) {
            throw new IllegalArgumentException("null");
        }        
        
        adjacencyList.put(v, new ArrayList<Edge<V>>());
        vertexInfo.put(v, new VertexInfo<V>(v));
    }
    
    public void addEdge(V from, V to, int weight) {
        List<Edge<V>> edgeList = adjacencyList.get(from);
        if (edgeList == null) {
            throw new IllegalArgumentException("source vertex not in graph");
        }
        
        Edge<V> newEdge = new Edge<V>(from, to, weight);
        edgeList.add(newEdge);
    }

    public boolean hasEdge(V from, V to) {
        return getEdge(from, to) != null;
    }

    public Edge<V> getEdge(V from, V to) {
        List<Edge<V>> edgeList = adjacencyList.get(from);
        if (edgeList == null) {
            throw new IllegalArgumentException("source vertex not in graph");
        }
        
        for(Edge<V> e : edgeList) {
        	if (e.to.equals(to)) {
        		return e;
        	}
        }
        
        return null;
    }

    public boolean hasPath(V v1, V v2) {
        return getDFSPath(v1, v2) != null;
    }

    public List<V> getDFSPath(V v1, V v2) {
        clearVertexInfo();
        
        List<V> path = new ArrayList<V>();
        Set<V> seen = new HashSet<V >();
        getDFSPath(v1, v2, path, seen);
        
        if (path.isEmpty()) {
            return null;
        } else {
            return path;
        }
    }
    private List<V> getDFSPath(V v1, V v2, List<V> path, Set<V> seen)
    {
    	path.add(v1);
    	
    	seen.add(v1); 
    	if(v1.equals(v2))
    	{
    		return path;
    	}
    	 List<Edge<V>> edges = this.adjacencyList.get(v1);
         for (Edge<V> e : edges) {
         	if (!seen.contains(e.to))
         			{
         		getDFSPath(e.to, v2, path, seen);
                 if (path.get(path.size() - 1).equals(v2)) {
                     return path;
                 	}
         		}
         }
         path.remove(v1);
         return path;
         	
    }
    
    /*private List<V> getDFSPath(V v1, V v2, List<V> path) {
        path.add(v1);
        VertexInfo<V> vInfo = vertexInfo.get(v1);
        vInfo.visited = true;
        
        if (v1.equals(v2)) {
        	return path;
        }
        
        List<Edge<V>> edges = this.adjacencyList.get(v1);
        for (Edge<V> e : edges) {
        	VertexInfo<V> vInfo2 = vertexInfo.get(e.to);
        	if (!vInfo2.visited) {
        		getDFSPath(e.to, v2, path);
                if (path.get(path.size() - 1).equals(v2)) {
                    return path;
                }
        	}
        }
        
        path.remove(v1);
        return path;
    }*/
    
    public List<V> getBFSPath(V v1, V v2)throws Exception
    {
     Queue<V> q = new LinkedList<V>();
     Map<V , Edge<V> > reached = new HashMap<V , Edge<V> >();
     List<V> path = new ArrayList<V>();
     Queue<Edge<V>> l = new LinkedList<Edge<V>>();
 	 reached.put(v1, null) ;
     q.add(v1);
     while(!q.isEmpty())
     {
    	 V v = q.remove();
    	 if(v.equals(v2))
    	 {
    		break; 
    	 }
    	l.addAll(adjacencyList.get(v));
    	 while(!l.isEmpty())
    	 {
    		Edge<V> e = l.remove();
    		V dest = e.to;
    		if(!reached.containsKey(dest))
    		{
    			reached.put(dest, e);
    			q.add(dest);
    		}
    	 }
     }
     Edge<V> e1 = reached.get(v2);
     while(e1 != null)
     {
    	 path.add(e1.from);
    	 e1 = reached.get(e1.from);
     }
     if(path.size() == 0 || !path.get(path.size()-1).equals(v1))
     {
    	 throw new Exception("no route");
     }
     Collections.reverse(path);
     path.add(v2);
     return path;
    }
    
    
    
    public String toString() {
        Set<V> keys = adjacencyList.keySet();
        String str = "";
        
        for (V v : keys) {
            str += v + ": ";
            
            List<Edge<V>> edgeList = adjacencyList.get(v);
            
            for (Edge<V> edge : edgeList) {
                str += edge + "  ";
            }
            str += "\n";
        }
        return str;
    }
    
    protected final void clearVertexInfo() {
        for (VertexInfo<V> info : this.vertexInfo.values()) {
            info.clear();
        }
    }
    public List<V> minimumWeightPath(V v1, V v2) throws Exception
    {
    	if( v1 == null || v2 == null || v1.equals(v2)) 
    		return null;
    	
    	PriorityQueue<Edge<V>> pQueue = new PriorityQueue<Edge<V>>();
    	Map<V , Edge<V> > reached = new HashMap<V , Edge<V> >();
    	
    	reached.put(v1, null) ;
    	pQueue.addAll(adjacencyList.get(v1));
    	while ( !pQueue.isEmpty()) {
    		Edge<V> e = pQueue.remove();
    		V dest = e.to ;
    		if (reached.containsKey(dest)) {
    			continue;
    		} else {
    			reached.put( dest , e);
    			pQueue.addAll(adjacencyList.get(dest));
    		}
        }
    	
    	List<V> path = new ArrayList<V>();
    	Edge<V> e1 = reached.get(v2);
    	while ( e1 != null) {
    		path.add(e1.from);
    		e1 = reached.get(e1.from);
    	}
    	if ( path.size() == 0 || !path.get(path.size() -1).equals(v1)  ) {
    		throw new Exception("No RouteFound between v1 and v2");
    	}
    	Collections.reverse(path);
    	path.add(v2);
    	return path;
    }
}
