import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Recipes> recipes = new ArrayList<>();

        System.out.println("Name of the file:");
        String file = scanner.nextLine();

        
        
        try(Scanner getfile = new Scanner(Paths.get(file))){
            while (getfile.hasNextLine()){
                String name  = getfile.nextLine();
                ArrayList ingredients = new ArrayList();
                if(name.isEmpty()){
                    continue;
                }
                int duration = Integer.valueOf(getfile.nextLine());
                while(getfile.hasNextLine()){
                    String line = getfile.nextLine();
                    ingredients.add(line);
                    if(line.isEmpty()){
                        break;
                    }
                }
                recipes.add(new Recipes(name,duration,ingredients));
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        // implement reading the file here.
        System.out.println();

        System.out.println("Commands: ");
        System.out.println("list - lists the recipes");
        System.out.println("stop-stops the program");
        System.out.println();
        while(true){
            System.out.println("Enter command: ");
            String command = scanner.nextLine();
            
            if(command.equals("stop")){
                break;
            }
            
            if(command.equals("list")){
                System.out.println();
                System.out.println("Recipes:");
                for(Recipes recipe:recipes){
                    System.out.println(recipe);
                }
                System.out.println();
            }
            if(command.equals("find name")){
                System.out.println("Searched word:");
                String word = scanner.nextLine();
                for(Recipes recipe: recipes){
                    if(recipe.getName().contains(word)){
                        System.out.println("Recipes:");
                        System.out.println(recipe);
                    }
                }
                System.out.println();
            }
            if(command.equals("find cooking time")){
                System.out.println("Max cooking time:");
                int time = Integer.valueOf(scanner.nextLine());
                for(Recipes recipe: recipes){
                    if(recipe.duration() <= time){
                        System.out.println("Recipes:");
                        System.out.println(recipe);
                    }
                }
                System.out.println();
            }
            if(command.equals("find ingredient")){
                System.out.println("Ingredient:");
                String ingredient = scanner.nextLine();
                for(Recipes recipe: recipes){
                    if(recipe.getIngredients().contains(ingredient)){
                        System.out.println("Recipes:");
                        System.out.println(recipe);
                    }
                }
                System.out.println();
            }

        }
        
        
    }
}
