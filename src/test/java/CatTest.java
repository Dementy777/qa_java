import com.example.Cat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @InjectMocks
    private Cat cat;

    @Test
    public void testGetSound(){
        Assert.assertEquals("Мяу",cat.getSound());
    }
}
