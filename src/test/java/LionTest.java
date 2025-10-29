import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline mockFeline;

    private Lion maleLion;
    private Lion femaleLion;

    @Before  //настройка перед каждым тестом создает львов обоих полов
    public void setUp() throws Exception{
        maleLion=new Lion("Самец",mockFeline);
        femaleLion=new Lion("Самка", mockFeline);
    }

    @Test //тест для метода возвращающего количество котят
    public void testGetKittens(){
        Mockito.when(mockFeline.getKittens()).thenReturn(3);
        assertEquals("Метод должен вернуть 3 детеныша",3,maleLion.getKittens());
    }
    @Test
    public void testGetFood() throws Exception {
        // Настраиваем мок, чтобы getFood() вернул список хищников
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // Проверяем, что метод getFood() вернёт правильный список еды
        assertEquals("Метод должен вернуть список еды хищника", List.of("Животные", "Птицы", "Рыба"), femaleLion.getFood());
    }
}
