class tuple{
    int first;int second;int third;
    public  tuple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        PriorityQueue<tuple> q=new PriorityQueue<tuple>((x,y) -> x.first-y.first);
        int[][] dist=new int[n][n];
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
               return -1;
        }
        if (n == 1) return 1;
                                             
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=1;
        q.add(new tuple (1,0,0));
        int[] detrow = {-1,-1,-1,0,0,1,1,1};
        int[] detcol = {-1,0,1,-1,1,-1,0,1};
        while(!q.isEmpty()){
            tuple node=q.poll();
            int dis=node.first;
            int row=node.second;
            int col=node.third;
            for(int i=0;i<8;i++){
                int newr=row+detrow[i];
                int newc=col+detcol[i];
                if(newr>=0 && newc>=0 && newr<n && newc<n && grid[newr][newc]==0 && dis+1<dist[newr][newc]){
                    dist[newr][newc]=dis+1;
                    if(newr==n-1 && newc==n-1) return dis+1;
                    q.add(new tuple(dis+1,newr,newc));
                }
            }
        }
        return -1;
    }
}