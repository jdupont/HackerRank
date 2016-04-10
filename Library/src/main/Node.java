package main;

import java.util.ArrayList;
import java.util.List;

public class Node<T>
{
	public final Node<T> parent;

	public final List<Node<T>> children = new ArrayList<Node<T>>();

	public final T value;

	public Node(final Node<T> parent, final T value)
	{
		this.value = value;
		this.parent = parent;
	}

	public void PreOrderLeftToRight(final Action<T> action)
	{
		action.process(this.value);

		for (Node<T> child : this.children)
		{
			child.PreOrderLeftToRight(action);
		}
	}

	public void PostOrderLeftToRight(final Action<T> action)
	{
		for (Node<T> child : this.children)
		{
			child.PreOrderLeftToRight(action);
		}

		action.process(this.value);
	}

	public interface Action<T>
	{
		public void process(final T value);
	}
}
