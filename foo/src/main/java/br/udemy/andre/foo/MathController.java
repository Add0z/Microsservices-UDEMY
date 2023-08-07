package br.udemy.andre.foo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.udemy.andre.exception.UnsupportedExcep;

@RestController
public class MathController {

    /**
     * Calculates the sum of two numbers.
     *
     * @param numberOne The first number.
     * @param numberTwo The second number.
     * @return The sum of the two numbers.
     * @throws Exception If either number is invalid.
     */
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedExcep("Invalid number, please set a numeric value.");
        }
        
        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }
    private boolean isNumeric(String str) {
       if (str == null) {return false;}
       String string = str.replaceAll(",", ".");
       return string.matches("-?\\d+(\\.\\d+)?");
    }

     private Double convertToDouble(String str) {
        if (str == null) {return 0D;}
        String string = str.replaceAll(",", ".");
        if (isNumeric(string)) {
            return Double.parseDouble(string);
        }
        return 0D;
    }
}