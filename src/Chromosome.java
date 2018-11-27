import java.util.ArrayList;

public class Chromosome {
    private double score;
    private int[] path;

    public Chromosome(int[] path) {
        this.path = path;
        calcScore();
    }

    public Chromosome() {
        path = new int[24];
        ArrayList<Integer> options = new ArrayList<>();
        for (int i = 0; i < path.length; i++) {
            options.add(i);
        }
        for (int i = 0; i < path.length; i++) {
            path[i] = options.remove((int)(Math.random()*options.size()));
        }
        calcScore();
    }

    private double calcScore() {
        score = 0;
        int xVal = TestCities.getCity(path[0]).getX();
        int yVal = TestCities.getCity(path[0]).getY();
        score += (Math.sqrt(Math.pow(xVal,2)+(Math.pow(yVal,2))));
        for (int i = 1; i < path.length; i++) {
            int xVal1 = TestCities.getCity(path[i-1]).getX();
            int yVal1 = TestCities.getCity(path[i-1]).getY();
            int xVal2 = TestCities.getCity(path[i]).getX();
            int yVal2 = TestCities.getCity(path[i]).getY();
            score += (Math.sqrt((xVal2-xVal1)*(xVal2-xVal1)+(yVal2-yVal1)*(yVal2-yVal1)));
        }
        xVal = TestCities.getCity(path[path.length-1]).getX();
        yVal = TestCities.getCity(path[path.length-1]).getY();
        score += (Math.sqrt((Math.pow(xVal,2)+(Math.pow(yVal,2)))));
        return score;
    }

    public void mutate0(){
        int first = (int)(Math.random()*path.length);
        int second = (int)(Math.random()*path.length);
        int replace = path[second];
        path[second] = path[first];
        path[first] = replace;
        calcScore();
    }

    public Chromosome mutate1(){
        int[] path2 = new int[path.length];
        for (int i = 0; i < path.length; i++) {
            path2[i] = path[i];
        }
        int first = (int)(Math.random()*path.length);
        int second = (int)(Math.random()*path.length);
        path[second] = path2[first];
        path[first] = path2[second];
        return new Chromosome(path2);
    }

    public int[] getPath() {
        return path;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString(){
        String ans = "";
        for (int i = 0; i < path.length; i++) {
            ans += path[i];
        }
        return ans;
    }
}