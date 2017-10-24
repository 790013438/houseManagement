package snippets.jee.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contacter {

    @Column(name = "contacterName")
    private String name;

    @Column(name = "contacterTel")
    private String tel;

    @Column(name = "contacterQQ")
    private String qq;

    @Column(name = "contacterEmail")
    private String email;
}
