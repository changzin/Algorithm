import java.util.*;

class Solution {
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public int solution(int[] arrows) {
        int pointsNum = 0;
        int edgesNum = 0;
        
        Set<Point> points = new HashSet<>();
        Set<Edge> edges = new HashSet<>();
        Point prev = new Point(0, 0);
        points.add(prev);
        for (int i = 0; i < arrows.length; i++) {
            for (int j = 0; j < 2; j++) {
                Point present = new Point(prev.x + dx[arrows[i]], prev.y + dy[arrows[i]]);
                points.add(present);
                edges.add(new Edge(prev, present));
                prev = present;
            }
        }
        pointsNum += points.size();

        edgesNum += edges.size();

        return 1 - pointsNum + edgesNum;
    }    
    
    class Edge{
        Point p1;
        Point p2;
        
        public Edge(Point p1, Point p2){
            this.p1 = p1;
            this.p2 = p2;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(p1,p2) + Objects.hash(p2,p1);
        }
        
        @Override
        public boolean equals(Object o){
            if (this==o) return true;
            if (o==null || getClass() != o.getClass()) return false;
            
            Edge s = (Edge) o;
            return (this.p1.equals(s.p1) && this.p2.equals(s.p2)) || (this.p2.equals(s.p1) && this.p1.equals(s.p2));
        }
    }
    
    class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point p = (Point)o;
            
            return this.x == p.x && this.y == p.y;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(x, y);
        }
    }
}