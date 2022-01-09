package inacio;

public class Calculator {
    //member data (attribute)
    private float result;

    //constructor
    public Calculator() {
        result = 0.0f;
    }

    //functions add, subtract, multiply and divide
    public void add(float value) {
        result += value;
    }

    public void subtract(float value) {
        result -= value;
    }

    public void multiply(float value) {
        result *= value;
    }

    public void divide(float value) {
        if (0.0f == value) {
            result = 0.0f;
        } else {
            result /= value;
        }
    }

    public void reset() {
        result = 0.0f;
    }

    public float getResult() {
        return result;
    }
}
