// Multiplying large numbers using this algorithm 
/*
Let Two Numbers be X and Y
 * Steps for Solving
 * Find Size of Number
 * half of length
 * power => 10 ^ half
 * Find:a,b,c,d
 * a=X/power
 * b=X%power
 * c=Y/power
 * d=Y%power
 * Find:
 * (1) a*c
 * (2) b*d
 * (3) (a+b)*(c+d)
 * (4) Find (3)-(1)-(2)
 * Find the Value of 10
 */

public class Day03_karatsuba{
    public static long solve(long x, long y){
        if (x<=10 || y<=10){
            return x*y;
        }
        long size=Math.max(String.valueOf(x).length(), String.valueOf(y).length());
        long half=size/2;
        long power=(long)Math.pow(10, half);
        long a = x/power;
        long b=x%power;
        long c=y/power;
        long d=y%power;
        long ac=solve(a,c);
        long bd=solve(b,d);
        long abcd=solve(a+b, c+d);
        long combine=abcd-ac-bd;

        return ac*(long)Math.pow(10,2*half)+combine*(long)Math.pow(10,half)+bd;
    }
    public static void main(String[] args) {
     long x=289398;
     long y=801084;
     System.out.println(solve(x,y));

    }
}
