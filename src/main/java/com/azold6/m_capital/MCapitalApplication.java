package com.azold6.m_capital;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.domain.GraphShortestUtil;
import com.azold6.m_capital.domain.NodeShortestUtil;
import com.azold6.m_capital.domain.Route;
import com.azold6.m_capital.repositories.GraphRepository;
import com.azold6.m_capital.repositories.PathRepository;
import com.azold6.m_capital.services.GraphUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MCapitalApplication implements CommandLineRunner {

	private GraphUtilService graphUtilService;
	private GraphRepository graphRepository;
	private PathRepository pathRepository;

	@Autowired
	public MCapitalApplication(GraphUtilService graphUtilService, GraphRepository graphRepository, PathRepository pathRepository){
		this.graphUtilService = graphUtilService;
		this.graphRepository = graphRepository;
		this.pathRepository = pathRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MCapitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		NodeShortestUtil nodeA = new NodeShortestUtil("A");
		NodeShortestUtil nodeB = new NodeShortestUtil("B");
		NodeShortestUtil nodeC = new NodeShortestUtil("C");
		NodeShortestUtil nodeD = new NodeShortestUtil("D");
		NodeShortestUtil nodeE = new NodeShortestUtil("E");
		NodeShortestUtil nodeF = new NodeShortestUtil("F");

		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);
		nodeB.addDestination(nodeD, 12);
		nodeB.addDestination(nodeE, 15);
		nodeC.addDestination(nodeF, 10);
		nodeD.addDestination(nodeF, 2);
		nodeD.addDestination(nodeE, 1);
		nodeE.addDestination(nodeF, 5);

		Route route1 = new Route("A", "B", 10);
		Route route2 = new Route("A", "C", 15);
		Route route3 = new Route("B", "D", 12);
		Route route4 = new Route("B", "E", 15);
		Route route5 = new Route("C", "F", 10);
		Route route6 = new Route("D", "F", 2);
		Route route7 = new Route("D", "E", 1);
		Route route8 = new Route("E", "F", 1);

		List<Route> routeList = Arrays.asList(route1, route2, route3, route4,
                route5, route6, route7, route8);

		Graph graph = new Graph(routeList);
		routeList.forEach(x -> x.setGraph(graph));

		GraphShortestUtil graphShortestUtil = new GraphShortestUtil();

		graphShortestUtil.addNode(nodeA);
		graphShortestUtil.addNode(nodeB);
		graphShortestUtil.addNode(nodeC);
		graphShortestUtil.addNode(nodeD);
		graphShortestUtil.addNode(nodeF);
		graphShortestUtil.addNode(nodeE);

		graphShortestUtil = graphUtilService.calculateShortestPathFromSource(graphShortestUtil, nodeA);

//		System.out.println("Menores distâncias a partir do node A:");
//		graphShortestUtil.getNodes().forEach(x -> {
//			String distancia;
//
//			if(x.getShortestPath().isEmpty())
//				return;
//			else
//				distancia = String.valueOf(x.getDistance());
//
//			System.out.print("A até " + x.getName() + ": ");
//			System.out.print(distancia + ", caminho: ");
//			x.getShortestPath().forEach(nodeShortestUtil -> System.out.print(nodeShortestUtil.getName()));
//			System.out.println(x.getName());
//		});

		graphRepository.save(graph);
		pathRepository.saveAll(Arrays.asList(route1, route2, route3, route4,
                route5, route6, route7, route8));

	} //RUN
} //CLASS
