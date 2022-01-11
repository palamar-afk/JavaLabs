import Entities.Menu;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(final String[] args){
        MenuService service = new MenuService();
        int startPrice = 1200, endPrice = 2700;
        GenerateDataForDishes(service,20);

        System.out.print("\nAll dishes with discount:");
        ShowDishesList(service.SelectItemsWithDiscount());
        System.out.print("\nAll dishes from " + startPrice + " to " + endPrice + ":");
        ShowDishesList(service.SelectItemsByPrice(startPrice, endPrice));
        System.out.println("All dishes above 1000 grams:");
        ShowDishesList(service.SelectItemsByWeight());
    }

    private static void GenerateDataForDishes(MenuService service, int count){
        Random random = new Random();
        for (int i = 0; i < count; i++){
            Menu menu = new Menu();
            menu.SetIdOfDish(i);
            menu.SetNameOfDish("The " + i+1 + "th dish is" + random.nextInt(1000, 3000));
            menu.SetPriceOfDish(random.nextDouble(500, 9950));
            menu.SetWeightOfDish(random.nextDouble(0, 1000));
            menu.SetDiscountForDish(random.nextBoolean());
            service.AddItem(menu);
        }
    }

    private static void ShowDishesList(List<Menu> dishes){
        for(Menu menu : dishes){
            System.out.print("#######\t" + menu.GetNameOfDish() + ", Id " + menu.GetIdOfDish() + "\t#######");
            System.out.print("\nWeight:\t" + menu.GetWeightOfDish());
            System.out.print("\nPrice:\t" + menu.GetPriceOfDish());
            System.out.print("\nDiscount:\t" + menu.GetDiscountForDish()+"\n\n");
        }
    }
}