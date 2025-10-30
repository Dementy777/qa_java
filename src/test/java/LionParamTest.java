import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {

private final String sex; //поле для входных данных- пола животного
private final boolean expectedHasMane;  // ожидаемый результат
private Feline feline;  // объект класса Feline

    public LionParamTest(String sex, boolean expectedHasMane) {  // конструктор для приема параметров
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "{index}: Пол животного={0}, грива={1}")  // данные для параметризации
    public static Iterable<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }
    @Before
    public void setUp(){
        feline=new Feline();
    }

    @Test  // сам тест на наличие гривы
    public void testDoesHaveMane()throws Exception{
        Lion lion=new Lion(sex,feline);
        assertEquals("Неверное наличие гривы",expectedHasMane,lion.doesHaveMane());
    }
}
