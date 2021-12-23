import Entities.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuService {
    private DominoPizza menu = new DominoPizza();

    public void AddItem(Menu menu)
    {
        this.menu.InsertItem(menu);
    }

    public List<Menu> SelectItemsByWeight()
    {
        List<Menu> items = this.menu.SelectItems(session -> session.createQuery("FROM Menu"));
        List<Menu> resultItems = new ArrayList<>();

        double totalWeight = 0;
        for(int i =0; i<items.size(); i++)
        {
            double currentWeight = items.get(i).GetWeightOfDish();
            if(currentWeight + totalWeight <= 1000)
            {
                resultItems.add(items.get(i));
                totalWeight += currentWeight;
            }
        }
        return resultItems;
    }

    public List<Menu> SelectItemsByPrice(double from, double to){

        HashMap<String, Object> params = new HashMap<>() {{
            put("from", from);
            put("to", to);
        }};

        List<Menu> resultOfQuery = menu.SelectItems(session -> session.createQuery("FROM Menu WHERE _price BETWEEN :from AND :to"), params);

        return resultOfQuery;
    }

    public List<Menu> SelectItemsWithDiscount(){
        return menu.SelectItems(session -> session.createQuery("FROM Menu WHERE _is_discount = true"));
    }
}
