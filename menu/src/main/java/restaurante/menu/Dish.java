
package restaurante.menu;


public class Dish {
    private String food;
    
    public Dish(){}    

    public Dish(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
    
     @Override
    public String toString() {
        return "Dish("+"food="+food+")";
    }

}

