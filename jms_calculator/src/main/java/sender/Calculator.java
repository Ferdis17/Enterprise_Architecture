package sender;


import java.io.Serializable;

public class Calculator implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long firstNumber;
    private Long secondNumber;
    
    public Long getFirstNumber() {
        return firstNumber;
    }

    
    public void setFirstNumber(Long firstNumber) {
        this.firstNumber = firstNumber;
    }

    
    public Long getSecondNumber() {
        return secondNumber;
    }

    
    public void setSecondNumber(Long secondNumber) {
        this.secondNumber = secondNumber;
    }

    
    public Long getPlus() {
        return firstNumber + secondNumber;
    }

    
    public Long getMuliply() {
        return firstNumber * secondNumber ;
    }

    public Calculator(Long firstNumber, Long secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

}

