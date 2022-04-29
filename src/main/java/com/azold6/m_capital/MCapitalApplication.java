package com.azold6.m_capital;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.domain.Node;
import com.azold6.m_capital.services.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MCapitalApplication implements CommandLineRunner {

	@Autowired
	private GraphService graphService;

	public static void main(String[] args) {
		SpringApplication.run(MCapitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");

		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);

		nodeB.addDestination(nodeD, 12);
		nodeB.addDestination(nodeF, 15);

		nodeC.addDestination(nodeE, 10);

		nodeD.addDestination(nodeE, 2);
		nodeD.addDestination(nodeF, 1);

		nodeF.addDestination(nodeE, 5);

		Graph graph = new Graph();

		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);

		graph = graphService.calculateShortestPathFromSource(graph, nodeA);

		System.out.println("Menores distâncias a partir do node A:");
		graph.getNodes().forEach(x -> {
			String distancia;

			if(x.getShortestPath().isEmpty())
				return;
			else
				distancia = String.valueOf(x.getDistance());

			System.out.print("A até " + x.getName() + ": ");
			System.out.print(distancia + ", caminho: ");
			x.getShortestPath().forEach(node -> System.out.print(node.getName()));
			System.out.println(x.getName());


		});

	} //RUN
} //CLASS
