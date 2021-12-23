import Entities.Menu;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public interface Restoraunt
{
        void InsertItem(Menu entity);
        List<Menu> SelectItems(Function<Session, Query> getQuery);
        List<Menu> SelectItems(Function<Session, Query> getQuery, HashMap<String, Object> params);
}
