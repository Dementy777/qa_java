
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline; //создал объект для тестов

    @Before
    public void setUp(){  //метод создающий экземпляр Feline перед каждым тестом
        feline=new Feline();
    }


    @Test
    public void testEatMeat()  { //тест для метода eatMeat()
        try{
            List<String> foodList=feline.eatMeat();
            Assert.assertNotNull(foodList);
            assertEquals(3,foodList.size());
            Assert.assertTrue(foodList.contains("Животные"));
            Assert.assertTrue(foodList.contains("Птицы"));
            Assert.assertTrue(foodList.contains("Рыба"));
        } catch (Exception e) {
            Assert.fail("Не ожидалось исключение при вызове eatMeat()");
        }
    }
@Test
    public void testGetFamily(){  //тест для проверки метода getFamily()

        String family=feline.getFamily();
        assertEquals("Кошачьи",family);
}

@Test
    public void testGetKittensDefault(){ // тест для проверки метода getKittens() без параметра и с дефолтным параметром
        int kittens=feline.getKittens();
        Assert.assertEquals(1,kittens);
}
@Test
    public void testGetKittensWihtParameters(){ //тест для проверки метода getKittens() с параметром
        int testValue=5;
        int kittens=feline.getKittens(testValue);
        Assert.assertEquals(testValue,kittens);

}


}

