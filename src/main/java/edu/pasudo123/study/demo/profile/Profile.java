package edu.pasudo123.study.demo.profile;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "profile")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    /** https://www.youtube.com/watch?v=qRWhFkB1D8c&ab_channel=ThorbenJanssen **/
    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private ProfileDetail detail;

    @Column(name = "reg_date", nullable = false)
    private LocalDateTime regDate;

    @Builder
    public Profile(final String name, final ProfileDetail detail) {
        this.name = name;
        this.regDate = LocalDateTime.now();
        this.detail = detail;
        detail.initProfile(this);
    }
}
