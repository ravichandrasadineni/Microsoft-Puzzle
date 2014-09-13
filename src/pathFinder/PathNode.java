package pathFinder;

import java.util.ArrayList;
import java.util.List;

public class PathNode {
	int x;
	int y;
	char value;
	int currentPosToMatch;
	PathNode parentNode;

	PathNode (int x, int y, char value, int currentPosToMatch, PathNode parentNode) {
		this.x = x;
		this.y = y;
		this.value = value;
		this.currentPosToMatch = currentPosToMatch;
		this.parentNode = parentNode;
	}

	List<PathNode> getNeighbours(char [][] array) {
		List<PathNode>  pathNodes = new ArrayList<PathNode>();
		int rowSize = array.length;
		int columnSize = array[0].length;
		if(x  < rowSize -1) {
			pathNodes.add(new PathNode(x+1, y, array[x+1][y], currentPosToMatch+1, this));
		}
		if(y < columnSize -1) {
			pathNodes.add(new PathNode(x, y+1, array[x][y+1],currentPosToMatch +1, this));
		}

		if(x > 0 ) {
			pathNodes.add(new PathNode(x-1, y, array[x-1][y],currentPosToMatch +1, this));
		}
		if(y > 0) {
			pathNodes.add(new PathNode(x, y-1, array[x][y-1],currentPosToMatch +1, this));
		}

		return pathNodes;
	}

	boolean equals(PathNode node) {
		
		if(x != node.getX()) {
			return false;
		}
		if (y != node.getY()) {
			return false;
		}
		return true;		
	}	

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}

	public int getCurrentPosToMatch() {
		return currentPosToMatch;
	}

	public void setCurrentPosToMatch(int currentPosToMatch) {
		this.currentPosToMatch = currentPosToMatch;
	}

	public PathNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(PathNode parentNode) {
		this.parentNode = parentNode;
	}
	
	

}
