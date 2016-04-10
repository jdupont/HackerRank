package main;

public class MutableInteger implements Comparable<MutableInteger>
{
	public int value;

	public MutableInteger(int value)
	{
		this.value = value;
	}

	@Override
	public int compareTo(final MutableInteger arg0)
	{
		if (this.value > arg0.value)
		{
			return 1;
		}
		else if (this.value < arg0.value)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public boolean equals(final Object o)
	{
		if (!(o instanceof MutableInteger))
		{
			throw new IllegalArgumentException("Cannot compare mutable int to some other object");
		}
		else
		{
			return this.value == ((MutableInteger) o).value;
		}
	}

	@Override
	public int hashCode()
	{
		return this.value;
	}
}
