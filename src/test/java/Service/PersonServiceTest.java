package Service;

import com.example.Telegram_mby.Service.PersonService;
import com.example.Telegram_mby.Service.PersonServiceImpl;
import com.example.Telegram_mby.model.Person;
import com.example.Telegram_mby.repository.RepositoryUser;;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    RepositoryUser repositoryUser;
    @InjectMocks
    PersonServiceImpl personService;

    @Test
    void testGetPerson() {
    }
}
