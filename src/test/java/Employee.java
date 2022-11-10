import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {

    private String name;

    private String position;

    private String office;

    public Employee() {
    }
}
