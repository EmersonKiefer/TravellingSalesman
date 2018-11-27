import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Population {
    private ArrayList<Chromosome> members;
    private int size, generationNum;
    private double globalMin, eletism;

    public Population(int size) {
        members = new ArrayList<>();
        this.size = size;
        generationNum =0;
        globalMin = Integer.MAX_VALUE;
        eletism = .1;
    }

    public void fill(){
        while (members.size()<size*.95){
            members.add(members.get((int)(Math.random()*members.size())).mutate1());
        }
        while (members.size()<size){
            members.add(new Chromosome());
        }
    }

    public void startFill(){
        while (members.size() < size) {
            members.add(new Chromosome());
        }
    }

    public void sort(){
        Collections.sort(members, new Comparator<Chromosome>() {
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                return (int)(o1.getScore()) - (int)(o2.getScore());
            }
        });
    }

    public void kill(){
        int target = (int)(members.size()*eletism);
        while (members.size()>target){
            members.remove(members.size()-1);
        }
    }

    public void calcMin(){
        double min = members.get(0).getScore();
        if (min < globalMin){
            globalMin = min;
        }
    }

    public void display(){
        double sum = 0;
        double min = members.get(0).getScore();
        double max = members.get(members.size()-1).getScore();
        for (int i = 0; i < members.size(); i++) {
            double cost = members.get(i).getScore();
            sum += cost;
        }
        if (min < globalMin){
            globalMin = min;
        }
        System.out.println("Min: " + min + ", Max: " + max + ", Mean: " + sum/members.size());
        System.out.println("Generation " + generationNum);
        System.out.println();;
    }

    public void display2(){
        if (generationNum%1000==0){
            display();
        }
        calcMin();
    }

    public void mutate(){
        for (int i = 1; i < members.size()*eletism; i++) {
            members.get(i).mutate0();
        }
    }

    public void generation(){
        sort();
        display2();
        kill();
        fill();
        //sort();
        mutate();
        //sort();
        generationNum++;
    }

    public void run(int threshold){//threshold is going to be the number of generations you can go without stopping with no improvemtn
        int gensOfNoImprovement=0;//number of generations since improvement
        startFill();
        while (gensOfNoImprovement < threshold){
            double lastMin = globalMin;//last generations max
            generation();
            if (globalMin < lastMin){
                gensOfNoImprovement = 0;
                display();
            }else{
                gensOfNoImprovement++;
            }
        }
        sort();
        System.out.println(members.get(0));
        System.out.println("Score:" + members.get(0).getScore());
    }
}