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
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline mockFeline;

    private Lion maleLion;
    private Lion femaleLion;

    // удалил создание избыточного объекта внедрил их в тесты

    @Test //тест для метода возвращающего количество котят
    public void testGetKittens() throws Exception{
        Lion lion = new Lion("Самец", mockFeline);
        Mockito.when(mockFeline.getKittens()).thenReturn(3);
        assertEquals("Метод должен вернуть 3 детеныша",3,lion.getKittens());
    }
    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самка", mockFeline);
        // Настраиваем мок, чтобы getFood() вернул список хищников
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // Проверяем, что метод getFood() вернёт правильный список еды
        assertEquals("Метод должен вернуть список еды хищника", List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test //исправил метод проверки не только факта, но и текст исключения
    public void testInvalidSex() {
        try {
            new Lion("Несамецнесамка", mockFeline);
            fail("Должно быть выброшено исключение с сообщением о недопустимом поле");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }
}
