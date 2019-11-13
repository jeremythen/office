package office;

import static office.Office.Tiles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestCountOffice {

	private static  final Set<Tiles> visited = new HashSet<>();
	
	public static void main(String[] args) {
		
		String[][] grid = {
				{"1", "1", "0", "0", "0"},
				{"1", "1", "0", "0", "0"},
				{"0", "0", "1", "0", "0"},
				{"0", "0", "0", "1", "1"},
		};
		
		Office office = new Office(grid);
		
		Tiles[][] tiles = office.getTiles();
		
		int officeCount = countOffice(tiles);
		
		System.out.println("Office Count: " + officeCount);
		
		visited.clear();

	}
	
    public static int countOffice(Tiles[][] tiles) {
    	
    	int officeCount = 0;

        for(int i = 0; i < tiles.length; i++) {
        	for(int j = 0; j < tiles[0].length; j++) {
        		Tiles tile = tiles[i][j];
        		if(!visited.contains(tile) ) {
        			if(!tile.isMarked() && tile.getType() == Tiles.SPACE) {
        				delimitOffice(tile, ++officeCount);
            		}
        		}
            }
        }
        
        return officeCount;
        
    }
    
    private static void delimitOffice(Tiles tile, int officeNumber) {

    	if(tile == null || tile.getType() == Tiles.WALL || visited.contains(tile)) return;
    	
    	visited.add(tile);
    	
    	delimitOffice(tile.getRight(), officeNumber);
    	delimitOffice(tile.getDown(), officeNumber);
    	delimitOffice(tile.getLeft(), officeNumber);
    	delimitOffice(tile.getUp(), officeNumber);
    	
    	tile.setMark(officeNumber);
    	tile.setIsMarked(true);
    	
    }

}
