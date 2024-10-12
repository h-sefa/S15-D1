package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>() ;

    public static  void addItems(String input){
        String[] addedArray = input.split(",");
        for(String array : addedArray){
            if(!groceryList.contains(array.trim())){
                groceryList.add(array.trim());
                printSorted();
            }

        }
    }
    public static void removeItems(String input){
        String[] removedArray = input.split(",");
        for(String array : removedArray){

            if(Grocery.checkItemIsInList(array.trim())){
                groceryList.remove(array.trim());
                printSorted();


            }
            else{
                System.out.println("Silmeye çalıştığınız değer ya da değerler listede bulunmamaktadır." + " İşleme alınamadı : " + array);
            }


        }
        Grocery.printSorted();
        groceryList.remove(input);
    }
    public static boolean checkItemIsInList(String product){
        return Grocery.groceryList.contains(product);
    }
    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }

    public void startGrocery() {

        Scanner scanner = new Scanner(System.in);
        String inputValue = "-1";


        while (!inputValue.equals("0")){
            System.out.println("Please type in here (0, 1 , 2)");
            inputValue= scanner.nextLine();
            if(inputValue.equals("1")){
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String addingElements = scanner.nextLine();

                String[] addedArray = addingElements.split(",");
                for(String array : addedArray){

                    if (Grocery.checkItemIsInList(array.trim())){
                        System.out.println("Eklemeye çelıştığınız değerler mevcut.");
                    }
                    else{
                        groceryList.add(array.trim());
                        Grocery.printSorted();

                    }
                    ;
                }
                //System.out.println(Arrays.toString(addedArray) + " eleman eklendi.");
            }
            else if(inputValue.equals("2")){
                System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
                String removingElements = scanner.nextLine();
                removeItems(removingElements);



            }
            else if(inputValue.equals("0")){
                System.out.println("Uygulama '0' girdisinden dolayı durduruluyor.");
            }
            else{
                System.out.println("Bu girilen değer : " + inputValue + " geçerli bir değer olmayıp sizden 0 , 1 ya da 2 bekleniyor...");
            }





        }


    }
}
