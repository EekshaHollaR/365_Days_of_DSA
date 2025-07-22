// import java.util.Scanner;
// class Day01_9_Divisors{
//     static int Divisors(int num){
//         int count=0;
//         for(int i=1;i<=num;i++){
//             if(num%i==0){
//                 count+=1;
//             }
//         }
//         return count;
//     }
//     static int countOfNumbers(int n){
//         int count=0;
//         for(int i=1;i<=n;i++){
//             if(Divisors(i)==9){
//                 count+=1;
//             }
//         }
//         return count;
//     }
//     public static void main(String[] args){
//         System.out.println("Enter a Number");
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         System.out.println(countOfNumbers(n));
//     }
// }

// The above method is a Naive method of complexity o(n^2)


/*  Better approach

 To get the total number of factors we can --> Find the prime factors of a number 
 --> later the exponents of the prime numbers should be added with 1 and later multiply all to get the total factors


 -->If N is the number let p , q , r be the prime numbers  if is composed of 
 -->Let N=p^2 * q^3 * r*1 --> so number of factors= (2+1)*(3+1)*(1+1)=24 factors

 Now to get 9 as number of factors/divisors either exponent should be 8 (as 8+1=9) or 
 Or of the form (2+1)*(2+1)=9 ie. p^2 * q^2

This method is called the Sieve technique

*/

/*Method
 * Find prime till number N given
 * Find all the p,q pairs and calculate (p*q)^2<=N
 * also check for p^8<=N
 */


class Day01_9_Divisors{
    public static int countNumber(int n){
        int count=0;
        int limit=(int)Math.sqrt(n);

        int[] prime=new int[limit+1];
        for(int i=1;i<=limit;i++){
            prime[i]=i;
        }

        for(int i=2;i*i<=limit;i++){
            if(prime[i]==i){
                for(int j=i*i;j<=limit;j+=i){
                    if(prime[j]==j){
                        prime[j]=i;
                    }
                }
            }
        }
        for(int i=2;i<=limit;i++){
            int p=prime[i];
            int q=prime[i/prime[i]];
            if (p*q==i && q!=1 && p!=q){
                count+=1;
            }
            else if (prime[i]==1 && Math.pow(i,8)<=n){
                count+=1;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int n=100;
        System.out.println(countNumber(n));
    }
}