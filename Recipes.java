import java.util.ArrayList;
public class Recipes {
    private String name;
    private int duration;
    private ArrayList<String> ingredients;
    
    
    public Recipes(String name, int duration, ArrayList ingredients){
        this.name = name;
        this.duration = duration;
        this.ingredients = ingredients;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int duration(){
        return this.duration;
    }
    
    public ArrayList getIngredients(){
        return this.ingredients;
    }
    
    @Override
    public String toString(){
        return this.name + ", cooking time: "+ this.duration;
    }
    
}
