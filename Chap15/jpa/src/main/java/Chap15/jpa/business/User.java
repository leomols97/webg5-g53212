package Chap15.jpa.business;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String login;
    private String name;
}