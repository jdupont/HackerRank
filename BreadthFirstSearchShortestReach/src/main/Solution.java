package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution
{

	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int numCases = keyboard.nextInt();

			for (int i = 0; i < numCases; ++i)
			{
				Graph<Integer> graph = readGraph(keyboard, 6);
				int startingNode = keyboard.nextInt();

				for (int j = 0; j < graph.numberOfNodes(); ++j)
				{
					if (j + 1 == startingNode)
					{
						// Skip the distance from the node to itself
						continue;
					}

					System.out.print(graph.leastDistanceTo(graph.getByIndex(startingNode - 1), j + 1) + " ");
				}

				System.out.println();
			}
		}
	}

	public static Graph<Integer> readGraph(final Scanner keyboard, final int edgeWeight)
	{
		// Assuming N M on first line, where N is number of nodes and M is
		// number of edges
		int numNodes = keyboard.nextInt();
		int numEdges = keyboard.nextInt();

		Graph<Integer> graph = Graph.integerGraph(numNodes, false);

		for (int i = 0; i < numEdges; ++i)
		{
			int start = keyboard.nextInt();
			int end = keyboard.nextInt();
			graph.addEdge(graph.getByIndex(start - 1), graph.getByIndex(end - 1), edgeWeight);
		}

		return graph;
	}

	static class Graph<T>
	{
		private final List<Node<T>> nodes;

		private final List<Edge<T>> edges;

		public Graph()
		{
			this.nodes = new ArrayList<Node<T>>();
			this.edges = new ArrayList<Edge<T>>();
		}

		public static Graph<Integer> integerGraph(final int numNodes, final boolean zeroIndex)
		{
			Graph<Integer> graph = new Graph<Integer>();

			for (int i = 0; i < numNodes; ++i)
			{
				graph.add(new Node<Integer>(zeroIndex ? i : (i + 1)));
			}

			return graph;
		}

		public void add(final Node<T> node)
		{
			this.nodes.add(node);
		}

		public void addEdge(final Node<T> first, final Node<T> second, final int weight)
		{
			this.edges.add(new Edge<T>(first, second, weight));

			first.addEdge(second, weight);
			second.addEdge(first, weight);
		}

		public Node<T> getByIndex(final int num)
		{
			return this.nodes.get(num);
		}

		public Node<T> getByValue(final T value)
		{
			for (Node<T> node : this.nodes)
			{
				if (node.value().equals(value))
				{
					return node;
				}
			}

			throw new IllegalArgumentException("Value not found.");
		}

		public void clearVisitation()
		{
			for (Node<T> node : this.nodes)
			{
				node.setVisited(false);
			}
		}

		public String edgesToString()
		{
			StringBuilder builder = new StringBuilder();

			for (Edge<T> edge : this.edges)
			{
				builder.append(edge.first().value().toString() + " " + edge.second().value().toString()
						+ System.lineSeparator());
			}

			return builder.toString();
		}

		public int leastDistanceTo(final Node<T> starting, final T value)
		{
			this.clearVisitation();

			Queue<DistanceTracker<T>> queue = new LinkedList<DistanceTracker<T>>();

			starting.setVisited(true);
			queue.add(new DistanceTracker<T>(starting, 0));

			int distance = 0;
			boolean found = false;

			while (!queue.isEmpty() && !found)
			{
				DistanceTracker<T> current = queue.remove();

				if (current.node.value().equals(value))
				{
					distance = current.distance;
					found = true;
				}

				for (DistanceTracker<T> neighbor : current.node.neighbors())
				{
					if (!neighbor.node.visited())
					{
						queue.add(new DistanceTracker<T>(neighbor.node, current.distance + neighbor.distance));
						neighbor.node.setVisited(true);
					}
				}
			}

			if (found)
			{
				return distance;
			}
			else
			{
				return -1;
			}
		}

		public int numberOfNodes()
		{
			return this.nodes.size();
		}

		public class Edge<E>
		{
			private final Node<E> first;

			private final Node<E> second;

			private final int weight;

			public Edge(final Node<E> first, final Node<E> second, final int weight)
			{
				this.first = first;
				this.second = second;
				this.weight = weight;
			}

			public int weight()
			{
				return this.weight;
			}

			public Node<E> first()
			{
				return this.first;
			}

			public Node<E> second()
			{
				return this.second;
			}
		}

		public static class Node<N>
		{
			private final N value;

			private final List<DistanceTracker<N>> neighbors;

			private boolean visited;

			public Node(N value)
			{
				this.value = value;
				this.neighbors = new ArrayList<DistanceTracker<N>>();
				this.visited = false;
			}

			public void setVisited(final boolean value)
			{
				this.visited = value;
			}

			public boolean visited()
			{
				return this.visited;
			}

			public N value()
			{
				return this.value;
			}

			public void addEdge(final Node<N> node, final int distance)
			{
				this.neighbors.add(new DistanceTracker<N>(node, distance));
			}

			public List<DistanceTracker<N>> neighbors()
			{
				return this.neighbors;
			}
		}

		private static class DistanceTracker<E>
		{
			public final Node<E> node;

			public final int distance;

			public DistanceTracker(Node<E> node, int distance)
			{
				this.node = node;
				this.distance = distance;
			}
		}
	}

}