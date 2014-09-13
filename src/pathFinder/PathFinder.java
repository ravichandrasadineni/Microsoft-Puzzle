package pathFinder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathFinder {

	PathNode goalNode;
	PathNode initialNode;
	char[][] array;
	char[] input;
	List<PathNode> nodesVisited = new ArrayList<PathNode>();
	Queue<PathNode> fringe = new LinkedList<PathNode>();
	
	public PathFinder(char[][] array, char[]  input) {
		this.array = array;
		this.input = input;
		goalNode = new PathNode(array.length -1, array[0].length -1, input[input.length-1],  input.length-1, null);
		initialNode = new PathNode(0, 0, array[0][0],  0, null);
	}
	
	public char[][] findPath() {
		fringe.add(initialNode);
		while(!fringe.isEmpty()) {
			PathNode currentNode= fringe.poll();
			List<PathNode> neighbours = currentNode.getNeighbours(array);
			for(PathNode node : neighbours) {
				if(isGoalNode(node)) {
					return populateFinalArray(node);
				}
				else if(isNotVisited(node) && isValidNeighbour(node)) {
					fringe.add(node);
				}
				
			}
			nodesVisited.add(currentNode);
		}
		
		return null;
	}
	
	boolean isGoalNode(PathNode node) {
		return goalNode.equals(node);
			
	}
	
	char[][] populateFinalArray(PathNode node) {
		char[][] finalArray = new char[array.length][array[0].length];
		while(node != null) {
			finalArray[node.getX()][node.getY()] = node.getValue();
			node = node.getParentNode();
		}
		return finalArray;
	}
	boolean isNotVisited(PathNode node) {
		for(PathNode visitedNode : nodesVisited ) {
			if(visitedNode.equals(node)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isValidNeighbour(PathNode node) {
		if(node.getValue() == input[node.getCurrentPosToMatch()]) {
			return true;
		}
		return false;
	}
}
