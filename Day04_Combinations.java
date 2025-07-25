import java.util.*;
public class Day04_Combinations {
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> result=new ArrayList<>();
        backtrack(1,n,k,new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int start, int n, int k , List<Integer> current, List<List<Integer>> result){
        if(current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<=n;i++){
            current.add(i);
            backtrack(i+1,n,k,current,result);
            current.remove(current.size()-1);
        }
    }
    public static void main(String[] args){
        Day04_Combinations sol=new Day04_Combinations();
        int n=4;
        int k=2;
        System.out.println(sol.combine(n,k));
    }
}
