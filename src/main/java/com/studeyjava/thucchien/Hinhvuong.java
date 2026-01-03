package com.studeyjava.thucchien;

public class Hinhvuong extends danhhinh {
    private double canh;

    public Hinhvuong(double canh) {
        this.canh = canh;
    }

    @Override
    public double tinhdientich() {
        return canh * canh;
    }

    @Override
    public double tinhchuvi() {
        return 4 * canh;
    }
}

// Hinhvuong hv = new Hinhvuong(5);
// System.out.println("Dien tich hinh vuong: " + hv.tinhdientich());
// System.out.println("Chu vi hinh vuong: " + hv.tinhchuvi());

// Hinhtron ht = new Hinhtron(7);
// System.out.println("Dien tich hinh tron: " + ht.tinhdientich());
// System.out.println("Chu vi hinh tron: " + ht.tinhchuvi());
// }