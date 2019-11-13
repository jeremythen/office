package office;

public class Office {
    
	private Tiles[][] tiles;
    
    public Tiles[][] getTiles() {
        return tiles;
    }
  
    public Office(String[][] grid) {
        
        int width = grid[0].length;
        int height = grid.length;
        
        tiles = new Tiles[height][width];
        
        int counter = 0;
        
        Tiles tile = null;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                
                Tiles temp;
                
                if(i == 0 || j == 0 || j == (width) || i == (height)) {
                    temp = new Tiles();
                }else {
                	temp = new Tiles(grid[i][j]);
                	counter++;
                }
                
               if(j != 0) {
            	   temp.setLeft(tile);
            	   tile.setRight(temp);
               }
               
               tile = temp;
               tiles[i][j] = temp;
               
               if(counter > 0) {
                   Tiles upButton = tiles[i - 1][j];
                   tile.setUp(upButton);
                   upButton.setDown(tile);
               }
            }
        }
        
    }
    
    public static class Tiles {
        
        static final int WALL = 0;
        static final int SPACE = 1;
        private static int num = 0;
        private int id = 0;
        private int type;
        private int mark = 0;
        private Tiles u;
        private Tiles r;
        private Tiles d;
        private Tiles l;
        
        private boolean isMarked;
        
        protected Tiles(String t) {
            super();
            if("0".equals(t)) {
                this.type = Tiles.WALL;
            }else{
                this.type = Tiles.SPACE;
            }
            id = num++;
        }
        
        protected Tiles() {
            super();
            this.type = Tiles.WALL;
            id = num++;
        }
        
        protected void setType(int type) {
            this.type = type;
        }
        protected int getType() {
            return this.type;
        }
        
        protected void setUp(Tiles u) {
            this.u = u;
        }
        protected void setRight(Tiles r) {
            this.r = r;
        }
        protected void setDown(Tiles d) {
            this.d = d;
        }
        protected void setLeft(Tiles l) {
            this.l = l;
        }
        
        protected Tiles getUp() {
            return this.u;
        }
        protected Tiles getRight() {
            return this.r;
        }
        protected Tiles getDown() {
            return this.d;
        }
        protected Tiles getLeft() {
            return this.l;
        }
        
        public void setMark(int n) {
            this.mark = n;
        }
        public int getMark() {
            return this.mark;
        }
        
        public void setIsMarked(boolean isMarked) {
        	this.isMarked = isMarked;
        }

		public boolean isMarked() {
			return isMarked;
		}
		
		public String toString() {
			return String.format("{id: %s, type: %s}", id, type);
		}

    }
    
}
