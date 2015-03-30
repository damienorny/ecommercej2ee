/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.HashMap;

/**
 *
 * @author mathieu
 */
public class Cart 
{
    private HashMap<Article,Integer> cart = null;
    
    public Cart()
    {
        this.cart = new HashMap();
    }
    
    public void addItem(Article article, Integer nombre)
    {
        if(cart.containsKey(article))
        {
            cart.replace(article, (cart.get(article)+nombre));
        }
        else
        {
            cart.put(article, nombre);
        }
    }
    
    public void removeItem(Article article)
    {
        cart.remove(article);
    }
    
    public void updateItem(Article article, Integer nombre)
    {
        cart.replace(article, nombre);
    }
    
    public HashMap<Article,Integer> getCart()
    {
        return this.cart;
    }
    
    public Integer getTaillePanier()
    {
        return this.cart.size();
    }
    
    public Boolean contains(Article article)
    {
        return this.cart.containsKey(article);
    }
}
