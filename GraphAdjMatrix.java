/*
 * @author Rakesh Raju
 * 11/29/17
 * 
 */


import java.util.Stack;

public class GraphAdjMatrix implements Graph {

	private int[][] graph;
	private int size;

	//constructor
	public GraphAdjMatrix(int vertices) {
		size = vertices;
		graph = new int[size][size];

	}

	//adds value at selected coordinate
	public void addEdge(int v1, int v2) {
		graph[v1][v2] = 1;
	}

	//topological sort function
	public void topologicalSort() {
		Stack<Integer> s = new Stack<Integer>();
		int[] numbers = new int[size];
		int content = 0;

		for (int i = 0; i < size; i++) {
			numbers[i] = 0;
		}

		for (int i = 0; i < size; i++) {
			int[] neighbors = neighbors(i);
			for (int j = 0; j < neighbors.length; j++) {
				numbers[neighbors[j]]++;
			}
		}

		for (int i = 0; i < size; i++) {
			if (numbers[i] == 0) {
				s.push(i);
			}
		}

		if (s.empty()) {
			int i = 0;
			numbers[i] = 0;
			s.push(i);
		}

		while (!s.empty()) {
			int instance = s.pop();
			System.out.print(instance + " ");
			content++;

			int[] neighbors = neighbors(instance);
			for (int i = 0; i < neighbors.length; i++) {

				int dest = neighbors[i];
				numbers[dest]--;
				if (numbers[dest] == 0) {
					s.push(dest);
				}
			}

		}

		System.out.println("");
	}

	//returns neighbors of requested vertex
	public int[] neighbors(int vertex) {
		int[] neighborArray = new int[size];
		int index = 0;
		for (int i = 0; i < size; i++) {
			int vertex1 = graph[vertex][i];
			if (vertex1 == 1 && i != vertex) {
				neighborArray[index] = i;
				index++;
			}
		}

		int[] neighbors = new int[index];
		for (int i = 0; i < index; i++) {
			neighbors[i] = neighborArray[i];
		}

		return neighbors;
	}

}