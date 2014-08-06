package sorcery.util;

public class ComplexNum {
    
    public final double r;
    public final double i;
    
    public ComplexNum(double r, double i) {
        this.r = r;
        this.i = i;
    }
    
    public ComplexNum add(ComplexNum o) {
        return new ComplexNum(r+o.r, i+o.i);
    }
    
    public ComplexNum multiply(ComplexNum o) {
        return new ComplexNum(r*o.r-i*o.i,r*o.i+i*o.r);
    }
}