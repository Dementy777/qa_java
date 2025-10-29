import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;

    @Mock
    private Feline mockFeline;

    @Before
    public void setUp(){
         cat=new Cat(mockFeline);
    }

    @Test
    public void testGetSound(){
        Assert.assertEquals(" метод должен вернуть \"Мяу\"","Мяу",cat.getSound());
    }

    @Test
    public void testGetFoodSuccess() throws Exception{
        Mockito.when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food=cat.getFood();
        Assert.assertTrue("Список еды должен содержать: Животные, Птицы, Рыба", food.containsAll(List.of("Животные", "Птицы", "Рыба")));
        Assert.assertEquals("В списке должно быть три элемента",3,food.size());
        Mockito.verify(mockFeline).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodException()throws Exception{
        Mockito.when(mockFeline.eatMeat()).thenThrow(new Exception("Нет корма"));
        cat.getFood();
        Mockito.verify(mockFeline).eatMeat();
    }
}
