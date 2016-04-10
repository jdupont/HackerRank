package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution
{
	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			int numPeople = keyboard.nextInt();
			int numTopics = keyboard.nextInt();

			String[] knowledgeByTopic = stringArray(keyboard, numPeople);

			List<TeamMember> members = new ArrayList<TeamMember>();

			for (int i = 0; i < numPeople; ++i)
			{
				members.add(new TeamMember(i, numTopics));
			}

			for (int j = 0; j < numPeople; ++j)
			{
				String knowledgeOfPersonJ = knowledgeByTopic[j];

				for (int i = 0; i < numTopics; ++i)
				{
					char current = knowledgeOfPersonJ.charAt(i);

					if (current == '1')
					{
						members.get(j).addKnowledge(i);
					}
				}
			}

			Set<Team> teams = constructTeams(members);

			int maxTopics = 0;
			int numTeams = 0;

			for (Team team : teams)
			{
				if (team.topicsKnown > maxTopics)
				{
					maxTopics = team.topicsKnown;
					numTeams = 1;
				}
				else if (team.topicsKnown == maxTopics)
				{
					++numTeams;
				}
			}

			System.out.println(maxTopics);
			System.out.println(numTeams);
		}
	}

	public static String[] stringArray(final Scanner keyboard, final int length)
	{
		String[] lines = new String[length];
		for (int i = 0; i < length; ++i)
		{
			lines[i] = keyboard.next();
		}

		return lines;
	}

	public static Set<Team> constructTeams(final List<TeamMember> members)
	{
		Set<Team> teams = new HashSet<Team>();

		for (int i = 0; i < members.size() - 1; ++i)
		{
			for (int j = i + 1; j < members.size(); ++j)
			{
				teams.add(new Team(members.get(i), members.get(j)));
			}
		}

		return teams;
	}

	static class Team
	{
		public final TeamMember first;

		public final TeamMember second;

		public final int topicsKnown;

		public Team(final TeamMember first, final TeamMember second)
		{
			this.first = first;
			this.second = second;

			int totalTopics = 0;

			for (int i = 0; i < first.knowledge.length; ++i)
			{
				if (first.knowledge[i] || second.knowledge[i])
				{
					++totalTopics;
				}
			}

			this.topicsKnown = totalTopics;
		}

		@Override
		public boolean equals(final Object o)
		{
			if (!(o instanceof Team))
			{
				throw new IllegalArgumentException("Not a team.");
			}

			Team other = (Team) o;

			return (other.first.id == this.first.id && other.second.id == this.second.id)
					|| (other.second.id == this.first.id && other.first.id == this.second.id);
		}
	}

	static class TeamMember
	{
		public final int id;

		public final boolean[] knowledge;

		public TeamMember(final int id, final int numTopics)
		{
			this.id = id;
			this.knowledge = new boolean[numTopics];
		}

		public void addKnowledge(final int topicNumber)
		{
			this.knowledge[topicNumber] = true;
		}
	}
}