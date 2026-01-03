package com.studeyjava.thucchien;

public class Hinhtron  extends danhhinh{
 
private double bankinh;
public Hinhtron(double bankinh){
    this.bankinh = bankinh;
}
    @Override
    public double tinhdientich() {
        return Math.PI * bankinh * bankinh;
    }

    @Override
    public double tinhchuvi() {
        return 2 * Math.PI * bankinh;
    }

}
