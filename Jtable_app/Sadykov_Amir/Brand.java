/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

public class Brand {
    int id;
    String brand;
  static final int count=2;
    
    Brand(int id,String brand)
    {
        this.id=id;
        this.brand=brand;
        
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }
    
}
