package com.framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class MyFirstTest {


   @Test
    void myFirstTest(){
       int result = sum(2, 3);

      Assert.assertEquals( result, 4);
   }

   static int sum(int a, int b){
       return a + b;
   }


}
