import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Employees;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EmployeeDAO {


    public static List<Employees> fetchEmployees(){
      
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature
                .FAIL_ON_UNKNOWN_PROPERTIES);
        File file = new File(System.getProperty("user.home"), "Downloads");
        try {
           return mapper.readValue(new File(file, "employees.json"), new TypeReference<List<Employees>>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
