package myextension.given;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import spath.graphs.DirectedGraph;
import spath.graphs.Edge;
import spath.graphs.Vertex;
import spath.VertexAndDist;

// Compute shortest paths where some of the edge weights are negative numbers in a graph.
//
// Your constructor should compute the actual shortest paths and
// maintain all the information needed to reconstruct them.  The
// returnPath() function should use this information to return the
// appropriate path of edge ID's from the start to the given end.
//
// Note that the start and end ID's should be mapped to vertices using
// the graph's get() function.

public class NegativeSPath {
	private HashMap<Vertex, Node<VertexAndDist>> map;
	private HashMap<Vertex, Edge> toEdge;
	private Map<Edge, Integer> weights;
	private Vertex startVertex;
	private final DirectedGraph g;

	//
	// Constructor
	//
	public NegativeSPath(DirectedGraph g, Vertex startVertex, Map<Edge, Integer> weights) {

		this.map = new HashMap<Vertex, Node<VertexAndDist>>();
		this.toEdge = new HashMap<Vertex, Edge>();
		this.weights = weights;
		this.startVertex = startVertex;
		this.g = g;
	}

	//
	// This method does all the real work
	//
	public void run() {
		Tree<VertexAndDist> pq = new Tree<VertexAndDist>(3000);

		//
		// Initially all vertices are placed in the heap
		// far away from the start vertex
		//

		for (Vertex v : g.vertices()) {
			toEdge.put(v, null);
			VertexAndDist a = new VertexAndDist(v, 5000);
			Node<VertexAndDist> d = pq.insert(a);
			map.put(v, d);
		}

		//
		// Now we decrease the start node's distance from
		// itself to 0.
		// Note how we look up the Node using the map...
		//
		Node<VertexAndDist> startVertDist = map.get(startVertex);
		//
		// and then decrease it using the decrease method
		//
		startVertDist.decrease(startVertDist.getValue().sameVertexNewDistance(0));

		//
		// OK you take it from here

		
		
		// Detect negative cycles and print the error

	}

	/**
	 * Return a List of Edges forming a shortest path from the startVertex to
	 * the specified endVertex. Do this by tracing backwards from the endVertex,
	 * using the map you maintain during the shortest path algorithm that
	 * indicates which Edge is used to reach a Vertex on a shortest path from
	 * the startVertex.
	 * 
	 * @param endVertex
	 * @return shortest path from the startVertex to the endVertex
	 */
	public LinkedList<Edge> returnPath(Vertex endVertex) {
		LinkedList<Edge> path = new LinkedList<Edge>();
		
		
		return path;
	}

	/**
	 * Return the length of all shortest paths. This method is completed for
	 * you, using your solution to returnPath.
	 * 
	 * @param endVertex
	 * @return the cost of shortest path
	 */
	public int returnValue(Vertex endVertex) {
		LinkedList<Edge> path = returnPath(endVertex);
		int pathValue = 0;
		for (Edge e : path) {
			pathValue += weights.get(e);
		}
		return pathValue;

	}
}
