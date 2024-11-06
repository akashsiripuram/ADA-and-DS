
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import javax.swing.JProgressBar;

public class JobClassDriver {
    public static void jobsequencer(List<Job> jobs) {
        Collections.sort(jobs,(a,b)->b.profit-a.profit);
        int n = jobs.size();
        int maxDeadline=-1;
        for(int i=0;i<n;i++){
            maxDeadline=Math.max(maxDeadline,jobs.get(i).deadline);
        }
        char[] result = new char[maxDeadline];
        int[] res=new int[maxDeadline];
        for(int i=0;i<maxDeadline;i++){
            res[i]=-1;
        }
        
    
        for(int i=0;i<n;i++){
            for(int j=jobs.get(i).deadline-1;j>=0;j--){
                if(res[j]==-1){
                    
                    result[j]=jobs.get(i).id;
                    res[j]=0;
                    break;
                }
            }
        }
        for(int i=0;i<maxDeadline;i++){
            System.out.println(result[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of Jobs");
        int n=sc.nextInt();
        System.out.println("Enter Job id, deadline and profits");
        ArrayList<Job> jobs = new ArrayList<Job>();
        for(int i=0;i<n;i++){
            jobs.add(new Job(sc.next().charAt(0),sc.nextInt(),sc.nextInt()));

        }
        jobsequencer(jobs);



    }
}
