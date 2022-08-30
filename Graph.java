public class Graph {
    public static void main(String[] args) {
        
    }
    public static void Intro_graph(){
      
        
        public class Main {
          static class Edge {
            int src;
            int nbr;
            int wt;
        
            Edge(int src, int nbr, int wt) {
              this.src = src;
              this.nbr = nbr;
              this.wt = wt;
            }
          }
          public static void main(String[] args) throws Exception {
            int vertices = 7; //0 1 2 3 4 5 6
            ArrayList[] graph = new ArrayList[7];
        
            //This is as per the diagram (fig-13)
        
            graph[0].add(new Edge(0, 1, 10));
            graph[0].add(new Edge(0, 2, 20));
        
            graph[0].add(new Edge(1, 0, 10));
            graph[0].add(new Edge(1, 2, 30));
            graph[0].add(new Edge(1, 3, 50));
            graph[0].add(new Edge(1, 4, 40));
        
            graph[0].add(new Edge(2, 0, 20));
            graph[0].add(new Edge(2, 1, 30));
            graph[0].add(new Edge(2, 5, 80));
        
            graph[0].add(new Edge(3, 1, 50));
            graph[0].add(new Edge(3, 5, 70));
        
            graph[0].add(new Edge(4, 1, 40));
            graph[0].add(new Edge(4, 2, 80));
            graph[0].add(new Edge(4, 5, 60));
        
            graph[0].add(new Edge(5, 3, 70));
            graph[0].add(new Edge(5, 4, 60));
        
          }
        }
    }
    public static void iscyclicgraph(){
        //Is Graph Cyclic

public class Main {
  static class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    boolean[] visited = new boolean[vtces];
    int[] parent = new int[vtces];
    Arrays.fill(parent, -1); // Initially, all nodes will have parent -1.

    for (int v = 0; v < vtces; v++) {
      if (visited[v] == false) {
        boolean cyclic = IsCyclic(graph, v, visited, parent);
        if (cyclic) {
          System.out.println(true);
          return;
        }
      }
    }

    System.out.println(false);
  }

  public static boolean IsCyclic(ArrayList< Edge>[] graph, int src,
                                 boolean[] visited, int[] parent) {
    ArrayDeque< Integer> queue = new ArrayDeque<>();

    queue.add(src);
    visited[src] = true;

    while (queue.size() > 0) {
      int rem = queue.remove();

      for (Edge e : graph[rem]) {

        if (visited[e.nbr] && parent[rem] != e.nbr) {
          // e.nbr is visited already & it is not the parent of rem.
          // Hence, there exists a cycle
          return true;
        }

        if (!visited[e.nbr]) {
          queue.add(e.nbr);
          visited[e.nbr] = true;
          parent[e.nbr] = rem;
        }
      }
    }

    return false;
  }

}
    }
    public static void biprate(){
        //Is Graph Bipartite

public class Main {
  static class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    HashMap< Integer, Integer> visited = new HashMap<>();
    for (int v = 0; v < vtces; v++) {
      if (!visited.containsKey(v)) {
        boolean bip = IsBipartite(graph, v, visited);
        if (!bip) {
          System.out.println(false);
          return;
        }
      }
    }

    System.out.println(true);
  }

  static class Pair {
    int vtx;
    int level;

    Pair(int vtx, int level) {
      this.vtx = vtx;
      this.level = level;
    }
  }

  public static boolean IsBipartite(ArrayList< Edge>[] graph,
                                    int src, HashMap< Integer, Integer> visited) {
    ArrayDeque< Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(src, 0));
    while (queue.size() > 0) {
      Pair rem = queue.remove();

      if (visited.containsKey(rem.vtx)) {
        if (visited.get(rem.vtx) % 2 != rem.level % 2) {
          return false;
        }
      } else {
        visited.put(rem.vtx, rem.level);
      }

      for (Edge e : graph[rem.vtx]) {
        if (!visited.containsKey(e.nbr)) {
          queue.add(new Pair(e.nbr, rem.level + 1));
        }
      }
    }

    return true;
  }

}
    }
    public static void infection(){
        //Spread of Infection
public class Main {
  static class Edge {
    int src;
    int nbr;

    Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      graph[v1].add(new Edge(v1, v2));
      graph[v2].add(new Edge(v2, v1));
    }

    int src = Integer.parseInt(br.readLine());
    int t = Integer.parseInt(br.readLine());
    int count = 0;

    ArrayDeque queue = new ArrayDeque<>();
    queue.add(new Pair(src, 1));
    int[] visited = new int[vtces];
    while (queue.size() > 0) {
      Pair rem = queue.remove();

      if (visited[rem.v] > 0) {
        continue;
      }
      visited[rem.v] = rem.time;
      if (rem.time > t) {
        break;
      } else {
        count++;
      }

      for (Edge e : graph[rem.v]) {
        if (visited[e.nbr] == 0) {
          queue.add(new Pair(e.nbr, rem.time + 1));
        }
      }
    }

    System.out.println(count);
  }

  static class Pair {
    int v;
    int time;

    Pair(int v, int time) {
      this.v = v;
      this.time = time;
    }
  }
}
    }
    public static void weight(){
        //Shortest path in weights

public class Main {
  static class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    int src = Integer.parseInt(br.readLine());
    boolean[] visited = new boolean[vtces];

    PriorityQueue< Pair> queue = new PriorityQueue<>();
    queue.add(new Pair(src, src + "", 0));

    while (queue.size() > 0) {
      Pair rem = queue.remove();

      if (visited[rem.v] == true) {
        continue;
      }
      visited[rem.v] = true;
      System.out.println(rem.v + " via " + rem.psf
                         + " @ " + rem.wsf);

      for (Edge e : graph[rem.v]) {
        if (visited[e.nbr] == false) {
          queue.add(new Pair(e.nbr,
                             rem.psf + e.nbr, rem.wsf + e.wt));
        }
      }
    }
  }

  static class Pair implements Comparable< Pair> {
    int v;
    String psf;
    int wsf;

    Pair(int v, String psf, int wsf) {
      this.v = v;
      this.psf = psf;
      this.wsf = wsf;
    }

    public int compareTo(Pair o) {
      return this.wsf - o.wsf;
    }
  }
}
    }
    public static void connected(){
        //IS GRAPH CONNECTED


public class Main {
  static class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList< >();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    ArrayList< ArrayList< Integer>> comps = new ArrayList< >();


    boolean[]visited = new boolean[vtces];
    for (int v = 0; v < vtces; v++) {
      if (visited[v] == false) {
        ArrayList< Integer> comp = new ArrayList< >();
        drawTree(graph, v, comp, visited);
        comps.add(comp);
      }
    }

    System.out.println(comps.size() == 1); //1

  }
  public static void drawTree(ArrayList< Edge>[]graph, int src, ArrayList< Integer> comp, boolean[]visited) {
    visited[src] = true;
    comp.add(src);
    for (Edge e : graph[src]) {
      if (visited[e.nbr] == false) {
        drawTree(graph, e.nbr, comp, visited);
      }
    }
  }

}
    }
    public static void islands(){
        //NUMBER OF ISLANDS
public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int m = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[m][n];

    for (int i = 0; i < arr.length; i++) {
      String parts = br.readLine();
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
      }
    }

    boolean[][]visited = new boolean[arr.length][arr[0].length]; //1
    int count = 0;
    for (int i = 0; i < arr.length; i++) {    //2
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == 0 && visited[i][j] == false) {
          drawTreeforComponent(arr, i, j, visited);
          count++;
        }
      }
    }
    System.out.println(count); //3
  }

  public static void drawTreeforComponent(int[][]arr, int i, int j, boolean[][]visited) {
    if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j] == true) { //4
      return;
    }
    visited[i][j] = true; //5
    drawTreeforComponent(arr, i - 1, j, visited); //6
    drawTreeforComponent(arr, i, j + 1, visited);
    drawTreeforComponent(arr, i, j - 1, visited);
    drawTreeforComponent(arr, i + 1, j, visited);
  }

}
    }
    public static void perfect_friend(){
        //Perfect Friends


public class Main {
  static class Edge {
    int src;
    int nbr;

    Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    int vtces = n;
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList< >();
    }

    int edges = k;
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      graph[v1].add(new Edge(v1, v2));
      graph[v2].add(new Edge(v2, v1));
    }

    boolean[] visited = new boolean[vtces];
    ArrayList< ArrayList< Integer>> comps = new ArrayList< >();
    for (int v = 0; v < vtces; v++) {
      if (visited[v] == false) {
        ArrayList< Integer> comp = new ArrayList< >();
        gcc(graph, v, visited, comp);
        comps.add(comp);
      }
    }

    int count = 0;
    for (int i = 0; i < comps.size(); i++) {
      for (int j = i + 1; j < comps.size(); j++) {
        count += comps.get(i).size() * comps.get(j).size();
      }
    }
    System.out.println(count);
  }

  public static void gcc(ArrayList< Edge>[] graph, int src, boolean[] visited, ArrayList< Integer>
                         comp) {
    comp.add(src);
    visited[src] = true;
    for (Edge e : graph[src]) {
      if (!visited[e.nbr]) {
        gcc(graph, e.nbr, visited, comp);
      }
    }
  }
}
    }
    public static void min_wire(){
        //Min. wire required to connect all pcs


public class Main {
  static class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    int src = 0;
    PriorityQueue< Pair> queue = new PriorityQueue<>();
    queue.add(new Pair(src, -1, 0));
    Integer[] visited = new Integer[vtces];
    while (queue.size() > 0) {
      Pair rem = queue.remove();

      if (visited[rem.v] != null) {
        continue;
      }
      visited[rem.v] = rem.p;
      if (rem.p != -1) {
        System.out.println("[" + rem.v + "-" +
                           rem.p + "@" + rem.wt + "]");
      }

      for (Edge e : graph[rem.v]) {
        if (visited[e.nbr] == null) {
          queue.add(new Pair(e.nbr, rem.v, e.wt));
        }
      }
    }
  }

  static class Pair implements Comparable< Pair> {
    Integer v;
    Integer p;
    int wt;

    Pair(Integer v, Integer p, int wt) {
      this.v = v;
      this.p = p;
      this.wt = wt;
    }

    public int compareTo(Pair o) {
      return this.wt - o.wt;
    }
  }
}
    }
    public static void path_cycle(){
        //Hamiltonian Path and Cycle

public class Main {
  static class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList< >();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    int src = Integer.parseInt(br.readLine());

    HashSet< Integer> visited = new HashSet< >();
    hamiltonianPathAndCycle(graph, src, src, visited, src + "");
  }

  public static void hamiltonianPathAndCycle(ArrayList< Edge>[] graph, int osrc, int src, HashSet< Integer> visited, String psf) {
    if (visited.size() == graph.length - 1) {
      System.out.print(psf);

      boolean closingEdge = false;
      for (Edge e : graph[osrc]) {
        if (e.nbr == src) {
          closingEdge = true;
          break;
        }
      }

      if (closingEdge) {
        System.out.println("*");
      } else {
        System.out.println(".");
      }
      return;
    }

    visited.add(src);
    for (Edge e : graph[src]) {
      if (!visited.contains(e.nbr)) {
        hamiltonianPathAndCycle(graph, osrc, e.nbr, visited, psf + e.nbr);
      }
    }
    visited.remove(src);
  }
}
    }
    public static void Compilation(){
        //Order of Compilation

public class Main {
  static class Edge {
    int src;
    int nbr;

    Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      graph[v1].add(new Edge(v1, v2));
    }

    boolean[] visited = new boolean[vtces];
    Stack< Integer> st = new Stack<>();
    for (int v = 0; v < vtces; v++) {
      if (visited[v] == false) {
        topological(graph, v, visited, st);
      }
    }

    while (st.size() > 0) {
      System.out.println(st.pop());
    }
  }

  public static void topological(ArrayList< Edge>[] graph,
                                 int src, boolean[] visited, Stack< Integer> st) {
    visited[src] = true;
    for (Edge e : graph[src]) {
      if (!visited[e.nbr]) {
        topological(graph, e.nbr, visited, st);
      }
    }
    st.push(src);
  }
}
    }
    public static void dft(){
        //Iterative Depth First Traversal
  

public class Main {
  static class Edge {
    int src;
    int nbr;

    Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      graph[v1].add(new Edge(v1, v2));
      graph[v2].add(new Edge(v2, v1));
    }

    int src = Integer.parseInt(br.readLine());

    Stack< Pair> stack = new Stack<>();
    stack.push(new Pair(src, src + ""));
    boolean[] visited = new boolean[vtces];
    while (stack.size() > 0) {
      Pair rem = stack.pop();

      if (visited[rem.v] == true) {
        continue;
      }
      visited[rem.v] = true;
      System.out.println(rem.v + "@" + rem.psf);

      for (Edge e : graph[rem.v]) {
        if (visited[e.nbr] == false) {
          stack.push(new Pair(e.nbr, rem.psf + e.nbr));
        }
      }
    }
  }

  static class Pair {
    int v;
    String psf;

    Pair(int v, String psf) {
      this.v = v;
      this.psf = psf;
    }
  }
}
    }
    public static void Knights_Tour(){
        //Knights Tour
    

public class Main {

  public static void main(String[] args) throws Exception {

  }

  public static void printKnightsTour(int[][] chess, int r, int c, int move) {

    //Code based on High Level Thinking

    chess[r][c] = move; //Fill the chess[r][c] will the move number

    //Apply recursive calls on the basis of faith
    printKnightsTour(chess, r - 2, c + 1, move + 1);
    printKnightsTour(chess, r - 1, c + 2, move + 1);
    printKnightsTour(chess, r + 1, c + 2, move + 1);
    printKnightsTour(chess, r + 2, c + 1, move + 1);
    printKnightsTour(chess, r + 2, c - 1, move + 1);
    printKnightsTour(chess, r + 1, c - 2, move + 1);
    printKnightsTour(chess, r - 1, c - 2, move + 1);
    printKnightsTour(chess, r - 2, c - 1, move + 1);

    //Follow the Backtracking principle
    chess[r][c] = 0;
  }

  public static void displayBoard(int[][] chess) {
    for (int i = 0; i < chess.length; i++) {
      for (int j = 0; j < chess[0].length; j++) {
        System.out.print(chess[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println();
  }
}
    }
    public static void bft(){
        //Breadth First Traversal
public class Main {
  static class Edge {
    int src;
    int nbr;

    Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList< >();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      graph[v1].add(new Edge(v1, v2));
      graph[v2].add(new Edge(v2, v1));
    }

    int src = Integer.parseInt(br.readLine());

    ArrayDeque< Pair> queue = new ArrayDeque< >();
    queue.add(new Pair(src, src + ""));
    boolean[] visited = new boolean[vtces];
    while (queue.size() > 0) {
      Pair rem = queue.remove();

      if (visited[rem.v] == true) {
        continue;
      }
      visited[rem.v] = true;
      System.out.println(rem.v + "@" + rem.psf);

      for (Edge e : graph[rem.v]) {
        if (visited[e.nbr] == false) {
          queue.add(new Pair(e.nbr, rem.psf + e.nbr));
        }
      }
    }
  }

  static class Pair {
    int v;
    String psf;

    Pair(int v, String psf) {
      this.v = v;
      this.psf = psf;
    }
  }
}
    }
    public static void all_path(){
        //Print All Path
        
        
        public class Main {
          static class Edge {
            int src;
            int nbr;
            int wt;
        
            Edge(int src, int nbr, int wt) {
              this.src = src;
              this.nbr = nbr;
              this.wt = wt;
            }
          }
        
          public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
            int vtces = Integer.parseInt(br.readLine());
            ArrayList< Edge>[] graph = new ArrayList[vtces];
            for (int i = 0; i < vtces; i++) {
              graph[i] = new ArrayList<>();
            }
        
            int edges = Integer.parseInt(br.readLine());
            for (int i = 0; i < edges; i++) {
              String[] parts = br.readLine().split(" ");
              int v1 = Integer.parseInt(parts[0]);
              int v2 = Integer.parseInt(parts[1]);
              int wt = Integer.parseInt(parts[2]);
              graph[v1].add(new Edge(v1, v2, wt));
              graph[v2].add(new Edge(v2, v1, wt));
            }
        
            int src = Integer.parseInt(br.readLine());
            int dest = Integer.parseInt(br.readLine());
        
            boolean[] visited = new boolean[vtces];
            printAllPaths(graph, src, dest, visited, src + "");
          }
        
          public static void printAllPaths(ArrayList< Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
            if (src == dest) {
              System.out.println(psf);
              return;
            }
        
            visited[src] = true;
            for (Edge e : graph[src]) {
              if (!visited[e.nbr]) {
                printAllPaths(graph, e.nbr, dest, visited, psf + e.nbr);
              }
            }
            visited[src] = false;
          }
        
        }
    }
    public static void hash_path(){
        //Has Path
        import java.io.*;

import java.util.*;

public class Main {
  static class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    int src = Integer.parseInt(br.readLine());
    int dest = Integer.parseInt(br.readLine());

    boolean[] visited = new boolean[vtces];
    boolean flag = hasPath(graph, src, dest, visited);
    System.out.println(flag);
  }

  public static boolean hasPath(ArrayList< Edge>[] graph, int src, int dest, boolean[] visited) {
    if (src == dest)
      return true;

    visited[src] = true;
    for (Edge e : graph[src]) {
      if (!visited[e.nbr]) {
        boolean nbrHasPath = hasPath(graph, e.nbr, dest, visited);
        if (nbrHasPath)
          return true;
      }
    }
    return false;
  }

}
    }
    
    public static void multisolver(){
        //Multisolver
  
public class Main {
  static class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  static class Pair implements Comparable< Pair> {
    int wsf;
    String psf;

    Pair(int wsf, String psf) {
      this.wsf = wsf;
      this.psf = psf;
    }

    public int compareTo(Pair o) {
      return this.wsf - o.wsf;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    int src = Integer.parseInt(br.readLine());
    int dest = Integer.parseInt(br.readLine());

    int criteria = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    boolean[] visited = new boolean[vtces];
    multisolver(graph, src, dest, visited, criteria, k, src + "", 0);

    System.out.println("Smallest Path = " + spath + "@" + spathwt);
    System.out.println("Largest Path = " + lpath + "@" + lpathwt);
    System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
    System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
    System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
  }



  static String spath;  //spath=smallest path weight
  static Integer spathwt = Integer.MAX_VALUE; //spathwt= smallest path weight
  static String lpath;  //lpath= largest path
  static Integer lpathwt = Integer.MIN_VALUE; //lpathwt=largest path weight
  static String cpath;  //cpath=ceil path
  static Integer cpathwt = Integer.MAX_VALUE; //cpathwt=ceil path weight
  static String fpath; //fpath=floor path
  static Integer fpathwt = Integer.MIN_VALUE; //fpathwt= floor path weight
  static PriorityQueue< Pair> pq = new PriorityQueue<>();
  public static void multisolver(ArrayList< Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {

    if (src == dest) {
      if (wsf < spathwt) {
        spathwt = wsf;
        spath = psf;
      }
      if (wsf > lpathwt) {
        lpathwt = wsf;
        lpath = psf;
      }
      if (wsf > criteria && wsf < cpathwt) {
        cpathwt = wsf;
        cpath = psf;
      }
      if (wsf < criteria && wsf > fpathwt) {
        fpathwt = wsf;
        fpath = psf;
      }
      if (pq.size() < k) {
        pq.add(new Pair(wsf, psf));
      } else {
        if (wsf > pq.peek().wsf) {
          pq.remove();
          pq.add(new Pair(wsf, psf));
        }
      }
      return;
    }

    visited[src] = true;
    for (Edge edge : graph[src]) {
      if (visited[edge.nbr] == false) {
        multisolver(graph, edge.nbr, dest, visited, criteria, k, psf + edge.nbr, wsf + edge.wt);
      }
    }
    visited[src] = false;
  }
}
    }
    //end
    public static void connected_comp(){
        //Get Connected Components
        import java.io.*;

import java.util.*;

public class Main {
  static class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList< >();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    int src = Integer.parseInt(br.readLine());
    int dest = Integer.parseInt(br.readLine());

    boolean[] visited = new boolean[vtces];
    printAllPaths(graph, src, dest, visited, src + "");
  }

  public static void printAllPaths(ArrayList< Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
    if (src == dest) {
      System.out.println(psf);
      return;
    }

    visited[src] = true;
    for (Edge e : graph[src]) {
      if (!visited[e.nbr]) {
        printAllPaths(graph, e.nbr, dest, visited, psf + e.nbr);
      }
    }
    visited[src] = false;
  }

} import java.io.*;
import java.util.*;

public class Main {
  static class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList< Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList< >();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    ArrayList< ArrayList< Integer>> comps = new ArrayList< >();

    // write your code here

    boolean[] visited = new boolean[vtces];

    for (int i = 0; i < vtces; i++) {

      if (visited[i] == false) {

        ArrayList< Integer> comp = new ArrayList< >();
        dfs(graph, i, visited, comp);
        comps.add(comp);
      }
    }

    System.out.println(comps);
  }

  public static void dfs(ArrayList< Edge>[] graph, int src, boolean[] visited, ArrayList< Integer> comp) {

    visited[src] = true;
    comp.add(src);

    for (Edge e : graph[src]) {

      if (visited[e.nbr] == false) {

        dfs(graph, e.nbr, visited, comp);
      }
    }
  }
}
    }
}
