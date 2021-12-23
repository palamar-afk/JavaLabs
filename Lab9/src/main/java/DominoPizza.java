import Entities.Menu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class DominoPizza implements Restoraunt{
    @Override
    public void InsertItem(Menu entity) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Menu> SelectItems(Function<Session, Query> getQuery) {
        Session session = SessionUtil.getSession();
        Query query = getQuery.apply(session);

        List<Menu> menus = query.list();
        session.close();
        return menus;
    }

    @Override
    public List<Menu> SelectItems(Function<Session, Query> getQuery, HashMap<String, Object> params) {
        Session session = SessionUtil.getSession();
        Query query = getQuery.apply(session);
        AddQueryParameters(query, params);

        List<Menu> menus = query.list();
        session.close();
        return menus;
    }

    private void AddQueryParameters(Query query, Map<String, Object> params){
        for (String key : params.keySet()){
            query.setParameter(key, params.get(key));
        }
    }
}
