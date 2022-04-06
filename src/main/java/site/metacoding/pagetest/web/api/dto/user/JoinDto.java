package site.metacoding.pagetest.web.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.pagetest.domain.Usertbl;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinDto {
    private String username;
    private String password;
    private String phone;

    public Usertbl toEntity() {
        Usertbl user = new Usertbl();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setPhone(this.phone);
        return user;
    }
}