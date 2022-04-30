package com.azold6.m_capital;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.domain.GraphUtil;
import com.azold6.m_capital.domain.NodeUtil;
import com.azold6.m_capital.domain.Path;
import com.azold6.m_capital.repositories.GraphRepository;
import com.azold6.m_capital.repositories.PathRepository;
import com.azold6.m_capital.services.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MCapitalApplication implements CommandLineRunner {

	private GraphService graphService;
	private GraphRepository graphRepository;
	private PathRepository pathRepository;

	@Autowired
	public MCapitalApplication(GraphService graphService, GraphRepository graphRepository, PathRepository pathRepository){
		this.graphService = graphService;
		this.graphRepository = graphRepository;
		this.pathRepository = pathRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MCapitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		NodeUtil nodeA = new NodeUtil("A");
		NodeUtil nodeB = new NodeUtil("B");
		NodeUtil nodeC = new NodeUtil("C");
		NodeUtil nodeD = new NodeUtil("D");
		NodeUtil nodeE = new NodeUtil("E");
		NodeUtil nodeF = new NodeUtil("F");

		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);
		nodeB.addDestination(nodeD, 12);
		nodeB.addDestination(nodeE, 15);
		nodeC.addDestination(nodeF, 10);
		nodeD.addDestination(nodeF, 2);
		nodeD.addDestination(nodeE, 1);
		nodeE.addDestination(nodeF, 5);

		Path path1 = new Path("A", "B", 10);
		Path path2 = new Path("A", "C", 15);
		Path path3 = new Path("B", "D", 12);
		Path path4 = new Path("B", "E", 15);
		Path path5 = new Path("C", "F", 10);
		Path path6 = new Path("D", "F", 2);
		Path path7 = new Path("D", "E", 1);
		Path path8 = new Path("E", "F", 1);

		List<Path> pathList = Arrays.asList(path1, path2, path3, path4,
											path5, path6, path7, path8);

		Graph graph = new Graph(pathList);
		pathList.forEach(x -> x.setGraph(graph));

		GraphUtil graphUtil = new GraphUtil();

		graphUtil.addNode(nodeA);
		graphUtil.addNode(nodeB);
		graphUtil.addNode(nodeC);
		graphUtil.addNode(nodeD);
		graphUtil.addNode(nodeF);
		graphUtil.addNode(nodeE);

		graphUtil = graphService.calculateShortestPathFromSource(graphUtil, nodeA);

		System.out.println("Menores distâncias a partir do node A:");
		graphUtil.getNodes().forEach(x -> {
			String distancia;

			if(x.getShortestPath().isEmpty())
				return;
			else
				distancia = String.valueOf(x.getDistance());

			System.out.print("A até " + x.getName() + ": ");
			System.out.print(distancia + ", caminho: ");
			x.getShortestPath().forEach(nodeUtil -> System.out.print(nodeUtil.getName()));
			System.out.println(x.getName());
		});

		graphRepository.save(graph);
		pathRepository.saveAll(Arrays.asList(path1, path2, path3, path4,
												path5, path6, path7, path8));

	} //RUN
} //CLASS
