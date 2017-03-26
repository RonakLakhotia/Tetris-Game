package com.cs3243.tetris.metaheuristics;

import java.util.List;
import java.util.Random;

import com.cs3243.tetris.cluster.Cluster;
import com.cs3243.tetris.heuristics.Heuristic;

public abstract class Metaheuristic {
	protected Random rand = new Random();
	protected Cluster cluster = null;

	public enum MetaheuristicTypes {
		GENETIC, PSO
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public Cluster getCluster() {
		return cluster;
	}

	abstract public void createNextGen();

	abstract public void immmigrate(List<Heuristic> newHeuristics);
}
