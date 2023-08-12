package br.udemy.andre.foo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.udemy.andre.exceptions.UnsupportedException;
import br.udemy.andre.Converter.converter;

@RestController
public class MathController {


    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable String numberOne,
            @PathVariable String numberTwo)
            throws Exception {
        if (!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
            throw new UnsupportedException("Invalid number, please set a numeric value.");
        }

        Double sum = converter.convertToDouble(numberOne) + converter.convertToDouble(numberTwo);
        return sum;
    }
    

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable String numberOne,
            @PathVariable String numberTwo)
            throws Exception {
        if (!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
            throw new UnsupportedException("Invalid number, please set a numeric value.");
        }
        Double sub = converter.convertToDouble(numberOne) - converter.convertToDouble(numberTwo);
            return sub;
        }

        @GetMapping("/mul/{numberOne}/{numberTwo}")
        public Double mul(
                @PathVariable String numberOne,
                @PathVariable String numberTwo)
                throws Exception {
            if (!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
                throw new UnsupportedException("Invalid number, please set a numeric value.");
            }
            Double mul = converter.convertToDouble(numberOne) * converter.convertToDouble(numberTwo);
                return mul;
                }
        
        @GetMapping("/div/{numberOne}/{numberTwo}")
        public Double div(
                @PathVariable String numberOne,
                @PathVariable String numberTwo)
                throws Exception {
                if (!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
                    throw new UnsupportedException("Invalid number, please set a numeric value.");
                }
                Double div = converter.convertToDouble(numberOne) / converter.convertToDouble(numberTwo);
                    return div;
                }
        
        @GetMapping("/avg/{numberOne}/{numberTwo}")
        public Double avg(
                @PathVariable String numberOne,
                @PathVariable String numberTwo)
                throws Exception {
                if (!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
                    throw new UnsupportedException("Invalid number, please set a numeric value.");
                }
                Double avg = (converter.convertToDouble(numberOne) + converter.convertToDouble(numberTwo)) / 2;
                    return avg;
                }
        
        @GetMapping("/sqr/{numberOne}")
        public Double sqr(
                @PathVariable String numberOne)
                throws Exception {
                if (!converter.isNumeric(numberOne)) {
                    throw new UnsupportedException("Invalid number, please set a numeric value.");
                }
                Double sqr = Math.pow(converter.convertToDouble(numberOne), 2);
                    return sqr;
                }

        
        




}
            