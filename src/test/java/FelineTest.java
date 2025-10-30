
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {  //метод создающий экземпляр Feline перед каждым тестом
        feline = new Feline();
    }



    @Test  //разделил проверку на пять разных плюс проверка исключения
    public void testEatMeat_ReturnsNonNullList() throws Exception {
        List<String> foodList = feline.eatMeat();
        Assert.assertNotNull(foodList);
    }

    @Test
    public void testEatMeat_ListHasSizeThree() throws Exception{
        List<String> foodList = feline.eatMeat();
        assertEquals(3, foodList.size());
    }

    @Test
    public void testEatMeat_ContainsAnimals() throws Exception{
        List<String> foodList = feline.eatMeat();
        Assert.assertTrue(foodList.contains("Животные"));
    }

    @Test
    public void testEatMeat_ContainsBirds() throws Exception{
        List<String> foodList = feline.eatMeat();
        Assert.assertTrue(foodList.contains("Птицы"));
    }

    @Test
    public void testEatMeat_ContainsFish() throws Exception{
        List<String> foodList = feline.eatMeat();
        Assert.assertTrue(foodList.contains("Рыба"));
    }

    @Test
    public void testEatMeat_NoExceptionThrown() throws Exception {
        List<String> foodList = feline.eatMeat();
        Assert.assertNotNull(foodList);
    }

    @Test
    public void testGetFamily() {  //тест для проверки метода getFamily()

        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void testGetKittensDefault() { // тест для проверки метода getKittens() без параметра и с дефолтным параметром
        int kittens = feline.getKittens();
        Assert.assertEquals(1, kittens);
    }

    @Test
    public void testGetKittensWithParameters() { //тест для проверки метода getKittens() с параметром
        int testValue = 5;
        int kittens = feline.getKittens(testValue);
        Assert.assertEquals(testValue, kittens);
    }
}

