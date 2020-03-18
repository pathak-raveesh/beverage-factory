package com.tavisca.testapp;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<String> inputArray = Arrays.asList("Chai","Chai,-sugar","Mojito","Mojito,-sugar,-soda","",null,"Mojito,-sugar,-soda, -water, -lemon, -mint");
//        List<String> inputArray = Arrays.asList("Mojito,-sugar,-soda, -water, -lemon, -mint");
//        List<String> inputArray = Arrays.asList("Mojito,");
//        List<String> inputArray = Arrays.asList(",");
//        List<String> inputArray = Arrays.asList(",,");
//        List<String> inputArray = Arrays.asList("Mojito,-sugar,-soda, -water, -lemon, -mint","Mojito,-sugar,-soda, -water, -lemon, -mint");
//        List<String> inputArray = Arrays.asList("Mojito,-sugar,null, -water, -lemon, -mint","Mojito,-sugar,-soda, -water, -lemon, -mint");
            for (String input:inputArray) {
                try{//putted try catch block inside for loop- jut to iterate over all the input
                    App app=new App();
                    double calculatedPrice=app.calculatePrice(input);
                    System.out.println("Price for "+input+" is="+calculatedPrice);
                } catch(InvalidInputException e){
                    System.out.println(e.getMessage());
                }
            }
    }

    public double calculatePrice(String input) throws InvalidInputException{
        Map<String,Menu> menuDetails= MenuIngredientUtil.createMenu();
        Map<String,Double> ingredientMap = MenuIngredientUtil.getIngredientData();
        double calculatedPrice=0;
        if(!isNullOrEmptyInput(input)){//if input is not null or empty
            if(input.contains(",")){//when menu name with subtracted ingredient item coming in input
                String[] inputDetails=input.split(",");
                if(inputDetails.length ==0){//It mean it only contains ,
                    throw new InvalidInputException("No Menu Item Found Invalid Input:"+input);
                }else if(inputDetails.length==1){
                    calculatedPrice = getPriceByMenuNameOnly(inputDetails[0],menuDetails);
                }else{
                    calculatedPrice = getPriceByMenuSubtractedIngredient(input,inputDetails,menuDetails,ingredientMap);
                }
            } else{//when there is only menu name coming as input
                calculatedPrice = getPriceByMenuNameOnly(input,menuDetails);
            }
        } else {
            throw new InvalidInputException("Null or Empty input");
        }
        return calculatedPrice;
    }

    public double getPriceByMenuNameOnly(String input,Map<String,Menu> menuDetails) throws InvalidInputException{
        Menu menu=menuDetails.get(input.toLowerCase());
        if(menu==null){
            throw new InvalidInputException("No Menu Item Found Invalid Input:"+input);
        } else{
            return menu.getPrice();
        }
    }

    public double getPriceByMenuSubtractedIngredient(String input, String[] inputDetails, Map<String,Menu> menuDetails, Map<String,Double> ingredientMap) throws InvalidInputException{
        String menuName = inputDetails[0];
        Menu menu=menuDetails.get(menuName.toLowerCase());
        if(menu==null){
            throw new InvalidInputException("No Menu Item Found Invalid Input:"+input);
        }
        List<String> ingredientList = new ArrayList<String>(menu.getIngredients());
        double calculatedPrice = menu.getPrice();
        for(int i=1;i<inputDetails.length;i++){
            String ingredientName = inputDetails[i];
            if( isNullOrEmptyInput(ingredientName) || !ingredientName.trim().startsWith("-")){
                throw new InvalidInputException("Invalid Ingredient "+ ingredientName+" in Input:"+input);
            } else if(!ingredientList.contains(ingredientName.trim().substring(1))){ //checks ingredient is not present or already removed
                throw new InvalidInputException("Ingredient:"+ingredientName+" getting subtracted more than once or not a part of menu");
            } else{
                ingredientName = ingredientName.trim().substring(1);
                calculatedPrice -= ingredientMap.get(ingredientName.toLowerCase());
                ingredientList.remove(ingredientName);
                if(ingredientList.isEmpty()){
                    throw new InvalidInputException("You cannot remove all ingredient :"+input);
                }
            }
        }
        return calculatedPrice;
    }

    public boolean isNullOrEmptyInput(String inputData){
        if(inputData==null || "null".equalsIgnoreCase(inputData) || inputData.isEmpty()){
            return true;
        } else{
            return false;
        }
    }
}
