package br.udemy.andre.Converter;

public class converter {

    public static boolean isNumeric(String str) {
        if (str == null) {return false;}
        String string = str.replaceAll(",", ".");
        return string.matches("-?\\d+(\\.\\d+)?");
     }
 
      public static Double convertToDouble(String str) {
         if (str == null) {return 0D;}
         String string = str.replaceAll(",", ".");
         if (isNumeric(string)) {
             return Double.parseDouble(string);
         }
         return 0D;
     }
    
}
