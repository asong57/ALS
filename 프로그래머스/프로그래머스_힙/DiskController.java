import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {
    class Job{
        int reqTime;
        int runTime;

        public Job(int req, int run){
            this.reqTime = req;
            this.runTime = run;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Job> q = new PriorityQueue(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.reqTime - o2.reqTime;
            }
        });

        for(int[] job:jobs){
            q.add(new Job(job[0],job[1]));
        }

        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.runTime - o2.runTime;
            }
        });

        int count = 0;
        int sum = 0;
        int time = 0;

        while(count<jobs.length){
            while(!q.isEmpty() && time >= q.peek().reqTime){
                pq.offer(q.poll());
            }
            if(!pq.isEmpty()){
                Job j = pq.poll();
                sum += j.runTime + (time - j.reqTime);
                time += j.runTime;
                count++;
            }else{
                time++;
            }
        }
        answer = sum/count;
        return answer;
    }
}
