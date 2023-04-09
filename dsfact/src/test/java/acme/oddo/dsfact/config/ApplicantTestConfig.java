package acme.oddo.dsfact.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"acme.oddo.dsfact"})
@EnableJpaRepositories(basePackages = "com.test.app")
// @EntityScan(basePackageClasses = {RocApplicant.class, RocApplicantsAttach.class, RocApplicantsAdm.class, RocApplicantsUser.class, RocApplicantsContact.class, })
@EntityScan(basePackages = "acme.oddo.dsfact.model.entities")
public class ApplicantTestConfig {

}
