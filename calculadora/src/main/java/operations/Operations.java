
package operations;

public class Operations {
    
    private float number1;
    private float number2;
    private String sign;
    
    public Operations(){}

    public Operations(float number1, float number2, String sign) {
        this.number1 = number1;
        this.number2 = number2;
        this.sign = sign;
    }


    
    public float getNumber1() {
        return number1;
    }

    public void setNumber1(float number1) {
        this.number1 = number1;
    }

    public float getNumber2() {
        return number2;
    }

    public void setNumber2(float number2) {
        this.number2 = number2;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    @Override
    public String toString() {
        return "Operations{" + "number1=" + number1 + ", number2=" + number2 + ", sign=" + sign + '}';
    }
}