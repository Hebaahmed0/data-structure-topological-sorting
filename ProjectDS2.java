package projectds2;
import java.util.*;
public class ProjectDS2 {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        Graph G = new Graph(n);
        int inDee[] = new int[n+1];
        int m = S.nextInt();
        int Start = S.nextInt();
        System.out.println("Enter u and v");
        for (int i = 0; i < m; i++) {
            int u = S.nextInt();
            int v = S.nextInt();
            G.addEdge(u , v );
            inDee[v]++;    }
         Topo T=new Topo();
        int Sort[];
    int Max=T.Max(inDee);
  Sort=T.topological(G.Array, Start);
  for(int i=1;i<Sort.length;i++){
     if(i==1&&inDee[Sort[i]]==Max)
          System.out.println( Sort[i]); 
     else if(inDee[Sort[i]]==Max)
          System.out.println( Sort[i]); }  } }
class Graph {
    int island;
    int Array[][];
    Graph(int island) {
        this.island = island;
        Array = new int[island+1][island+1]; }
    void addEdge(int u, int v) {
        Array[u][v] = 1;
    }}
class Topo {
    Stack stack;
    public Topo() {
        stack = new Stack(); }
    public int[] topological(int adjacency_matrix[][], int source) throws
            NullPointerException {
        int number_of_nodes = adjacency_matrix[source].length - 1;
        int[] topological_sort = new int[number_of_nodes + 1];
        int pos = 1;
        int j;
        int visited[] = new int[number_of_nodes + 1];
        int element = source;
        int i = source;
        visited[source] = 1;
        stack.Push(source);
        while (!stack.isEmpty()) {
            element = stack.Peek();
            while (i <= number_of_nodes) {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 1) {
                    if (stack.Contains(i)) {
                        System.out.println("TOPOLOGICAL SORT NOT POSSIBLE");
                        return null;     } }
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0) {
                    stack.Push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                    continue;  }
                i++;  }
            j = stack.Pop();
            topological_sort[pos++] = j;
            i = ++j;    }
        return topological_sort;  }
    int Max(int X[]){
        int Max=X[0];
        for(int i=0;i<X.length;i++){
            if(X[i]>Max)
                Max=X[i];
        }
        return Max; }}
class Stack{
    int Stack[];
    int top;
    Stack(){
        Stack=new int[6];
                top=-1;
    }
    boolean isEmpty(){
        if(top==-1)
            return true;
        else 
            return false;
    }
    void Push(int X){
        if(top==Stack.length-1)
            return;
        else {
            top++;
            Stack[top]=X;
        }
    }
    int Pop(){
        if(isEmpty())
            return -1;
        else {
            int X=Stack[top];
            top--;
            return X;    }}
    int Peek(){
        if(top<0)
            return 0;
        else {
            int X=Stack[top];
            return X; }  }
    boolean Contains(int i){
        boolean S=false;
        int T;
        for(int j=0;j<Stack.length;j++){
            T=Stack[i];
            if(T==i){
                S=true;
            }
        }
        return S;  }}
