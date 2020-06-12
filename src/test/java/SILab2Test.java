import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class SILab2Test {

    private final SILab2 siLab2 = new SILab2();

    //Every Statement Coverage

    //Test 1 :So pomosh na ovoj test se pominuvaat jazlite: 1,2,3,5,6,7,9,13,15,16,
                                                            // 6,7,9,11,13,14,15,16,
                                                            // 6,7,10,16,
                                                            // 6,7,9,11,12,13,15,16,
                                                            // 6,8
    @Test
    public void test1(){
        //Test niza: 0,0,#,0
        ArrayList<String> testArray=new ArrayList<>();
        testArray.add("0");
        testArray.add("0");
        testArray.add("#");
        testArray.add("0");

        //Treba da se dobie rezultat: 0,1,#,1
        ArrayList<String> resultArray=new ArrayList<>();
        resultArray.add("0");
        resultArray.add("1");
        resultArray.add("#");
        resultArray.add("1");

        assertEquals(siLab2.function(testArray),resultArray);
    }

    //Test 2 :So pomosh na ovoj test se pominuvaat jazlite: 1,2,4
    //Se frla IllegalArgumentException

    @Test(expected = IllegalArgumentException.class)
    public void test2(){
        ArrayList<String> testArray=new ArrayList<>();
        siLab2.function(testArray);
    }

    //Every Path Coverage
    @Test(expected = IllegalArgumentException.class)
    public void test3(){
        //1,2,5 => Vlezot e prazna niza, se frla IllegalArgumentException
        ArrayList<String> testArray1=new ArrayList<>();
        siLab2.function(testArray1);

        //1,2,3,5,6,7,10,16,8 => Vlezot ima samo simbol za bomba
        ArrayList<String> testArray2 = new ArrayList<>();
        testArray2.add("#");
        ArrayList<String> resultArray2 = new ArrayList<>();
        resultArray2.add("#");
        assertEquals(siLab2.function(testArray2),resultArray2);

        //1,2,3,5,6,7,9,11,13,15,16,6,8 => Vlezot ima samo broj 0
        ArrayList<String> testArray3=new ArrayList<>();
        testArray3.add("0");
        ArrayList<String> resultArray3=new ArrayList<>();
        resultArray3.add("0");
        assertEquals(siLab2.function(testArray3),resultArray3);

        //1,2,3,5,(6,7,9,11,13,15,16),6,7,9,11,13,14,15,16,6,7,10,16,6,8 => Vlezot ima simbol za bomba na kraj
        ArrayList<String> testArray4=new ArrayList<>();
        testArray4.add("0");
        testArray4.add("0");
        testArray4.add("#");
        ArrayList<String> resultArray4=new ArrayList<>();
        resultArray4.add("0");
        resultArray4.add("1");
        resultArray4.add("#");
        assertEquals(siLab2.function(testArray4),resultArray4);

        //1,2,3,5,6,7,10,16,6,7,9,11,12,13,15,16,(6,7,9,11,13,15,16),6,8 => Vlezot ima simbol za bomba na pochetok
        ArrayList<String> testArray5=new ArrayList<>();
        testArray5.add("#");
        testArray5.add("0");
        testArray5.add("0");
        ArrayList<String> resultArray5=new ArrayList<>();
        resultArray5.add("#");
        resultArray5.add("1");
        resultArray5.add("0");
        assertEquals(siLab2.function(testArray5),resultArray5);

        //1,2,3,5,(6,7,9,11,13,15,16),6,7,9,11,13,14,15,16,6,7,10,16,6,7,9,11,12,13,17,16,(6,7,9,11,13,15,16),6,8 => Vlezot ima simbol za bomba megju nulite
        ArrayList<String> testArray6=new ArrayList<>();
        testArray6.add("0");
        testArray6.add("0");
        testArray6.add("#");
        testArray6.add("0");
        testArray6.add("0");
        ArrayList<String> resultArray6=new ArrayList<>();
        resultArray6.add("0");
        resultArray6.add("1");
        resultArray6.add("#");
        resultArray6.add("1");
        resultArray6.add("0");
        assertEquals(siLab2.function(testArray6),resultArray6);

        //1,2,3,5,6,7,10,16,6,7,9,11,12,13,15,16,(6,7,9,11,13,15,16),6,7,9,11,13,14,15,16,6,7,10,16,6,8 => Vlezot ima simbol za bomba na kraevite
        ArrayList<String> testArray7=new ArrayList<>();
        testArray7.add("#");
        testArray7.add("0");
        testArray7.add("0");
        testArray7.add("0");
        testArray7.add("#");
        ArrayList<String> resultArray7=new ArrayList<>();
        resultArray7.add("#");
        resultArray7.add("1");
        resultArray7.add("0");
        resultArray7.add("1");
        resultArray7.add("#");
        assertEquals(siLab2.function(testArray7),resultArray7);

        //1,2,3,5,6,7,10,16,6,7,9,11,12,13,14,15,16,6,7,10,16,6,8 => Vlezot ima simbol za bomba na kraevite, i ima edna nula pomegju niv
        ArrayList<String> testArray8=new ArrayList<>();
        testArray8.add("#");
        testArray8.add("0");
        testArray8.add("#");
        ArrayList<String> resultArray8=new ArrayList<>();
        resultArray8.add("#");
        resultArray8.add("2");
        resultArray8.add("#");
        assertEquals(siLab2.function(testArray8),resultArray8);

    }


}
