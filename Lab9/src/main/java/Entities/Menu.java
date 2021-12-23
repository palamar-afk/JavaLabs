package Entities;

import javax.persistence.*;

@Entity
@Table(name = "rest_menu", schema = "restoran_menu")
public class Menu
{
    @Id
    @Column(name = "id")
    private int _id;

    @Basic
    @Column(name = "dish_name")
    private String _dish_name;

    @Basic
    @Column(name = "price")
    private double _price;

    @Basic
    @Column(name = "weight")
    private double _weight;

    @Basic
    @Column(name = "is_discount")
    private Boolean _is_discount;

    public int GetIdOfDish()
    {
        return _id;
    }

    public void SetIdOfDish(int id)
    {
        _id = id;
    }

    public String GetNameOfDish()
    {
        return _dish_name;
    }

    public void SetNameOfDish(String nameOfDish)
    {
        _dish_name = nameOfDish;
    }

    public double GetPriceOfDish()
    {
        return _price;
    }

    public void SetPriceOfDish(double price)
    {
        _price = price;
    }

    public double GetWeightOfDish()
    {
        return _weight;
    }

    public void SetWeightOfDish(double weight)
    {
        _weight = weight;
    }

    public Boolean GetDiscountForDish()
    {
        return _is_discount;
    }

    public void SetDiscountForDish(Boolean discount)
    {
        _is_discount = discount;
    }
}

