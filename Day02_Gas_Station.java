// This is a problem based on the Problem Solving 
/* There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. 
You begin the journey with an empty tank at one of the gas stations.*/

public class Day02_Gas_Station{
    public static int canCompleteCircuit(int[] gas, int[] cost){
        int start=0;
        int curr=0;
        int total=0;

        for(int i=0;i<gas.length;i++){
            curr=curr+gas[i]-cost[i];
            total=total+gas[i]-cost[i];
            if(curr<0){
                start=i+1;
                curr=0;
            }
        }
        if(total>=0){
            return start;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args){
        int[] gas= { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println(canCompleteCircuit(gas, cost));
    }
}