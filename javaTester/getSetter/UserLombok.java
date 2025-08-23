package getSetter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLombok {
    @Getter(AccessLevel.PROTECTED)
    private String firstName;
    private String lastName;
    private String email;

}
