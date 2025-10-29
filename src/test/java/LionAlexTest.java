import com.example.Feline;
import com.example.LionAlex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    private Feline mockFeline;

    private LionAlex lionAlex;

    @Before  //перед каждым методом настраиваю заглушку
    public void setUp() throws Exception{
        Mockito.when(mockFeline.getFood("Хищник"))
                .thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        lionAlex=new LionAlex(mockFeline);
    }

@Test  //тест на соответсвие списка друзей
    public void testGetFriends(){
    List<String> expectedFriends=Arrays.asList("Марти", "Глория", "Мелман");
    List<String> actualFriends=lionAlex.getFriends();
    Assert.assertEquals("Список друзей должен совпадать с ожидаемым",expectedFriends,actualFriends);
}

@Test  //тест на место проживания Алекса
    public void testGetPlaceOfLiving(){
        String expectedPlaceOfLiving="Нью-Йоркский зоопарк";
        String actualPlaceOfLiving=lionAlex.getPlaceOfLiving();
        Assert.assertEquals("Место жительства должно совпадать с ожидаемым",expectedPlaceOfLiving,actualPlaceOfLiving);
}

@Test  //тест на отсутствие львят
    public void testGetKittens(){
        int expectedKittens=0;
        int actualKittens=lionAlex.getKittens();
        Assert.assertEquals("У льва Алекса пока нет львят",expectedKittens,actualKittens);
}

@Test  //тест на соответствие списка корма
    public void testGetFood() throws Exception {
    List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
    List<String> actualFood = lionAlex.getFood();
    Assert.assertEquals("Еда должна соответствовать львам", expectedFood, actualFood);
}

}
