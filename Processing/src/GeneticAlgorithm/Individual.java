package GeneticAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

import com.mifmif.common.regex.Generex;

import GetXsdConstraints.MNode;

//C++ program to create target string, starting from
//random string using Genetic Algorithm

//Class representing individual in population
class Individual
{
	private Vector<String> chromosome;
	private int fitness;
	//private static String[] array = {"i","love","GeeksforGeeks"};
	//private static Vector<String> TARGETSTR = new Vector<String>(Arrays.asList(array));
	private static Vector<String> TARGETSTR;
	//private static String TARGET = "I love GeeksforGeeks";
	
	//Valid Genes
	//private static String GENES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890, .-;:<>_!'\"#%&/()=?@${[]}";
	//private static String GENES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		
	Individual(){TARGETSTR = Initialization.TARGETSTR;}
	
	static Individual getIndividual(Vector<String> child_chromosome)
	{
		Individual i = new Individual();
		i.chromosome = child_chromosome;
		i.fitness = cal_fitness(i.chromosome);
		return i;		
	}

	public int getfitness()
	{
		return fitness;
	}
	public Vector<String> getchromosome()
	{
		return chromosome;
	}
	//Perform mating and produce new offspring
	static Individual mate(Individual par1,Individual par2)
	{
		// chromosome for offspring
		Vector<String> child_chromosome_vector = new Vector<String>();

		int n = par1.chromosome.size();
		
		
		for(int j = 0;j<n;j++)
		{
			String child_chromosome = "";
			
			if(par1.chromosome.get(j).equals(TARGETSTR.get(j)))
				child_chromosome = par1.chromosome.get(j);
			
			else if(par2.chromosome.get(j).equals(TARGETSTR.get(j)))
				child_chromosome = par2.chromosome.get(j);
			
			else
			{
				int len = par1.chromosome.get(j).length();				
				
				for(int i = 0;i<len;i++)
				{
					if(par1.chromosome.get(j).charAt(i) == TARGETSTR.get(j).charAt(i))
						child_chromosome += par1.chromosome.get(j).charAt(i);
					
					else if(par2.chromosome.get(j).charAt(i) == TARGETSTR.get(j).charAt(i))
						child_chromosome += par2.chromosome.get(j).charAt(i);
					
					else
					{
						// random probability 
						Random r = new Random();
						int rint = r.nextInt(101);
						float p = (float)rint/(float)100;
						
						// if prob is less than 0.45, insert gene
						// from parent 1 
						if(p < 0.45)
							child_chromosome += par1.chromosome.get(j).charAt(i);
		
						// if prob is between 0.45 and 0.90, insert
						// gene from parent 2
						else if(p < 0.90)
						//else
							child_chromosome += par2.chromosome.get(j).charAt(i);
		
						// otherwise insert random gene(mutate), 
						// for maintaining diversity
						else
							child_chromosome += mutated_genes(j);
					}
				}
			}
			
			child_chromosome_vector.addElement(child_chromosome);
		}
		

		// create new Individual(offspring) using 
		// generated chromosome for offspring
		return getIndividual(child_chromosome_vector);
	};


	//Calculate fittness score, it is the number of
	//characters in string which differ from target
	//string.
	static int cal_fitness(Vector<String> chromosome)
	{
		//System.out.println(TARGETSTR);
		
		int n = TARGETSTR.size();
		
		int fitness = 0;
		for(int j=0;j<n;j++)
		{
			int len = TARGETSTR.get(j).length();
			
			for(int i = 0;i<len;i++)
			{
				if(chromosome.get(j).charAt(i) != TARGETSTR.get(j).charAt(i))
					fitness++;
			}
		}
		
		return fitness; 
	};

	//Create random genes for mutation
	static char mutated_genes(int index)
	{
		String GENES;
		
		Vector<Integer> patternstatus = Initialization.patternstatus;
		if(patternstatus.get(index) == 1)
			GENES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		else
			GENES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890, .-;:<>_!'\"#%&/()=?@${[]}";
		
		int len = GENES.length();
		Random rm = new Random();
		
		int r = rm.nextInt(len);
		return GENES.charAt(r);
	}
	/*
	static char mutated_genes(int index)
	{
		Vector<MNode> mnode_Rest = Initialization.mnode_Rest;
		
		MNode mnode = mnode_Rest.get(index);
		
		String pattern;
		if(mnode.getRestriction().getPattern()!=null && !mnode.getRestriction().getPattern().isEmpty())
		{
			pattern = (String)mnode.getRestriction().getPattern().get(0);						
		}
		else
			pattern = "[a-z0-9A-Z`~!@#$%^&*()_{}-+=:;\"'<,>.?/a-z0-9A-Z`~!@#$%^&*()_{}-+=:;\\\"'<,>.?/a-z0-9A-Z`~!@#$%^&*()_{}-+=:;\\\"'<,>.?/]";
		
		int len = TARGETSTR.get(index).length();
		
		pattern += "{"+len+"}";
	
		Generex generex = new Generex(pattern);
		String randomStr = generex.random();
		
		Random rm = new Random();
		
		len = randomStr.length();
		int r = rm.nextInt(len);
		
		return randomStr.charAt(r);
	}
*/
	//create chromosome or string of genes
	Vector<String> create_gnome(int i)
	{
		/*int n = TARGETSTR.size();
		Vector<String> gnomearray = new Vector<String>();
		for(int j=0;j<n;j++)
		{
			int len = TARGETSTR.get(j).length();
			String gnome = "";
			for(int i = 0;i<len;i++)
				gnome += mutated_genes();
			gnomearray.addElement(gnome);
		}*/
		//System.out.println(i);
		Vector<String> gnomearray = Initialization.genetic_input.get(i);
		return gnomearray;
	}

}


