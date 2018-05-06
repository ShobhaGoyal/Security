package GeneticAlgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import TOGeneration.MaliciousGen;

public class GeneticMain {
	
	//Number of individuals in each generation
		private static int POPULATION_SIZE = 300;
		private static int epochs = 1000;
	//Driver code
		public static void main(String args[]) throws TransformerException, ParserConfigurationException, IOException, SAXException
		{
			MaliciousGen mg = new MaliciousGen();
			String filename = "src/maliciousIp.txt";
			mg.generate(filename);
			
			Initialization in = new Initialization();
			File f = new File(filename);
			Scanner sc = new Scanner(f).useDelimiter("\\n");
			
			int msgcnt = 0;
			boolean found = false;
			
			while(true)
			{
				boolean status = in.generateGeneticIp(sc);			
				if(status == false || found==true)
					break;
				
				System.out.println("Input generated");
				// current generation
				int generation = 0;
	
				Vector<Individual> population = new Vector<Individual>();				
	
				// create initial population
				for(int i = 0;i<POPULATION_SIZE;i++)
				{			
					Individual ind = new Individual();
					Vector<String> gnome = ind.create_gnome(i);
					population.addElement(ind.getIndividual(gnome));
				}
				
				System.out.println("Initial population created");
				
				/*for(Individual indi : population)
				{
					System.out.println(indi.getchromosome());
				}
				System.out.println();*/
				while(! found)
				{
					// sort the population in increasing order of fitness score
					//sort(population.begin(), population.end());
			     
					Collections.sort(population,new Comparator<Individual>()
					{
						public int compare(Individual Ind1,Individual Ind2) {
							
							int compareQuantity1 = Ind1.getfitness();	
							int compareQuantity2 = Ind2.getfitness();	
							//ascending order
							return compareQuantity1 - compareQuantity2;
							
						}				
					});
					
					/*System.out.println("Iteration\n");
					
					System.out.println("Population");
					for(int l=0;l<population.size();l++)
					{
						System.out.println(population.get(l).getchromosome()+" "+population.get(l).getfitness());
					}*/
					
					
					// if the individual having lowest fitness score ie. 
					// 0 then we know that we have reached to the target
					// and break the loop
					if(generation == epochs)
					{
						System.out.println("Not found");
						break;
					}
					if(population.get(0).getfitness() <= 0)
					{
						System.out.println("System can be attacked");
						found = true;
						break;
					}
	
					// Otherwise generate new offsprings for new generation
					Vector<Individual> new_generation = new Vector<Individual>();
	
					// Perform Elitism, that mean 10% of fittest population
					// goes to the next generation
					int s = (10*POPULATION_SIZE)/100;
	
					for(int i = 0;i<s;i++)
						new_generation.add(population.get(i));
					
					// From 50% of fittest population, Individuals
					// will mate to produce offspring
					s = (90*POPULATION_SIZE)/100;
					
					for(int i = 0;i<s;i++)
					{
						int len = population.size();
						Random r = new Random();
						int random_int = r.nextInt(POPULATION_SIZE);				
						Individual parent1 = population.get(random_int);
						random_int = r.nextInt(POPULATION_SIZE);
						Individual parent2 = population.get(random_int);
						//System.out.println("before mating");
						Individual offspring = Individual.mate(parent1,parent2);
						//System.out.println("after mating");
						new_generation.add(offspring); 
					}
					
								
					Collections.sort(new_generation,new Comparator<Individual>()
					{
						public int compare(Individual Ind1,Individual Ind2) {
							
							int compareQuantity1 = ((Individual) Ind1).getfitness();	
							int compareQuantity2 = ((Individual) Ind2).getfitness();	
							//ascending order
							return compareQuantity1 - compareQuantity2;
							
						}				
					});
					
					/*System.out.println("\nNew generation");
					for(int l=0;l<new_generation.size();l++)
					{
						System.out.println(new_generation.get(l).getchromosome()+" "+new_generation.get(l).getfitness());
					}	*/	
					
					population = new Vector<Individual>(new_generation);			
					
					System.out.print("Generation: ");
					System.out.print(generation);
					System.out.println("\t String: "+population.get(0).getchromosome()+"\tFitness: "+population.get(0).getfitness()+"\n");
					
					generation++;
				}
				System.out.print("Generation: ");
				System.out.print(generation);
				System.out.println("\t String: "+population.get(0).getchromosome()+"\tFitness: "+population.get(0).getfitness()+"\n");
				
				if(found == true)
					break;
			}
			
			if(found==false)
				System.out.println("System cannot be attacked");
		}

}
