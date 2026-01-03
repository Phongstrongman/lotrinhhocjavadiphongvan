package com.studeyjava.thucchien.bai1;

public class cho {
    private String ten ;
    private int tuoi ;
    private String giong ;

    public cho( String ten , int tuoi , String giong ){
        this.ten = ten ;
        this.tuoi = tuoi ;
        this.giong = giong ;
    }
    public void  sua(){
    
        System.out.println(ten+"buggy ");}
    
    public void an (){
System.out.println(ten + " dang an");

    }
    public void  hienthi(){


        System.out.println("ten: " + ten);
        System.out.println("tuoi: " + tuoi);
        System.out.println("giong: " + giong);
    }}

//     cho cho1 = new cho("bao", 3, "phoc");

// cho1.hienthi();
// cho1.sua(); 
// cho1.an();