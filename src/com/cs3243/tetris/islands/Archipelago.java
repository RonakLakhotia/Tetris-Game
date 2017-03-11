package com.cs3243.tetris.islands;

import com.cs3243.tetris.metaheuristics.GeneticAlgo;
import com.cs3243.tetris.metaheuristics.Metaheuristic;

public class Archipelago {
	private Thread c1;
	private Thread c2;
	private Thread c3;
	private Thread c4;
	
	public Archipelago(int totalPopulation){
		int islandPopulation = totalPopulation / 4;
		
		Metaheuristic geneticAlgo = new GeneticAlgo();
		
		c1 = new Thread(new Island(geneticAlgo, "c1", islandPopulation, 30),"t1");
		c2 = new Thread(new Island(geneticAlgo, "c2", islandPopulation, 30),"t2");
		c3 = new Thread(new Island(geneticAlgo, "c3", islandPopulation, 30),"t3");
		c4 = new Thread(new Island(geneticAlgo, "c4", islandPopulation, 30),"t4");
	}

	public void runAlgorithm(){
		c1.start();
		c2.start();
		c3.start();
		c4.start();
	}
	
	public static void main(String[] args){
		Archipelago archipelago = new Archipelago(100);
		archipelago.runAlgorithm();
	}
}
